package com.example.tp2_application_android;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CHECK = 1;
    private EditText dt;
    private EditText e2;
    ImageButton b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dt= findViewById(R.id.editTextNumber);
        e2 = findViewById(R.id.editTextNumber2);
        b = findViewById(R.id.internet);





        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String challenge1 = dt.getText().toString();
                String challenge2 = e2.getText().toString();

                if (!challenge1.isEmpty() && !challenge2.isEmpty()) {
                    Intent intent = new Intent(MainActivity.this, CheckActivity.class);
                    intent.putExtra("challenge1", challenge1);
                    intent.putExtra("challenge2", challenge2);
                    startActivityForResult(intent, REQUEST_CHECK);
                } else {
                    Toast.makeText(MainActivity.this, "Veuillez entrer les deux challenges", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ImageButton loginButton = findViewById(R.id.imageView2);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent log= new Intent(MainActivity.this, Login.class);
                log.setAction("log.ACTION");
                startActivity(log);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CHECK) {
            if (resultCode == RESULT_OK) {
                int sum = data.getIntExtra("sum", 0);
                int expectedSum = Integer.parseInt(dt.getText().toString()) +
                        Integer.parseInt(e2.getText().toString());
                if (sum == expectedSum) {
                    String url = "https://www.google.ma";
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);

                } else {
                    Toast.makeText(this, "Somme incorrecte", Toast.LENGTH_SHORT).show();
                }
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Opération annulée", Toast.LENGTH_SHORT).show();
            }
        }


    }

}