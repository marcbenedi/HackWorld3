package com.stirhack.hackworld;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<Hackathon> {

    public MyAdapter(Context context, int resource, ArrayList<Hackathon> items) {
        //Resource is item_list.xml
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.item_list, parent, false);

        Hackathon single_item = getItem(position);
        TextView name = (TextView)item.findViewById(R.id.item_name);
        TextView when = (TextView)item.findViewById(R.id.item_when);
        TextView where = (TextView)item.findViewById(R.id.item_where);
        TextView link = (TextView)item.findViewById(R.id.item_link);

        name.setText(single_item.getName());
        when.setText(single_item.getWhen());
        where.setText(single_item.getWhere());
        link.setText(single_item.getLink());


        return item;
    }
}
