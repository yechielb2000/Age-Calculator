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
import android.widget.Toast;

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

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        String currentDate = simpleDateFormat.format(Calendar.getInstance().getTime());

        Bundle bundle = this.getArguments();
        if (bundle != null) {

            String date = bundle.getString("date", null);

            try {
                long numberOfDays = simpleDateFormat.parse(currentDate).getTime() - simpleDateFormat.parse(date).getTime();
                result.setText("From: " + date + " To: " + currentDate + "\nYou live " + TimeUnit.DAYS.convert(numberOfDays, TimeUnit.MILLISECONDS) + " days");

            } catch (ParseException e) {
                result.setText("Error: " + e.getMessage() + "\nPlease let me know about it\nMy email: Yechielb2000@gmail.com");
            }
        }
        return view;
    }
}