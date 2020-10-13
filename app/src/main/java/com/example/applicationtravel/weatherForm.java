package com.example.applicationtravel;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class weatherForm extends AppCompatActivity {

    private TextView tv;
    private EditText placet,datet;
    private Button btn;
    public DatePickerDialog.OnDateSetListener onDateSetListener;
    public static String global_place;
    public static String global_date;
    public String sdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_form);
        tv = findViewById(R.id.textView13);
        placet = findViewById(R.id.editTextTextPersonName);

        datet = findViewById(R.id.editTextDate);
        btn = findViewById(R.id.button);

        final Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);



        datet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        weatherForm.this,android.R.style.Theme_Holo_Light_Dialog_MinWidth,onDateSetListener,year,month,day
                );
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String place = placet.getText().toString();
                global_place = place;
                String date = datet.getText().toString();
                global_date = date;

                if(!place.isEmpty()&&!date.isEmpty()){

                    startActivity(new Intent(weatherForm.this,report.class));
                    finish();
                }else{
                    Toast.makeText(weatherForm.this, "Fields are empty!", Toast.LENGTH_SHORT).show();
                }
            }
        });

       onDateSetListener = new DatePickerDialog.OnDateSetListener() {
           @Override
           public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
               month = month+1;
               sdate =  day+"/"+month+"/"+year;
               datet.setText(sdate);

           }
       };
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(weatherForm.this,login.class));
                finish();
            }
        });

    }
}