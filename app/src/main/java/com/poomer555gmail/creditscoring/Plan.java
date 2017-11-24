package com.poomer555gmail.creditscoring;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Plan extends AppCompatActivity {

    private EditText load;
    private EditText InterRate;
    private EditText Year;
    private EditText Salary;
    private Button PlanBut;
    private double money;
    private  double Rate ;
    private double year;
    private double InterPerYear;
    private double InterAllTime;
    private double PaidTotal;
    private double PaidPerMonth;
    private double month;
    private double salary;
    private double SalaryPerMonth;
    private double CanLoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);

        load = findViewById(R.id.loan);
        InterRate = findViewById(R.id.InterateRate);
        Year = findViewById(R.id.year);
        Salary = findViewById(R.id.Salary);
        PlanBut = findViewById(R.id.Plan_button);




        PlanBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                money = Double.parseDouble(load.getText().toString());
                Rate = Double.parseDouble(InterRate.getText().toString());
                year= Double.parseDouble(Year.getText().toString());
                salary = Double.parseDouble(Salary.getText().toString());

                InterPerYear =(Rate/100)*money;

                InterAllTime = InterPerYear*year;

                PaidTotal = money + InterAllTime ;

                month = year*12;

                PaidPerMonth = PaidTotal/(month);

                SalaryPerMonth = salary*(0.4);
                double x = SalaryPerMonth*month;


                CanLoad =  x /(year*(Rate/100)+1);




                Intent intent = new Intent(Plan.this,PlanResult.class);
                intent.putExtra("PaidTotal",PaidTotal);
                intent.putExtra("InterAlltime",InterAllTime);
                intent.putExtra("PaidPerMonth",PaidPerMonth);
                intent.putExtra("IncomeCanPaid",SalaryPerMonth);
                intent.putExtra("Canload",CanLoad);

                startActivity(intent);

            }
        });








    }
}
