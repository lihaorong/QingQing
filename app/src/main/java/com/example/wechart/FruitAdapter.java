package com.example.wechart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Lenovo on 2017/11/23.
 */

public class FruitAdapter extends ArrayAdapter {

    private int resourceId;
    public FruitAdapter(Context context, int textViewResourceId, List<Fruit> objects){
        super( context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }
    public View getView (int position, View convertView, ViewGroup parent) {
        Fruit fruit =(Fruit)getItem(position);//获取当前的fruit实例
        View view;
        ViewHolder viewHolder;
        if(convertView ==null){
            view  = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.fruitImage = (ImageView)view.findViewById(R.id.fruit_image);
            viewHolder.fruitName = (TextView)view.findViewById(R.id.fruit_name);
            view.setTag(viewHolder);
        }else{
            view = convertView;
            viewHolder = (ViewHolder)view.getTag();
        }

        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        viewHolder.fruitName.setText(fruit.getName());
        return view;

    }

    private class ViewHolder {
        ImageView fruitImage;
        TextView fruitName;
    }
}
