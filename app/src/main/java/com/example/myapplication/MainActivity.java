package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText editBody, editEndine, editTransmission;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        editBody = findViewById(R.id.editBody);
        editEndine = findViewById(R.id.editEndine);
        editTransmission = findViewById(R.id.editTransmission);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Получение значений из EditText
                String stringInput = editBody.getText().toString();
                int intInput = Integer.parseInt(editEndine.getText().toString());
                double doubleInput = Double.parseDouble(editTransmission.getText().toString());

                // Создание Intent и передача значений
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("keyString", stringInput);
                intent.putExtra("keyInt", intInput);
                intent.putExtra("keyDouble", doubleInput);
                startActivity(intent);
            }
        });
    }
}
