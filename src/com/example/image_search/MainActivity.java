
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

import java.io.IOException;
import java.util.List;

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
            //String url2 = "http://www.google.com/search?tbm=isch&biw=100&bih=200&ifm=1&ijn=0&start=0&q=macaroons&deb=0gsa1mobile1";
            String[] urls = {url1};
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

            Bitmap r1 = ImageSearch.download(params[0]);
            //Bitmap r2 = ImageSearch.downloadBitmap(params[1]);
            String trial = "[{\"id\":\"exFJ0a7ITTfQPM:\",\"oh\":800,\"ow\":1200,\"os\":\"75KB\",\"ou\":\"http:\\/\\/upload.wikimedia.org\\/wikipedia\\/commons\\/5\\/56\\/Macaroons_in_detail.jpg\",\"rh\":\"en.wikipedia.org\",\"ru\":\"http:\\/\\/en.wikipedia.org\\/wiki\\/Macaroon\",\"pt\":\"\\u003Cb\\u003EMacaroon\\u003C\\/b\\u003E - Wikipedia, the free encyclopedia\",\"s\":\"Coconut \\u003Cb\\u003Emacaroon\\u003C\\/b\\u003E closeup\",\"th\":[{\"h\":100,\"w\":150,\"u\":\"http:\\/\\/t1.gstatic.com\\/images?q=tbn:ANd9GcQJ7bR0qQGBG8WgGiwgILFV8cejUKxutLaQ5eRTc3wLQYEy-GhcXw\"}]},{\"id\":\"B2KwKtKuiMvsLM:\",\"oh\":375,\"ow\":500,\"os\":\"153KB\",\"ou\":\"http:\\/\\/mobile-cuisine.com\\/wp-content\\/uploads\\/2012\\/05\\/macaroons.jpg\",\"rh\":\"mobile-cuisine.com\",\"ru\":\"http:\\/\\/mobile-cuisine.com\\/did-you-know\\/macaroon-fun-facts\\/\",\"pt\":\"\\u003Cb\\u003EMacaroon\\u003C\\/b\\u003E Fun Facts | Mobile Cuisine | Gourmet Food Trucks \\u003Cb\\u003E...\\u003C\\/b\\u003E\",\"s\":\"For today\\u0026#39;s Did You Know food fun facts we will look at \\u003Cb\\u003EMacaroons\\u003C\\/b\\u003E.\",\"th\":[{\"h\":98,\"w\":130,\"u\":\"http:\\/\\/t0.gstatic.com\\/images?q=tbn:ANd9GcSlzw6JrjtgiNP6Tu65sEGYmY-Y7J1DILAr_ardpeCqrrB5-apI\"}]},{\"id\":\"6114YjYep8UD5M:\",\"oh\":1749,\"ow\":2332,\"os\":\"574KB\",\"ou\":\"http:\\/\\/sweetandsaucy.files.wordpress.com\\/2009\\/12\\/coconut_apricot_macaroons.jpg\",\"rh\":\"sweetandsaucy.wordpress.com\",\"ru\":\"http:\\/\\/sweetandsaucy.wordpress.com\\/2009\\/12\\/11\\/coconut-apricot-macaroons\\/\",\"pt\":\"Coconut-Apricot \\u003Cb\\u003EMacaroons\\u003C\\/b\\u003E | Sweet and Saucy\",\"s\":\"I\\u0026#39;m used to \\u003Cb\\u003Emacaroons\\u003C\\/b\\u003E without dried fruit, so the apricot bits added \\u003Cb\\u003E...\\u003C\\/b\\u003E\",\"th\":[{\"h\":113,\"w\":150,\"u\":\"http:\\/\\/t0.gstatic.com\\/images?q=tbn:ANd9GcTkcDmyWASqsnhwlMxWd1lyPIZ3JYjbWUx2dh0W-igd7yhkTaoQrg\"}]},{\"id\":\"4PA0TjXnjb9t5M:\",\"oh\":768,\"ow\":1024,\"os\":\"155KB\",\"ou\":\"http:\\/\\/stupidstation.s3.amazonaws.com\\/362\\/tss_1375714952_5.jpg\",\"rh\":\"thestupidstation.com\",\"ru\":\"http:\\/\\/www.thestupidstation.com\\/home\\/image\\/362\\/4041\\/The-Most-Expensive-Desserts\",\"pt\":\"\\u003Cb\\u003EMacaroons\\u003C\\/b\\u003E Haute Couture - $7,414\",\"s\":\"Not all of the \\u003Cb\\u003Emacaroons\\u003C\\/b\\u003E are this expensive, but if you choose the right \\u003Cb\\u003E...\\u003C\\/b\\u003E\",\"th\":[{\"h\":113,\"w\":150,\"u\":\"http:\\/\\/t0.gstatic.com\\/images?q=tbn:ANd9GcTpJoDp51ICB9MhIttVzBe3DeUBdO7CLA4-CphPomDsNSn4k_-p7A\"}]},{\"id\":\"f06ftEpxymVh7M:\",\"oh\":1200,\"ow\":1600,\"os\":\"184KB\",\"ou\":\"http:\\/\\/2.bp.blogspot.com\\/-rlM29JdPhH8\\/UKZlyFdFJHI\\/AAAAAAAAGE4\\/6LjIEj023fA\\/s1600\\/orangechoccocomacaroons.jpg\",\"rh\":\"pastrystudio.blogspot.com\",\"ru\":\"http:\\/\\/pastrystudio.blogspot.com\\/2012\\/11\\/orange-chocolate-coconut-macaroons.html\",\"pt\":\"pastry studio: Orange \\u0026amp; Chocolate Coconut \\u003Cb\\u003EMacaroons\\u003C\\/b\\u003E\",\"s\":\"Coconut \\u003Cb\\u003Emacaroons\\u003C\\/b\\u003E are an old standby, the gold standard sought out by \\u003Cb\\u003E...\\u003C\\/b\\u003E\",\"th\":[{\"h\":113,\"w\":150,\"u\":\"http:\\/\\/t3.gstatic.com\\/images?q=tbn:ANd9GcTwA-awiNjTycs9t9hfZcDMTW8fxpoiD46-8v_uA3uH8tGmm680\"}]},{\"id\":\"5hBiST3KNAmMmM:\",\"oh\":1247,\"ow\":1475,\"os\":\"493KB\",\"ou\":\"http:\\/\\/3.bp.blogspot.com\\/-oqexYeAQrJ0\\/T7XUfo7QWyI\\/AAAAAAAABWI\\/XF9RuRoVXaU\\/s1600\\/macaroons-019.jpeg\",\"rh\":\"1velvetchandelier.blogspot.com\",\"ru\":\"http:\\/\\/1velvetchandelier.blogspot.com\\/2012\\/05\\/parisian-macaroons.html\",\"pt\":\"Velvet Chandelier: Parisian \\u003Cb\\u003Emacaroons\\u003C\\/b\\u003E\",\"s\":\"The best \\u003Cb\\u003EMacaroons\\u003C\\/b\\u003E I have had recently have come from Trader Joe\\u0026#39;s.\",\"th\":[{\"h\":127,\"w\":150,\"u\":\"http:\\/\\/t2.gstatic.com\\/images?q=tbn:ANd9GcQ3NPwijioNWdah68MfP8904ZFJc5ERZcESM_NFFed00no_Vcu0\"}]}]";
            ImageMetadataParser imageParser = new ImageMetadataParser();
            List<VelvetImage> imageList;
            String uri = null;
            try {
                imageList = imageParser.readJson(trial);
                VelvetImage image = imageList.get(0);
                uri = image.getUri();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            Bitmap r2 = ImageSearch.download(uri);
            Log.i("JSON_PARSOR",uri);

            Bitmap[] result = {r1,r2};
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
