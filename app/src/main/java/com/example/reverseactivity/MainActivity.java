package com.example.reverseactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText inputName;
    private final int REQUEST_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputName = findViewById(R.id.input_name);



    }

    public void submit(View view) {

       String message = inputName.getText().toString().trim();

       if(!message.isEmpty()) {
           Intent intent = new Intent(getApplicationContext(),secondActivity.class);
           intent.putExtra("name",message);
           startActivityForResult(intent,REQUEST_CODE);
       } else {
           Toast.makeText(getApplicationContext(), "Please Enter your name", Toast.LENGTH_SHORT).show();
       }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(REQUEST_CODE == requestCode) {
            assert data != null;
            String display = data.getStringExtra("message");
            Toast.makeText(MainActivity.this, display, Toast.LENGTH_SHORT)
                    .show();
        }
    }
}
