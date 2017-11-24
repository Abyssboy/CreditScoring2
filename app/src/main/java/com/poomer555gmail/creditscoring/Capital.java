package com.poomer555gmail.creditscoring;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class Capital extends AppCompatActivity {
    private int tChar ;
    private int tCap;
    private Button mCapiBut;
    private Spinner mFrist;
    private  Spinner mSecond;
    private int fFirst;
    private int fSecond;
    private int fCapi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capital);

        final Intent intent= getIntent();
        tChar=intent.getIntExtra("tChar",0);
        tCap=intent.getIntExtra("tCap",0);

        mFrist = findViewById(R.id.SCome);
        mSecond = findViewById(R.id.SPa);
        mCapiBut = findViewById(R.id.EnterCapi);

        String[] First= getResources().getStringArray(R.array.ACapi1);
        ArrayAdapter<String> adapterFirst = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line,First);
        mFrist.setAdapter(adapterFirst);

        String[] Second= getResources().getStringArray(R.array.ACapi2);
        ArrayAdapter<String> adapterSec = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line,Second);
        mSecond.setAdapter(adapterSec);

        mFrist.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        fFirst = 40 ;
                        break;
                    case 1:
                        fFirst = 20 ;
                        break;
                    case 2:
                        fFirst = 0 ;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        mSecond.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        fSecond = 25 ;
                        break;
                    case 1:
                        fSecond = 0 ;
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        mCapiBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fCapi = fFirst+fSecond;
                Intent intent = new Intent(Capital.this,Collateral.class);
                intent.putExtra("tChar",tChar);
                intent.putExtra("tCap",tCap);
                intent.putExtra("tCapi",fCapi);
                startActivity(intent);
            }
        });



    }
}
