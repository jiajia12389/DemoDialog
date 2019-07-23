package sg.edu.rp.c346.demodialog;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {


    Button btnDemo1,btnDemo2, btnDemo3, btnDemo4, btnDemo5, btnDemo6;
    TextView tv2,tv3, tv4, tv5, tv6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDemo1 = findViewById(R.id.buttonDemo1);

        btnDemo2 = findViewById(R.id.buttonDemo2);
        tv2 = findViewById(R.id.textViewDemo2);

        btnDemo3 = findViewById(R.id.buttonDemo3);
        tv3 = findViewById(R.id.textViewDemo3);

        btnDemo4 = findViewById(R.id.buttonDemo4);
        tv4 = findViewById(R.id.textViewDemo4);

        btnDemo5 = findViewById(R.id.buttonDemo5);
        tv5 = findViewById(R.id.textViewDemo5);

        btnDemo6 = findViewById(R.id.buttonDemo6);
        tv6 = findViewById(R.id.textViewDemo6);

        btnDemo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);


//                myBuilder.setTitle("Demo 1-Simple Dialog");
//                myBuilder.setMessage("I can develop Android App.");
//                myBuilder.setCancelable(true);
//                myBuilder.setPositiveButton("Close",null);

                myBuilder.setTitle("Congratulations");
                myBuilder.setMessage("You have completed a simple Dialog Box");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Dismiss",null);

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        btnDemo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setTitle("Demo 2 Button Dialog");
                myBuilder.setMessage("Select one of the Button below.");
                myBuilder.setCancelable(false);


                myBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tv2.setText("You have selected Positive.");
                    }
                });

                myBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tv2.setText("You have selected Negative.");
                    }
                });

                myBuilder.setNeutralButton("Cancel",null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        btnDemo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder myBuilder =  new AlertDialog.Builder(MainActivity.this);
                View viewDialog = getLayoutInflater().inflate(R.layout.input, null);

                final EditText inputEt = viewDialog.findViewById(R.id.inputEt);

                myBuilder.setTitle("Demo 3 - Text Input Dialog");
                myBuilder.setView(viewDialog);
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        tv3.setText(inputEt.getText().toString());
                    }
                });
//                myBuilder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        tv3.setText("You have selected Negative.");
//                    }
//                });

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });


        btnDemo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.add,null);

                final EditText etInput = viewDialog.findViewById(R.id.etInput);
                final EditText etInput2 = viewDialog.findViewById(R.id.etInput2);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog);
                myBuilder.setTitle("Exercise 3");
                myBuilder.setCancelable(false);

                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int num1 = Integer.parseInt(etInput.getText().toString());
                        int num2 =  Integer.parseInt(etInput2.getText().toString());

                        int total = num1+num2;
                        tv4.setText(String.valueOf(total));
                    }
                });

                myBuilder.setNegativeButton("Cancel", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        btnDemo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        tv5.setText("Date: "+dayOfMonth+"/"+(month+1)+"/"+year);
                    }
                };

                Calendar cal = Calendar.getInstance();

                int day = cal.get(Calendar.DAY_OF_MONTH);
                int month = cal.get(Calendar.MONTH);
                int year = cal.get(Calendar.YEAR);

                DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this, myDateListener, year,month,day);
                myDateDialog.show();
            }
        });


        btnDemo6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        tv6.setText("Time: "+hourOfDay+":"+minute);
                    }
                };

                Calendar cal = Calendar.getInstance();

                int hour = cal.get(Calendar.HOUR);
                int minute = cal.get(Calendar.MINUTE);

                TimePickerDialog myTimerDialog = new TimePickerDialog(MainActivity.this, myTimeListener,hour,minute,true);
                myTimerDialog.show();
            }
        });


    }
}
