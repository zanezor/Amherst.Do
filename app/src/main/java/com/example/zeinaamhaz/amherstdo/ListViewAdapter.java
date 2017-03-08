package com.example.zeinaamhaz.amherstdo;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

public class ListViewAdapter extends BaseAdapter {

    // Declare Variables
    Context mContext;
    LayoutInflater inflater;
    private List<Item> initiallist = null;
    private ArrayList<Item> arraylist;

    public ListViewAdapter(Context context, List<Item> initiallist) {
        mContext = context;
        this.initiallist = initiallist;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<Item>();
        this.arraylist.addAll(initiallist);
    }


    @Override
    public int getCount() {
        return initiallist.size();
    }

    @Override
    public Item getItem(int position) {
        return initiallist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
        convertView = inflater.inflate(R.layout.listview_item, parent, false);
        final TextView urgency = (TextView) convertView.findViewById(R.id.urgency);
        final TextView todoItem = (TextView) convertView.findViewById(R.id.todoItem);
        final TextView description = (TextView) convertView.findViewById(R.id.description);
        final CheckBox cb = (CheckBox) convertView.findViewById(R.id.cbDone);

        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (cb.isChecked()) {
                    urgency.setPaintFlags(urgency.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                    todoItem.setPaintFlags(todoItem.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                    description.setPaintFlags(description.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                } else {
                    urgency.setPaintFlags(urgency.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                    todoItem.setPaintFlags(todoItem.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                    description.setPaintFlags(description.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                }
            }
        });

        urgency.setText(initiallist.get(position).getUrgency());
        todoItem.setText(initiallist.get(position).getTodoItem());
        description.setText(initiallist.get(position).getDescription());

        return convertView;

    }

    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        initiallist.clear();
        if (charText.length() == 0) {
            initiallist.addAll(arraylist);
        } else {
            for (Item wp : arraylist) {
                if (wp.getTodoItem().toLowerCase(Locale.getDefault()).contains(charText) || wp.getDescription().toLowerCase(Locale.getDefault()).contains(charText)) {
                    initiallist.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }

}
