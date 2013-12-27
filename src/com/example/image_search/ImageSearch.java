package com.example.image_search;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.http.AndroidHttpClient;
import android.util.Log;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;


import java.io.InputStream;
import java.util.List;

public class ImageSearch {
    private static final String LOG_TAG = "ImageSearch";

    public static Bitmap downloadBitmap(String url){
        Log.i(LOG_TAG,url);
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
                //InputStream inputStream = null;
                //String entity_string = EntityUtils.toString(entity);
                //Log.i(LOG_TAG," ENTITY_BODY_SIZE "+entity_string.length());

                //Log.i(LOG_TAG," ENTITY_STRING " + entity_string);
                InputStream inputStream = entity.getContent();
                String json = IOUtils.toString(inputStream, "UTF-8");

                Log.i(LOG_TAG," INPUT_STREAM " + json);
                String trial = "[{\"id\":\"exFJ0a7ITTfQPM:\",\"oh\":800,\"ow\":1200,\"os\":\"75KB\",\"ou\":\"http:\\/\\/upload.wikimedia.org\\/wikipedia\\/commons\\/5\\/56\\/Macaroons_in_detail.jpg\",\"rh\":\"en.wikipedia.org\",\"ru\":\"http:\\/\\/en.wikipedia.org\\/wiki\\/Macaroon\",\"pt\":\"\\u003Cb\\u003EMacaroon\\u003C\\/b\\u003E - Wikipedia, the free encyclopedia\",\"s\":\"Coconut \\u003Cb\\u003Emacaroon\\u003C\\/b\\u003E closeup\",\"th\":[{\"h\":100,\"w\":150,\"u\":\"http:\\/\\/t1.gstatic.com\\/images?q=tbn:ANd9GcQJ7bR0qQGBG8WgGiwgILFV8cejUKxutLaQ5eRTc3wLQYEy-GhcXw\"}]},{\"id\":\"B2KwKtKuiMvsLM:\",\"oh\":375,\"ow\":500,\"os\":\"153KB\",\"ou\":\"http:\\/\\/mobile-cuisine.com\\/wp-content\\/uploads\\/2012\\/05\\/macaroons.jpg\",\"rh\":\"mobile-cuisine.com\",\"ru\":\"http:\\/\\/mobile-cuisine.com\\/did-you-know\\/macaroon-fun-facts\\/\",\"pt\":\"\\u003Cb\\u003EMacaroon\\u003C\\/b\\u003E Fun Facts | Mobile Cuisine | Gourmet Food Trucks \\u003Cb\\u003E...\\u003C\\/b\\u003E\",\"s\":\"For today\\u0026#39;s Did You Know food fun facts we will look at \\u003Cb\\u003EMacaroons\\u003C\\/b\\u003E.\",\"th\":[{\"h\":98,\"w\":130,\"u\":\"http:\\/\\/t0.gstatic.com\\/images?q=tbn:ANd9GcSlzw6JrjtgiNP6Tu65sEGYmY-Y7J1DILAr_ardpeCqrrB5-apI\"}]},{\"id\":\"6114YjYep8UD5M:\",\"oh\":1749,\"ow\":2332,\"os\":\"574KB\",\"ou\":\"http:\\/\\/sweetandsaucy.files.wordpress.com\\/2009\\/12\\/coconut_apricot_macaroons.jpg\",\"rh\":\"sweetandsaucy.wordpress.com\",\"ru\":\"http:\\/\\/sweetandsaucy.wordpress.com\\/2009\\/12\\/11\\/coconut-apricot-macaroons\\/\",\"pt\":\"Coconut-Apricot \\u003Cb\\u003EMacaroons\\u003C\\/b\\u003E | Sweet and Saucy\",\"s\":\"I\\u0026#39;m used to \\u003Cb\\u003Emacaroons\\u003C\\/b\\u003E without dried fruit, so the apricot bits added \\u003Cb\\u003E...\\u003C\\/b\\u003E\",\"th\":[{\"h\":113,\"w\":150,\"u\":\"http:\\/\\/t0.gstatic.com\\/images?q=tbn:ANd9GcTkcDmyWASqsnhwlMxWd1lyPIZ3JYjbWUx2dh0W-igd7yhkTaoQrg\"}]},{\"id\":\"4PA0TjXnjb9t5M:\",\"oh\":768,\"ow\":1024,\"os\":\"155KB\",\"ou\":\"http:\\/\\/stupidstation.s3.amazonaws.com\\/362\\/tss_1375714952_5.jpg\",\"rh\":\"thestupidstation.com\",\"ru\":\"http:\\/\\/www.thestupidstation.com\\/home\\/image\\/362\\/4041\\/The-Most-Expensive-Desserts\",\"pt\":\"\\u003Cb\\u003EMacaroons\\u003C\\/b\\u003E Haute Couture - $7,414\",\"s\":\"Not all of the \\u003Cb\\u003Emacaroons\\u003C\\/b\\u003E are this expensive, but if you choose the right \\u003Cb\\u003E...\\u003C\\/b\\u003E\",\"th\":[{\"h\":113,\"w\":150,\"u\":\"http:\\/\\/t0.gstatic.com\\/images?q=tbn:ANd9GcTpJoDp51ICB9MhIttVzBe3DeUBdO7CLA4-CphPomDsNSn4k_-p7A\"}]},{\"id\":\"f06ftEpxymVh7M:\",\"oh\":1200,\"ow\":1600,\"os\":\"184KB\",\"ou\":\"http:\\/\\/2.bp.blogspot.com\\/-rlM29JdPhH8\\/UKZlyFdFJHI\\/AAAAAAAAGE4\\/6LjIEj023fA\\/s1600\\/orangechoccocomacaroons.jpg\",\"rh\":\"pastrystudio.blogspot.com\",\"ru\":\"http:\\/\\/pastrystudio.blogspot.com\\/2012\\/11\\/orange-chocolate-coconut-macaroons.html\",\"pt\":\"pastry studio: Orange \\u0026amp; Chocolate Coconut \\u003Cb\\u003EMacaroons\\u003C\\/b\\u003E\",\"s\":\"Coconut \\u003Cb\\u003Emacaroons\\u003C\\/b\\u003E are an old standby, the gold standard sought out by \\u003Cb\\u003E...\\u003C\\/b\\u003E\",\"th\":[{\"h\":113,\"w\":150,\"u\":\"http:\\/\\/t3.gstatic.com\\/images?q=tbn:ANd9GcTwA-awiNjTycs9t9hfZcDMTW8fxpoiD46-8v_uA3uH8tGmm680\"}]},{\"id\":\"5hBiST3KNAmMmM:\",\"oh\":1247,\"ow\":1475,\"os\":\"493KB\",\"ou\":\"http:\\/\\/3.bp.blogspot.com\\/-oqexYeAQrJ0\\/T7XUfo7QWyI\\/AAAAAAAABWI\\/XF9RuRoVXaU\\/s1600\\/macaroons-019.jpeg\",\"rh\":\"1velvetchandelier.blogspot.com\",\"ru\":\"http:\\/\\/1velvetchandelier.blogspot.com\\/2012\\/05\\/parisian-macaroons.html\",\"pt\":\"Velvet Chandelier: Parisian \\u003Cb\\u003Emacaroons\\u003C\\/b\\u003E\",\"s\":\"The best \\u003Cb\\u003EMacaroons\\u003C\\/b\\u003E I have had recently have come from Trader Joe\\u0026#39;s.\",\"th\":[{\"h\":127,\"w\":150,\"u\":\"http:\\/\\/t2.gstatic.com\\/images?q=tbn:ANd9GcQ3NPwijioNWdah68MfP8904ZFJc5ERZcESM_NFFed00no_Vcu0\"}]}]";
                ImageMetadataParser imageParser = new ImageMetadataParser();

                List<VelvetImage> imageList = imageParser.readJson(trial);
                VelvetImage image = imageList.get(0);
                String uri = image.getUri();
                return download(uri); /*finally {

                    if (inputStream != null) {
                        inputStream.close();
                    }
                    entity.consumeContent();
                }*/
            }

        }catch (Exception e){
            getRequest.abort();
            Log.w(LOG_TAG,"Catch Exception" + url);
            Log.w(LOG_TAG,e.toString());
        }finally{
            if (client != null){
                client.close();
            }
        }
        return null;
    }

    public static Bitmap download(String url){
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
