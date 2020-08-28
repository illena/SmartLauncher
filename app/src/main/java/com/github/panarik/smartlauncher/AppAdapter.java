package com.github.panarik.smartlauncher;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AppAdapter extends BaseAdapter {

    Context context;
    List<AppObject> appList;

    public AppAdapter(Context context, List<AppObject> appList){
        this.context = context;
        this.appList = appList;

    }

    @Override
    public int getCount() {
        return appList.size();
    }

    @Override
    public Object getItem(int position) {
        return appList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v;
        if(convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        v = layoutInflater.inflate(R.layout.item_app, parent, false);

        }else {
            v = convertView;
        }

        ImageView mImage = v.findViewById(R.id.app_imageView);
        TextView mLabel = v.findViewById(R.id.app_Label);

        mImage.setImageDrawable(appList.get(position).getImage());
        mLabel.setText(appList.get(position).getName());

        return v;
    }
}
