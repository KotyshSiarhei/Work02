package com.example.work02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.util.Log;


public class MainActivity extends AppCompatActivity {

    private final static String TAG = "[LifeCycleActivity]";

    private EditText calculation, result;
    private String curr, res;
    private Button button_1, button_2, button_3, button_4, button_5, button_6, button_7, button_8, button_9, button_0, button_point, button_division, button_multiplication, button_minus, button_plus, button_ac, button_del, button_total;
    private boolean point_inserted, operator_inserted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String instanceState;
        if (savedInstanceState == null) {
            instanceState = "Первый запуск!";
        } else {
            instanceState = "Повторный запуск!";
        }
        makeToast(instanceState + " - onCreate()");

        calculation = (EditText) findViewById(R.id.calculation);
        result = (EditText) findViewById(R.id.result);

        curr = "";
        res = "";
        point_inserted = false;
        operator_inserted = false;

        button_0 = (Button) findViewById(R.id.button_0);
        button_1 = (Button) findViewById(R.id.button_1);
        button_2 = (Button) findViewById(R.id.button_2);
        button_3 = (Button) findViewById(R.id.button_3);
        button_4 = (Button) findViewById(R.id.button_4);
        button_5 = (Button) findViewById(R.id.button_5);
        button_6 = (Button) findViewById(R.id.button_6);
        button_7 = (Button) findViewById(R.id.button_7);
        button_8 = (Button) findViewById(R.id.button_8);
        button_9 = (Button) findViewById(R.id.button_9);
        button_point = (Button) findViewById(R.id.button_point);
        button_division = (Button) findViewById(R.id.button_division);
        button_multiplication = (Button) findViewById(R.id.button_multiplication);
        button_minus = (Button) findViewById(R.id.button_minus);
        button_plus = (Button) findViewById(R.id.button_plus);
        button_ac = (Button) findViewById(R.id.button_ac);
        button_del = (Button) findViewById(R.id.button_del);
        button_total = (Button) findViewById(R.id.button_total);

        button_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "0";
                display_one();
            }
        });

        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "1";
                display_one();
            }
        });

        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "2";
                display_one();
            }
        });

        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "3";
                display_one();
            }
        });

        button_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "4";
                display_one();
            }
        });

        button_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "5";
                display_one();
            }
        });

        button_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "6";
                display_one();
            }
        });

        button_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "7";
                display_one();
            }
        });

        button_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "8";
                display_one();
            }
        });

        button_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "9";
                display_one();
            }
        });

        button_point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(curr.isEmpty()){
                    curr = "0.";
                    point_inserted = true;
                }
                if(point_inserted == false){
                    curr = curr + ".";
                    point_inserted = true;
                }
                display_one();
            }
        });

        button_division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                point_inserted = false;
                if(!curr.isEmpty()){
                    if(curr.substring(curr.length()-1, curr.length()).equals(".")){
                        backspace();
                    }
                    if(operator_inserted == false){
                        curr = curr + " / ";
                        operator_inserted = true;
                    }
                }
                display_one();
            }
        });

        button_multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                point_inserted = false;
                if(!curr.isEmpty()){
                    if(curr.substring(curr.length()-1, curr.length()).equals(".")){
                        backspace();
                    }
                    if(operator_inserted == false){
                        curr = curr + " * ";
                        operator_inserted = true;
                    }
                }
                display_one();
            }
        });

        button_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                point_inserted = false;
                if(!curr.isEmpty()){
                    if(curr.substring(curr.length()-1, curr.length()).equals(".")){
                        backspace();
                    }
                    if(operator_inserted == false){
                        curr = curr + " - ";
                        operator_inserted = true;
                    }
                }
                display_one();
            }
        });

        button_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                point_inserted = false;
                if(!curr.isEmpty()){
                    if(curr.substring(curr.length()-1, curr.length()).equals(".")){
                        backspace();
                    }
                    if(operator_inserted == false){
                        curr = curr + " + ";
                        operator_inserted = true;
                    }
                }
                display_one();
            }
        });

        button_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear();
                display_one();
                display_two();
            }
        });

        button_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backspace();
                display_one();
            }
        });

        button_total.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operator_inserted == true && !curr.substring(curr.length()-1, curr.length()).equals(" ")){
                    String[]tokens = curr.split(" ");
                    switch (tokens[1].charAt(0)) {
                        case '/':
                            res = Double.toString(Double.parseDouble(tokens[0]) / Double.parseDouble(tokens[2]));
                            break;
                        case '*':
                            res = Double.toString(Double.parseDouble(tokens[0]) * Double.parseDouble(tokens[2]));
                            break;
                        case '-':
                            res = Double.toString(Double.parseDouble(tokens[0]) - Double.parseDouble(tokens[2]));
                            break;
                        case '+':
                            res = Double.toString(Double.parseDouble(tokens[0]) + Double.parseDouble(tokens[2]));
                            break;
                    }
                    display_two();
                }
            }
        });
    }

    public void display_one() {
        calculation.setText(curr);
    }

    public void display_two() {
        result.setText(res);
    }

    public void clear() {
        curr = "";
        res = "";
        point_inserted = false;
        operator_inserted = false;
    }

    public void backspace() {
        if(!curr.isEmpty()) {
            if (curr.substring(curr.length()-1, curr.length()).equals(".")) {
                point_inserted = false;
            }
            if (curr.substring(curr.length()-1, curr.length()).equals(" ")) {
                curr = curr.substring(0, curr.length()-3);
                operator_inserted = false;
            } else {
                curr = curr.substring(0, curr.length()-1);
            }
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        makeToast("onStart()");
    }
    @Override
    protected void onRestoreInstanceState(Bundle saveInstanceState) {
        super.onRestoreInstanceState(saveInstanceState);
        makeToast("Повторный запуск!! - onRestoreInstanceState()");

    }
    @Override
    protected void onResume() {
        super.onResume();
        makeToast("onResume()");
    }
    @Override
    protected void onPause() {
        super.onPause();
        makeToast("onPause()");
    }
    @Override
    protected void onSaveInstanceState(Bundle saveInstanceState) {
        super.onSaveInstanceState(saveInstanceState);
        makeToast("onSaveInstanceState()");
    }
    @Override
    protected void onStop() {
        super.onStop();
        makeToast("onStop()");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        makeToast("onRestart()");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        makeToast("onDestroy()");
    }

    private void makeToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
        Log.d(TAG, message);
    }
}