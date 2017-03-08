package com.example.zeinaamhaz.amherstdo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by zeinaamhaz on 3/7/17.
 */

public class SingleItem extends Activity{

        // Declare Variables
        TextView txtrank;
        TextView txtcountry;
        TextView txtpopulation;
        ImageView imgflag;
        String rank;
        String country;
        String population;
        int flag;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_single_item);
            Intent i = getIntent();
            rank = i.getStringExtra("urgency");
            country = i.getStringExtra("todoItem");
            population = i.getStringExtra("description");
            flag = i.getIntExtra("flag", flag);

            txtrank = (TextView) findViewById(R.id.urgency);
            txtcountry = (TextView) findViewById(R.id.todoItem);
            txtpopulation = (TextView) findViewById(R.id.description);

            txtrank.setText(rank);
            txtcountry.setText(country);
            txtpopulation.setText(population);

        }
    }
