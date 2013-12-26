package com.example.image_search;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.http.AndroidHttpClient;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;

import java.io.InputStream;

public class ImageSearch {
    private static final String LOG_TAG = "ImageSearch";

    public static Bitmap downloadBitmap(String url){
        final AndroidHttpClient client = AndroidHttpClient.newInstance("Android");
        final HttpGet getRequest = new HttpGet(url);

        try{
            HttpResponse response = client.execute(getRequest);
            final int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK){
                Log.w(LOG_TAG, "Error" + statusCode + " while retrieving bitmap from " + url);
                return null;
            }
            final HttpEntity entity = response.getEntity();
            if (entity != null) {
                InputStream inputStream = null;
                try {
                    inputStream = entity.getContent();
                    final Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                    //return Integer.toString(bitmap.getHeight());
                    return bitmap;
                } finally {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    entity.consumeContent();
                }
            }

        }catch (Exception e){
            getRequest.abort();
            Log.w(LOG_TAG,"Error while retrieving bitmap from " + url);
            Log.w(LOG_TAG,e.toString());
        }finally{
            if (client != null){
                client.close();
            }
        }
        return null;
    }
}
