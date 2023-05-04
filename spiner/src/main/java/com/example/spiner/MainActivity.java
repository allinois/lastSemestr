package com.example.spiner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinFrom = findViewById(R.id.spinerFrom);
        Spinner spinTo = findViewById(R.id.spinnerTo);
        TextView text = findViewById(R.id.textView1);

        // Настраиваем адаптер
        ArrayAdapter<?> adapter =ArrayAdapter.createFromResource(this, R.array.mera,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinFrom.setAdapter(adapter);
        spinTo.setAdapter(adapter);

        EditText editValue = ((EditText)findViewById(R.id.editTextTextFrom));
        if(!editValue.getText().toString().trim().isEmpty()) {
            double value = Double.parseDouble(editValue.getText().toString());
            int spinnerFromPos = spinFrom.getSelectedItemPosition();
            switch (spinnerFromPos) {
                case 0:
                    value = value / 1000;
                    break;
                case 1:
                    value = value / 100;
                    break;
                case 3:
                    value = value * 1000;
                    break;
            }


            text.setText(" ");

        }else {
            text.setText("данные введены неверно");

        }
    }
}