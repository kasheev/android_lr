package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity{
    Button btnRand;
    TextView tvOut;
    EditText numOne;
    EditText numTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_blank);


        btnRand = (Button) findViewById(R.id.btnRand);
        numOne = (EditText) findViewById(R.id.numOne);
        numTwo = (EditText) findViewById(R.id.numTwo);
        tvOut = (TextView) findViewById(R.id.tvOut);


        View.OnClickListener oclBtn = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numOne.getText().toString().equals(""))
                {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Ошибка: введите число", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }
                if (numTwo.getText().toString().equals("")){
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Ошибка: введите число", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }

                int min = Integer.parseInt(numOne.getText().toString());
                int max = Integer.parseInt(numTwo.getText().toString());

                if (min > max){
                   Toast toast = Toast.makeText(getApplicationContext(),
                           "Ошибка: неправильно задан диапазон", Toast.LENGTH_SHORT);
                   toast.show();
                   return;
                }
                int diff = max - min;
                Random random = new Random();
                int i = random.nextInt(diff+1) + min;
                String str2 = Integer.toString(i);
              tvOut.setText(str2);
            }
        };


        btnRand.setOnClickListener(oclBtn);
    }
}