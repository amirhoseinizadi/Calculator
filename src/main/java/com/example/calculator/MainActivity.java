package com.example.calculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText int1 = findViewById(R.id.editTextText);
        EditText int2 = findViewById(R.id.editTextText2);
        Button calculate = findViewById(R.id.button);

        calculate.setOnClickListener(v -> {
            if (int1.getText() != null || int2.getText() != null){
                Integer Sum = Integer.parseInt(int1.getText().toString()) + Integer.parseInt(int2.getText().toString());
                Integer Sub = Integer.parseInt(int1.getText().toString()) - Integer.parseInt(int2.getText().toString());
                String result = "sum:" + Sum + " sub:" + Sub;
                Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}