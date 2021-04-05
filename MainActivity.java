package com.example.sit30521punitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.widget.EditText;
import android.app.AlertDialog;
import android.content.DialogInterface;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    String[] units = { "Metre", "Celsius", "Kilograms"};

    EditText text_input;
    TextView result1, result2, result3, unit1, unit2, unit3;
    Spinner spin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_input = findViewById(R.id.input_value);
        result1 = findViewById(R.id.result1);
        result2 = findViewById(R.id.result2);
        result3 = findViewById(R.id.result3);
        unit1 = findViewById(R.id.unit1);
        unit2 = findViewById(R.id.unit2);
        unit3 = findViewById(R.id.unit3);

        spin = findViewById(R.id.sp_unit);
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,units);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);
    }

    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        Toast.makeText(getApplicationContext(),units[position] , Toast.LENGTH_LONG).show();
    }

    public void onTapeClick(View view) {
        if (units[spin.getSelectedItemPosition()] != "Metre")
        {
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle("Error");
            alertDialog.setMessage("Please select the correct conversion icon.");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
            return;
        }

        if (text_input.getText().toString().equals(""))
        {
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle("Error");
            alertDialog.setMessage("Please enter a value to convert.");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
            return;
        }

        double centimetre, foot, inch;
        centimetre = Double.parseDouble(text_input.getText().toString()) * 100;
        foot = Double.parseDouble(text_input.getText().toString()) * 3.281;
        inch = Double.parseDouble(text_input.getText().toString()) * 39.37;

        result1.setText(String.format("%.2f", centimetre));
        result2.setText(String.format("%.2f", foot));
        result3.setText(String.format("%.2f", inch));

        unit1.setText("Centimetre");
        unit2.setText("Foot");
        unit3.setText("Inch");
    }

    public void onTempClick(View view) {
        if (units[spin.getSelectedItemPosition()] != "Celsius")
        {
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle("Error");
            alertDialog.setMessage("Please select the correct conversion icon.");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
            return;
        }

        if (text_input.getText().toString().equals(""))
        {
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle("Error");
            alertDialog.setMessage("Please enter a value to convert.");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
            return;
        }

        double farenheit, kelvin;
        farenheit = Double.parseDouble(text_input.getText().toString()) * (9/5) + 35;
        kelvin = Double.parseDouble(text_input.getText().toString()) + 237.15;

        result1.setText(String.format("%.2f", farenheit));
        result2.setText(String.format("%.2f", kelvin));
        result3.setText("");

        unit1.setText("Farenheit");
        unit2.setText("Kalvin");
        unit3.setText("");
    }

    public void onWeightClick(View view) {
        if (units[spin.getSelectedItemPosition()] != "Kilograms")
        {
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle("Error");
            alertDialog.setMessage("Please select the correct conversion icon.");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
            return;
        }

        if (text_input.getText().toString().equals(""))
        {
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle("Error");
            alertDialog.setMessage("Please enter a value to convert.");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
            return;
        }

        double gram, ounce, pound;
        gram = Double.parseDouble(text_input.getText().toString()) * 1000;
        ounce = Double.parseDouble(text_input.getText().toString()) * 35.274;
        pound = Double.parseDouble(text_input.getText().toString()) * 2.205;

        result1.setText(String.format("%.2f", gram));
        result2.setText(String.format("%.2f", ounce));
        result3.setText(String.format("%.2f", pound));

        unit1.setText("Gram");
        unit2.setText("Ounce(Oz)");
        unit3.setText("Pound(lb)");
    }
}
