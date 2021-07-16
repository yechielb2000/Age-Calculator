package com.example.agecalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.DatePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatePicker datePicker = findViewById(R.id.birthday);

        datePicker.setMaxDate(System.currentTimeMillis());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            datePicker.setOnDateChangedListener((view, year, monthOfYear, dayOfMonth) -> {

                String month = String.valueOf(++monthOfYear);
                if (month.length() < 2){
                    month = "0" + month;
                }

                String day = String.valueOf(dayOfMonth);
                if (day.length() < 2){
                    day = "0" + dayOfMonth;
                }

                String date = day + "/" + month + "/" + year;

                Bundle bundle = new Bundle();
                bundle.putString("date",date);

                ResultFragment resultFragment = new ResultFragment();
                resultFragment.setArguments(bundle); // send argument to FillDetailsDialogFragment
                resultFragment.show(this.getSupportFragmentManager(), "result fragment"); //show FillDetailsDialogFragment

            });
        }
    }

}