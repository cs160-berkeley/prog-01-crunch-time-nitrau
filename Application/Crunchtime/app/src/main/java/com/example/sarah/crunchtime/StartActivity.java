package com.example.sarah.crunchtime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class StartActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.example.sarah.crunchtime.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    public void onEnterClick(View view) {
        EditText editText = (EditText) findViewById(R.id.weight_input);
        String pounds = editText.getText().toString();
        if (!pounds.matches("")) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra(EXTRA_MESSAGE, pounds);
            startActivity(intent);
        }

    }
}
