package com.example.image_search;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ImageAdapter extends BaseAdapter{

    private final List<Bitmap> values;
    //private final int[] values = new int[] {10,9,8,7,6,5,4,3,2,1};

    public ImageAdapter(List<Bitmap> data){
        values = data;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return values.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return values.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return values.get(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        if(convertView == null){
            //convertView = new TextView(parent.getContext());
            convertView = new ImageView(parent.getContext());
            convertView.setPadding(6,6,6,6);
        }
        //((TextView) convertView).setText(Integer.toString(values[position]));
        ((ImageView) convertView).setImageBitmap(values.get(position));
        return convertView;
    }

}
