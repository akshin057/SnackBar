package com.example.snackbar;

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

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText inputET;
    TextView outputTV;
    Button savaDataBTN;
    Button deleteDataBTN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputET = findViewById(R.id.inputET);
        outputTV = findViewById(R.id.outputTV);
        savaDataBTN = findViewById(R.id.saveDataBTN);
        deleteDataBTN = findViewById(R.id.deleteDataBTN);


        savaDataBTN.setOnClickListener(this);
        deleteDataBTN.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.saveDataBTN) {
            outputTV.setText(inputET.getText().toString());
        } else if (v.getId() == R.id.deleteDataBTN) {
            Snackbar.make(v,
                    "Подтвердить удаление"
                    ,Snackbar.LENGTH_SHORT).setAction("Удалить", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    outputTV.setText("");
                    inputET.getText().clear();
                    Snackbar.make(v, "Данные удалены", Snackbar.LENGTH_SHORT).show();
                }
            }).show();

        }

    }
}