package com.poomer555gmail.creditscoring;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Condition extends AppCompatActivity {
    private  int tChar;
    private int tCap;
    private int tCapi;
    private int tColla;
    private int tCon;
    private Spinner mEco;
    private Spinner mPo;
    private Button mCon;
    private int fEco;
    private int fPo;
    private int fCon;
    private int LastChar;
    private int LastCap;
    private int LastCapi;
    private int LastColla;
    private int LastCon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_condition);

        mPo = findViewById(R.id.sPolitics);
        mEco = findViewById(R.id.sEco);
        mCon = findViewById(R.id.ConButton);


        final Intent intent= getIntent();
        tChar=intent.getIntExtra("tChar",0);
        tCap=intent.getIntExtra("tCap",0);
        tCapi=intent.getIntExtra("tCapi",0);
        tColla=intent.getIntExtra("tColla",0);

        String[]Eco= getResources().getStringArray(R.array.Acon);
        ArrayAdapter<String> adapterEco = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line,Eco);
        mEco.setAdapter(adapterEco);

        String[]Po= getResources().getStringArray(R.array.Acon);
        ArrayAdapter<String> adapterPo = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line,Po);
        mPo.setAdapter(adapterPo);


        mEco.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        fEco = 40 ;
                        break;
                    case 1:
                        fEco = 20 ;
                        break;
                    case 2:
                        fEco = 0 ;
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        mPo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        fPo = 20 ;
                        break;
                    case 1:
                        fPo = 10 ;
                        break;
                    case 2:
                        fPo = 0 ;
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        mCon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fCon = fEco+fPo;

                LastChar = tChar - 64 ;
                LastCap = tCap - 56 ;
                LastCapi =tCapi - 49;
                LastColla = tColla - 35 ;
                LastCon = fCon - 45 ;



                Intent intent = new Intent(Condition.this,Result.class);
                intent.putExtra("Char",LastChar);
                intent.putExtra("Capa",LastCap);
                intent.putExtra("Capi",LastCapi);
                intent.putExtra("Colla",LastColla);
                intent.putExtra("Con",LastCon);

                startActivity(intent);


            }
        });

    }
}
