package com.poomer555gmail.creditscoring;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class Capacity extends AppCompatActivity {
private  int tChar;
private Spinner mIncome;
private Spinner mSick;
private Spinner mDebt;
private Button mButCap;
private  int fIncome;
private int fSick;
private  int fDebt;
private int fCap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capacity);

        final Intent intent= getIntent();
       tChar=intent.getIntExtra("tChar",0);

       //Toast.makeText(Capacity.this,String.valueOf(tChar),Toast.LENGTH_LONG);

       mIncome = findViewById(R.id.SIncome);
       mSick = findViewById(R.id.SSick);
       mDebt = findViewById(R.id.SDebt);
       mButCap = findViewById(R.id.EnterCapa);

        String[] Sick= getResources().getStringArray(R.array.ASick);
        ArrayAdapter<String> adapterSick = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line,Sick);
        mSick.setAdapter(adapterSick);

        String[] Debt= getResources().getStringArray(R.array.ADebt);
        ArrayAdapter<String> adapterDept = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line,Debt);
        mDebt.setAdapter(adapterDept);

        String[] Income= getResources().getStringArray(R.array.AIncome);
        ArrayAdapter<String> adapterIncome = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line,Income);
        mIncome.setAdapter(adapterIncome);

        mSick.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        fSick = 20 ;
                        break;
                    case 1:
                        fSick = 10 ;
                        break;
                    case 2:
                        fSick = 0 ;
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        mDebt.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        fDebt = 0 ;
                        break;
                    case 1:
                        fDebt = 30 ;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        mIncome.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        fIncome = 0 ;
                        break;
                    case 1:
                        fIncome = 5 ;
                        break;
                    case 2:
                        fIncome = 10 ;
                        break;
                    case 3:
                        fIncome = 15 ;
                        break;
                    case 4:
                        fIncome = 20 ;
                        break;
                    case 5:
                        fIncome = 25 ;
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    mButCap.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            fCap = fDebt+fIncome+fSick;

            Intent intent = new Intent(Capacity.this,Capital.class);
            intent.putExtra("tChar",tChar);
            intent.putExtra("tCap",fCap);

            startActivity(intent);
        }
    });


    }
}
