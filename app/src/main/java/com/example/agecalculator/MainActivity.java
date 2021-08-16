package com.example.agecalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Build;
import android.os.Bundle;
import android.widget.DatePicker;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatePicker datePicker = findViewById(R.id.birthday);

        datePicker.setMaxDate(System.currentTimeMillis());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            datePicker.setOnDateChangedListener((view, year, monthOfYear, dayOfMonth) -> {

                Bundle bundle = new Bundle();
                bundle.putString("date", setUpDate(dayOfMonth) + "/" + setUpDate(++monthOfYear) + "/" + year);

                ResultFragment resultFragment = new ResultFragment();
                resultFragment.setArguments(bundle);
                resultFragment.show(this.getSupportFragmentManager(), "result fragment");
            });
        }
    }

    private String setUpDate(int date){
        String fixedDate = String.valueOf(date);
        if (fixedDate.length() < 2){
            fixedDate = "0" + fixedDate;
        }
        return fixedDate;
    }
}