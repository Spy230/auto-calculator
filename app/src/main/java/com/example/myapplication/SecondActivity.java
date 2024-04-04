package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private Button button;
    private TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        button = findViewById(R.id.button2);
        output = findViewById(R.id.output);

        //  есть ли данные в Intent
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String outputString = bundle.getString("keyString");
            int outputInt = bundle.getInt("keyInt");
            double outputDouble = bundle.getDouble("keyDouble");

            // Преобразуем строку стоимости двигателя в числовой формат
            double engineCost = Double.parseDouble(outputString);

            // Вычисляем общую стоимость
            double totalCost = calculateTotalCost(engineCost, outputInt, outputDouble);

            // Текст для отображения
            String outputText = "Стоимость комплектующих" +
                    "\nдвигателя:" + engineCost +
                    "\nкузов:" + outputInt +
                    "\nтрансмиссии" + outputDouble +
                    "\nОбщая стоимость:" + totalCost;

            // Выводим данные в TextView
            output.setText(outputText);
        } else {
            output.setText("Данные отсутствуют");
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });


    }

    // Метод для вычисления общей стоимости
    private double calculateTotalCost(double outputString, int outputInt, double outputDouble) {
        // Добавляем стоимость двигателя к общей сумме
        double totalCost = outputString + outputInt + outputDouble;
        return totalCost;
    }
}
