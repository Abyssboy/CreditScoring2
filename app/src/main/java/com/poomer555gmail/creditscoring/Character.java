package com.poomer555gmail.creditscoring;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Character extends AppCompatActivity {
    private Spinner mHisDebt ;
    private Spinner mjob;
    private Spinner mStatus;
    private Button mCharacter;
    private int fHisDebt;
    private int fjob;
    private int fStatus;
    public int fChar ;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);



        mHisDebt =(Spinner) findViewById(R.id.SHisDebt);
        mjob = (Spinner) findViewById(R.id.Sjob);
        mStatus=(Spinner) findViewById(R.id.SStatus);
        mCharacter=(Button) findViewById(R.id.EnterCharacter);

        String[] status= getResources().getStringArray(R.array.AStatus);
        ArrayAdapter<String> adapterstatus = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line,status);
        mStatus.setAdapter(adapterstatus);

        String[] HisDebt= getResources().getStringArray(R.array.AHisdebt);
        ArrayAdapter<String> adapterHisDept = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line,HisDebt);
        mHisDebt.setAdapter(adapterHisDept);

        final String[] job= getResources().getStringArray(R.array.AJob);
        ArrayAdapter<String> adapterjob = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line,job);
        mjob.setAdapter(adapterjob);

        mStatus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        fStatus = 0 ;
                        break;
                    case 1:
                        fStatus = 20 ;
                        break;
                    case 2:
                        fStatus = 0 ;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        mHisDebt.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        fHisDebt = 40 ;
                        break;
                    case 1:
                        fHisDebt  = 20 ;
                        break;
                    case 2:
                        fHisDebt  = 0 ;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        mjob.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        fjob = 25 ;
                        break;
                    case 1:
                        fjob  = 20 ;
                        break;
                    case 2:
                        fjob  = 25 ;
                        break;
                    case 3:
                        fjob = 20 ;
                        break;
                    case 4:
                        fjob  = 15 ;
                        break;
                    case 5:
                        fjob  = 10 ;
                        break;
                    case 6:
                        fjob  = 5 ;
                        break;
                    case 7:
                        fjob  = 5 ;
                        break;
                    case 8:
                        fjob  = 0 ;
                        break;
                    case 9:
                        fjob  = 0 ;
                        break;

                }
            }



            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });





mCharacter.setOnClickListener(new View.OnClickListener() {
    @Override

        public void onClick(View view) {
        fChar = fHisDebt + fStatus +fjob ;
            Intent intent = new Intent(Character.this,Capacity.class);
            intent.putExtra("tChar",fChar);
            startActivity(intent);
        }

});


    }
}
