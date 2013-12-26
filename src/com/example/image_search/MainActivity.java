
package com.example.image_search;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";
    private ListView listView;

    private OnClickListener mButtonListener = new OnClickListener(){
        @Override
        public void onClick(View v){
            Log.i(TAG,"click Button");

            EditText textField = (EditText)findViewById(R.id.editText1);
            String text = textField.getText().toString();
            Log.i(TAG,text);

            //int[] data = new int[] {10,9,8,7,6,5,4,3,2,1};

            String url1 = "http://lh5.ggpht.com/_mrb7w4gF8Ds/TCpetKSqM1I/AAAAAAAAD2c/Qef6Gsqf12Y/s144-c/_DSC4374%20copy.jpg";
            String url2 = "http://lh5.ggpht.com/_mrb7w4gF8Ds/TCpetKSqM1I/AAAAAAAAD2c/Qef6Gsqf12Y/s144-c/_DSC4374%20copy.jpg";
            String[] urls = {url1,url2};
            new SearchImage().execute(urls);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.button1);
        button.setOnClickListener(mButtonListener);

        listView = (ListView)findViewById(R.id.listView1);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private class SearchImage extends AsyncTask<String,Void,Bitmap[]>{

        @Override
        protected Bitmap[] doInBackground(String...params) {
            // TODO Auto-generated method stub
            //String result = params[0] +"@fafa";

            Bitmap r1 = ImageSearch.downloadBitmap(params[0]);
            Bitmap r2 = ImageSearch.downloadBitmap(params[1]);
            Bitmap[] result = {r1, r2};
            return result;
        }

        @Override
        protected void onPostExecute(Bitmap[] result) {
            // Log.i(TAG,result);
            ImageAdapter imageAdapter = new ImageAdapter(result);
            listView.setAdapter(imageAdapter);
        }
    }
}
