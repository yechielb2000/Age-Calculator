package com.example.agecalculator;

import androidx.fragment.app.DialogFragment;
import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class ResultFragment extends DialogFragment {

    @Override @SuppressLint("SetTextI18n")
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.result_fragment, container, false);

        TextView result = view.findViewById(R.id.result);

        Date calender = Calendar.getInstance().getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        String currentDate = simpleDateFormat.format(calender);

        Bundle bundle = this.getArguments();
        if (bundle != null) {

            String date = bundle.getString("date", "Your date is suck!");

            try {
                Date thisDay = simpleDateFormat.parse(currentDate);
                Date birthday = simpleDateFormat.parse(date);

                assert thisDay != null;
                assert birthday != null;
                long numberOfDays = thisDay.getTime() - birthday.getTime();
                result.setText("From: " + date + " to: " + currentDate + "\nYou live " + TimeUnit.DAYS.convert(numberOfDays, TimeUnit.MILLISECONDS) + " days");

            } catch (ParseException e) {
                result.setText("Error: " + e.getMessage() + "\nPlease let me know about it\nMy email: Yechielb2000@gmail.com");
            }
        }
        return view;
    }
}