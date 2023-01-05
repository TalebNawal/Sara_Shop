package com.example.tp2_application_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CheckActivity extends AppCompatActivity {
    private TextView mChallenge1TextView;
    private TextView mChallenge2TextView;
    private EditText mSumEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_activity);

        mChallenge1TextView = findViewById(R.id.text1);
        mChallenge2TextView = findViewById(R.id.text2);
        mSumEditText = findViewById(R.id.edit_text);

        String challenge1 = getIntent().getStringExtra("challenge1");
        String challenge2 = getIntent().getStringExtra("challenge2");
        mChallenge1TextView.setText( challenge1);
        mChallenge2TextView.setText(challenge2);

        Button okButton = findViewById(R.id.button_ok);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sumString = mSumEditText.getText().toString();
                if (!sumString.isEmpty()) {
                    int sum = Integer.parseInt(sumString);
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("sum", sum);
                    setResult(RESULT_OK, resultIntent);
                    finish();
                } else {
                    Toast.makeText(CheckActivity.this, "Veuillez entrer la somme des challenges", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button cancelButton = findViewById(R.id.button_cancel);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }



}





