package com.memory.mendybarouk.displaylist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    public static final int BACK_FROM_SECOND_ACTIVITY = 0;
    public static final String POSITION = "position";
    public static final String NAME = "name";

    String[] names = {"one", "two","three", "four", "five","one", "two","three", "four", "five","one", "two","three", "four", "five","one", "two","three", "four", "five"};
    ArrayAdapter<String>  stringArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        stringArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);

        ListView listView = (ListView) findViewById(R.id.list_view);


        listView.setOnItemClickListener(this);

        listView.setAdapter(stringArrayAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(this, SecondActivity.class);
        String data = (String) adapterView.getItemAtPosition(i);
        intent.putExtra(NAME, data);
        intent.putExtra(POSITION, i);

        startActivityForResult(intent, BACK_FROM_SECOND_ACTIVITY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == BACK_FROM_SECOND_ACTIVITY) {
            if (resultCode == RESULT_OK) {
                String name = data.getStringExtra(NAME);
                int position = data.getIntExtra(POSITION, -1);

                if (position != -1){
                    names[position] = name;
                    stringArrayAdapter.notifyDataSetChanged();
                }
            }
        }
    }
}
