package com.poomer555gmail.creditscoring;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class PlanResult extends AppCompatActivity {

    private TextView PaidPerMonth;
    private TextView PaidTotal;
    private TextView InterAlltime;
    private TextView IncomeCanPaid;
    private TextView MatchMoney;
    private Button PlanBackbutton;
    private double fPaidPerMonth;
    private double fPaidTotal;
    private double fInterAlltime;
    private double fIncomeCanPaid;
    private double fMatchMoney;

    DecimalFormat form = new DecimalFormat("#,###");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_result);

        PaidPerMonth = findViewById(R.id.PaidPerMonth);
        PaidTotal = findViewById(R.id.PaidTotal);
        InterAlltime = findViewById(R.id.InterAlltime);
        IncomeCanPaid = findViewById(R.id.IncomeCanPaid);
        MatchMoney = findViewById(R.id.MatchMoney);
        PlanBackbutton= findViewById(R.id.PlanBackbutton);

        final Intent intent= getIntent();
        fPaidPerMonth=intent.getDoubleExtra("PaidPerMonth",0);
        fPaidTotal=intent.getDoubleExtra("PaidTotal",0);
        fInterAlltime=intent.getDoubleExtra("InterAlltime",0);
        fIncomeCanPaid=intent.getDoubleExtra("IncomeCanPaid",0);
        fMatchMoney=intent.getDoubleExtra("Canload",0);

        PaidPerMonth.setText(form.format(fPaidPerMonth));
        PaidTotal.setText(form.format(fPaidTotal));
        InterAlltime.setText(form.format(fInterAlltime));
        IncomeCanPaid.setText(form.format(fIncomeCanPaid));
        MatchMoney.setText(form.format(fMatchMoney));










    }
}
