package com.example.zeinaamhaz.amherstdo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    ListView list;
    ListViewAdapter adapter;
    EditText editsearch;
    String[] urgency;
    String[] todoItem;
    String[] description;
    public String clear = "";
    Boolean[] done;
    ArrayList<Item> arraylist = new ArrayList<Item>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Generate sample data
        urgency = new String[] { "Urgent", "Important", "Beneficial", "Urgent", "Beneficial", "Important"};

        todoItem = new String[] { "Study for Econ", "CS Project", "Sleep",
                "Study for Math", "Problem Set", "Exercise"};

        description = new String[] { "Review notes", "Debug project",
                "by 11pm", "Go to OH", "Look over problem set", "Go to gym"};

        done = new Boolean[] {false, false, false, false, false, false};

        // Locate the ListView in listview_main.xml
        list = (ListView) findViewById(R.id.listview);

        for (int i = 0; i < urgency.length; i++)
        { Item wp = new Item(urgency[i], todoItem[i], description[i], done[i]);
            arraylist.add(wp);
        }

        adapter = new ListViewAdapter(this, arraylist);
        list.setAdapter(adapter);
        editsearch = (EditText) findViewById(R.id.search);

        Button btnSearch = (Button) findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editsearch.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(text);
            }
        });

        Button btnClear = (Button) findViewById(R.id.btnClear);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.filter(clear);
                editsearch.setText("");

            }
        });


    }
}
