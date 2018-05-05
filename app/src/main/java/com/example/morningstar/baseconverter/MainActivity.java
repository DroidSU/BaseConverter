package com.example.morningstar.baseconverter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String num = "";
    EditText etView;
    TextView output;
    Spinner spin1, spin2;
    int pos1, pos2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etView = findViewById(R.id.etView);
        output = findViewById(R.id.output);
        spin1 = findViewById(R.id.spinner1);
        spin2 = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.choices, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.choices, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(adapter1);
        spin2.setAdapter(adapter2);

        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pos2 = spin2.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pos1 = spin1.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void convert(View view) {
        try {
            output.setText(" ");
            String res = "";
            num = etView.getText().toString();
            long n = Long.parseLong(num);
            long j;
            switch (pos1) {
                case 1:
                    switch (pos2) {
                        case 1:
                            res = num;
                            break;
                        case 2:
                            try {
                                res = Integer.toBinaryString(Integer.parseInt(num));
                            } catch (NumberFormatException e) {
                                Toast.makeText(this, "Invalid input!", Toast.LENGTH_SHORT).show();
                            }
                            break;
                        case 3:
                            try {
                                res = Integer.toOctalString(Integer.parseInt(num));
                            } catch (NumberFormatException e) {
                                Toast.makeText(this, "Invalid input!", Toast.LENGTH_SHORT).show();
                            }
                            break;
                        case 4:
                            try {
                                res = Integer.toHexString(Integer.parseInt(num));
                            } catch (NumberFormatException e) {
                                Toast.makeText(this, "Invalid input!", Toast.LENGTH_SHORT).show();
                            }
                            break;
                    }
                    break;
                case 2:
                    switch (pos2) {
                        case 1:
                            try {
                                res = Integer.toString(Integer.parseInt(num, 2));
                            } catch (NumberFormatException e) {
                                Toast.makeText(this, "Invalid input!", Toast.LENGTH_SHORT).show();
                            }
                            break;
                        case 2:
                            res = num;
                            break;
                        case 3:
                            try {
                                res = Integer.toOctalString(Integer.parseInt(num, 2));
                            } catch (NumberFormatException e) {
                                Toast.makeText(this, "Invalid input!", Toast.LENGTH_SHORT).show();
                            }
                            break;
                        case 4:
                            try {
                                res = Integer.toHexString(Integer.parseInt(num, 2));
                            } catch (NumberFormatException e) {
                                Toast.makeText(this, "Invalid input!", Toast.LENGTH_SHORT).show();
                            }
                            break;
                    }
                    break;
                case 3:
                    switch (pos2) {
                        case 1:
                            try {
                                res = Integer.toString(Integer.parseInt(num, 8));
                            } catch (NumberFormatException e) {
                                Toast.makeText(this, "Invalid input!", Toast.LENGTH_SHORT).show();
                            }
                            break;
                        case 2:
                            try {
                                res = Integer.toBinaryString(Integer.parseInt(num, 8));
                            } catch (NumberFormatException e) {
                                Toast.makeText(this, "Invalid input!", Toast.LENGTH_SHORT).show();
                            }
                            break;
                        case 3:
                            res = num;
                            break;
                        case 4:
                            try {
                                res = Integer.toHexString(Integer.parseInt(num, 8));
                            } catch (NumberFormatException e) {
                                Toast.makeText(this, "Invalid input!", Toast.LENGTH_SHORT).show();
                            }
                            break;
                    }
                    break;
                case 4:
                    switch (pos2) {
                        case 1:
                            try {
                                res = Integer.toString(Integer.parseInt(num, 16));
                            } catch (NumberFormatException e) {
                                Toast.makeText(this, "Invalid input!", Toast.LENGTH_SHORT).show();
                            }
                            break;
                        case 2:
                            try {
                                res = Integer.toBinaryString(Integer.parseInt(num, 16));
                            } catch (NumberFormatException e) {
                                Toast.makeText(this, "Invalid input!", Toast.LENGTH_SHORT).show();
                            }
                            break;
                        case 3:
                            try {
                                res = Integer.toOctalString(Integer.parseInt(num, 16));
                            } catch (NumberFormatException e) {
                                Toast.makeText(this, "Invalid input!", Toast.LENGTH_SHORT).show();
                            }
                            break;
                        case 4:
                            res = num;
                            break;
                    }
                    break;
            }
            output.setText(res);
        } catch (Exception e) {
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_LONG).show();
        }
    }

    public void reset(View view) {
        etView.setText("");
        output.setText("");
        spin2.setSelection(0);
        spin1.setSelection(0);
    }
}
