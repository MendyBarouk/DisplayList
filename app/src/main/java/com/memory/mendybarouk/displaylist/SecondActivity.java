package com.memory.mendybarouk.displaylist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity{

    EditText editText;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String name = intent.getStringExtra(MainActivity.NAME);
        position = intent.getIntExtra(MainActivity.POSITION, -1);

        editText = (EditText) findViewById(R.id.editText);
        if (name != null)
            editText.setText(name);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save(view);
            }
        });

    }

    public void save(View view){
        String name = editText.getText().toString().trim();
        if (!name.isEmpty()){
            Intent intent = new Intent();
            intent.putExtra(MainActivity.NAME, name);
            intent.putExtra(MainActivity.POSITION, position);
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}
