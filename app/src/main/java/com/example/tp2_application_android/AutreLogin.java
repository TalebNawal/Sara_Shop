package com.example.tp2_application_android;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AutreLogin extends AppCompatActivity {
    private EditText mUsernameEditText;
    private EditText mPasswordEditText;
    private Button mOkButton;
    private Button mCancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        mUsernameEditText = findViewById(R.id.username1);
        mPasswordEditText = findViewById(R.id.password1);
        mOkButton = findViewById(R.id.ok_button1);
        mCancelButton = findViewById(R.id.cancel_button1);

        mOkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = mUsernameEditText.getText().toString();
                String password = mPasswordEditText.getText().toString();

                if (username.equals("TPandINFO") && password.equals("secret")) {

                    Intent intent = getIntent();
                    String phoneNumber = intent.getStringExtra("phone_number");


                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:" + phoneNumber));
                    startActivity(callIntent);


                    finish();
                } else {

                    Toast.makeText(AutreLogin.this, "mot de passe invalide", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });
    }
}
