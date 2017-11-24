package com.poomer555gmail.creditscoring;

import android.content.Intent;
import android.graphics.Color;

import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Result extends AppCompatActivity {
    private TextView C1;
    private TextView C2;
    private TextView C3;
    private TextView C4;
    private TextView C5;
    private TextView Re;
    private int Char;
    private int Capa;
    private int Capi;
    private int Colla;
    private int Con;
    private int Ans;
    private Button Back;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        C1 = findViewById(R.id.one);
        C2 = findViewById(R.id.two);
        C3 = findViewById(R.id.three);
        C4 = findViewById(R.id.four);
        C5 = findViewById(R.id.five);
        Re = findViewById(R.id.Re);
        Back = findViewById(R.id.BackBut);


        final Intent intent = getIntent();
        Char = intent.getIntExtra("Char", 0);
        Capa = intent.getIntExtra("Capa", 0);
        Capi = intent.getIntExtra("Capi", 0);
        Colla = intent.getIntExtra("Colla", 0);
        Con = intent.getIntExtra("Con", 0);

        Ans = Char + Capa + Capi + Colla + Con;


        if (Ans < 0) {
            Re.setTextColor(Color.RED);
            Re.setText("เเย่");
            // Re.setTextColor(Color.parseColor("#FF0000"));
        } else if (Ans >= 0 && Ans < 165) {
             Re.setTextColor(Color.YELLOW);
            Re.setText("ปานกลาง");
            // Re.setTextColor(Color.parseColor("FFFF00"));


        } else {
            Re.setTextColor(Color.GREEN);
            Re.setText("ดี");
            //Re.setTextColor(Color.parseColor("00FF00"));
        }


        if (Char < 0) {
            C1.setTextColor(Color.RED);
        } else {
            C1.setTextColor(Color.GREEN);
        }

        if (Capa < 0) {
            C2.setTextColor(Color.RED);
        } else {
            C2.setTextColor(Color.GREEN);
        }

        if (Capi < 0) {
            C3.setTextColor(Color.RED);
        } else {
            C3.setTextColor(Color.GREEN);

            if (Colla < 0) {
                C4.setTextColor(Color.RED);
            } else {
                C4.setTextColor(Color.GREEN);
            }

            if (Con < 0) {
                C5.setTextColor(Color.RED);
            } else {
                C5.setTextColor(Color.GREEN);
            }


        }

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Result.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
