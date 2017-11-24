package com.poomer555gmail.creditscoring;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


public class Collateral extends AppCompatActivity {
    private  int tChar;
    private int tCap;
    private int tCapi;
    private Spinner mOwner;
    private Button mColla;
    private int fOwner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collateral);

        mOwner = findViewById(R.id.OwnerShip);
        mColla = findViewById(R.id.EnterColla);

        final Intent intent= getIntent();
        tChar=intent.getIntExtra("tChar",0);
        tCap=intent.getIntExtra("tCap",0);
        tCapi=intent.getIntExtra("tCapi",0);

        String[]Owner= getResources().getStringArray(R.array.AOwner);
        ArrayAdapter<String> adapterOwner = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line,Owner);
        mOwner.setAdapter(adapterOwner);

        mOwner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        fOwner = 45 ;
                        break;
                    case 1:
                        fOwner= 30 ;
                        break;
                    case 2:
                        fOwner = 25 ;
                        break;
                    case 3:
                        fOwner = 0 ;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        mColla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Collateral.this,Condition.class);
                intent.putExtra("tChar",tChar);
                intent.putExtra("tCap",tCap);
                intent.putExtra("tCapi",tCapi);
                intent.putExtra("tColla",fOwner);
                startActivity(intent);
            }
        });

    }
}
