package com.example.image_search;

import android.annotation.TargetApi;
import android.os.Build;
import android.text.Html;
import android.util.JsonReader;
import android.util.Log;

// import com.google.common.collect.Lists;
//import com.google.common.io.Closeables;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Parser for JSON image metadata in the standard GSA image metadata format.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)

public class ImageMetadataParser {
    private static final String TAG = "ImageMetadataParser";

    private static final String ID_KEY = "id";
    private static final String HEIGHT_KEY = "oh";
    private static final String WIDTH_KEY = "ow";
    private static final String URL_KEY = "ou";
    private static final String SOURCE_DOMAIN_KEY = "rh";
    private static final String SOURCE_KEY = "ru";
    private static final String TITLE_KEY = "pt";
    private static final String SNIPPET_KEY = "s";
    private static final String THUMBNAILS_KEY = "th";
    private static final String THUMB_HEIGHT_KEY = "h";
    private static final String THUMB_WIDTH_KEY = "w";
    private static final String THUMB_URL_KEY = "u";


    public List<VelvetImage> readJson(String json) throws IOException{
        JsonReader reader = new JsonReader(new StringReader(json));
        try {
            return readImageArray(reader);
        } catch (IOException ex) {
            Log.e(TAG, "Error whilst parsing metadata:", ex);
            return null;
        } finally {
           // Closeables.closeQuietly(reader);
            reader.close();
        }
    }

    private List<VelvetImage> readImageArray(JsonReader reader) throws IOException {
        // List<VelvetImage> images = Lists.newArrayList();
        List<VelvetImage> images = new ArrayList<VelvetImage>();
        try {
            reader.beginArray();
            while(reader.hasNext()) {
                VelvetImage image = readImage(reader);
                if (image != null) {
                    images.add(image);
                }
            }
            reader.endArray();
        } catch (IllegalStateException ex) {
            Log.e(TAG, "Error whilst parsing metadata:", ex);
            return images;
        }
        return images;
    }

    private VelvetImage readImage(JsonReader reader) throws IOException {
        VelvetImage image = new VelvetImage();
        reader.beginObject();
        while(reader.hasNext()) {
            String key = reader.nextName();
            if (key.equals(ID_KEY)) {
                image.setId(reader.nextString());
            } else if (key.equals(HEIGHT_KEY)) {
                image.setHeight(reader.nextInt());
            } else if (key.equals(WIDTH_KEY)) {
                image.setWidth(reader.nextInt());
            } else if (key.equals(URL_KEY)) {
                image.setUri(reader.nextString());
            } else if (key.equals(SOURCE_DOMAIN_KEY)) {
                image.setDomain(reader.nextString());
            } else if (key.equals(SOURCE_KEY)) {
                image.setSourceUri(reader.nextString());
            } else if (key.equals(SNIPPET_KEY)) {
                image.setSnippet(reader.nextString());
            } else if (key.equals(TITLE_KEY)) {
                image.setName(Html.fromHtml(reader.nextString()).toString());
            } else if (key.equals(THUMBNAILS_KEY)) {
                List<Thumbnail> thumbnails = readThumbnailArray(reader);
                // Use last thumbnail only for now
                if (thumbnails.size() > 0) {
                    Thumbnail activeThumbnail = thumbnails.get(thumbnails.size() - 1);
                    image.setThumbnailHeight(activeThumbnail.height);
                    image.setThumbnailWidth(activeThumbnail.width);
                    image.setThumbnailUri(activeThumbnail.url);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        // Make sure we have the minimum viable VelvetImage
        if (image.getUri() == null || image.getThumbnailUri() == null) {
            Log.v(TAG, "Rejecting image " + image.toString() + ", has empty url or thumbnail url");
            return null;
        }
        // If the image does not have a title, use the domain
        if ((image.getName() == null || image.getName().isEmpty())) {
            Log.v(TAG, "Image has no name, using domain instead");
            image.setName(image.getDomain());
        }
        return image;
    }

    private List<Thumbnail> readThumbnailArray(JsonReader reader) throws IOException {
        // List<Thumbnail> thumbnails = Lists.newArrayList();
        List<Thumbnail> thumbnails = new ArrayList<Thumbnail>();
        reader.beginArray();
        while (reader.hasNext()) {
            thumbnails.add(readThumbnail(reader));
        }
        reader.endArray();
        return thumbnails;
    }

    private Thumbnail readThumbnail(JsonReader reader) throws IOException {
        Thumbnail thumbnail = new Thumbnail();
        reader.beginObject();
        while(reader.hasNext()) {
            String key = reader.nextName();
            if (key.equals(THUMB_HEIGHT_KEY)) {
                thumbnail.height = reader.nextInt();
            } else if(key.equals(THUMB_WIDTH_KEY)) {
                thumbnail.width = reader.nextInt();
            } else if(key.equals(THUMB_URL_KEY)) {
                thumbnail.url = reader.nextString();
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return thumbnail;
    }


    private class Thumbnail {
        public int width;
        public int height;
        public String url;
    }
}