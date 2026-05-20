package com.ujd.mobileconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button convertButton;
    private EditText inputArabicNumber;
    private TextView resultRomanNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        convertButton = findViewById(R.id.convertButton);
        inputArabicNumber = findViewById(R.id.inputArabicText);
        resultRomanNumber = findViewById(R.id.resultRomanText);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = inputArabicNumber.getText().toString();
                if (!input.isEmpty()) {
                    int number = Integer.parseInt(input);
                    String romanNumber = convertArabicToRoman(number);
                    resultRomanNumber.setText(romanNumber);
                }
            }
        });
    }

    private String convertArabicToRoman(int number) {
        if (number <= 0 || number > 3999) {
            return "Invalid input";
        }
        String[] romanNumerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder roman = new StringBuilder();

        int i = 0;
        while (number > 0) {
            int div = number / values[i];
            number %= values[i];
            while (div-- > 0) {
                roman.append(romanNumerals[i]);
            }
            i++;
        }
        return roman.toString();
    }
}