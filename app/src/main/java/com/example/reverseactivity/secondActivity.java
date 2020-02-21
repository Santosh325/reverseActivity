package com.example.reverseactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class secondActivity extends AppCompatActivity {
    private EditText getName;
    private Button previous;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        getName = findViewById(R.id.getName);
        previous = findViewById(R.id.goBack);
        Bundle guessName = getIntent().getExtras();

        if(guessName != null) {
            getName.setText(guessName.getString("name"));
        }

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent = getIntent();
              intent.putExtra("message","Message from second Activity");
              setResult(RESULT_OK,intent);
              finish();
            }
        });
    }
}
