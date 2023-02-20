package com.example.form;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> itemLevel=new ArrayList<String>();
    Spinner level;
    SeekBar age;
    Button saveBtn;
    String ageValue,levelValue;
    TextView valueSeekbar;
    Switch gender;
    CheckBox sport;
    EditText name,phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        name=findViewById(R.id.editTextTextPersonName);
        phone=findViewById(R.id.editTextTextPersonPhone);
        age=(SeekBar)findViewById(R.id.seekBar);
        saveBtn=findViewById(R.id.button);
        level =(Spinner)findViewById(R.id.spinner);
        valueSeekbar=findViewById(R.id.valueSeekbar);
        gender = (Switch) findViewById(R.id.switch1);
        sport = (CheckBox) findViewById(R.id.checkBox);
        //
        itemLevel.add("CĐ");
        itemLevel.add("ĐH");
        itemLevel.add("CH");

        // handle Spinner (dropbox)
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, itemLevel);
        level.setAdapter(adapter);

        // handle SeekBar
        age.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                valueSeekbar.setText(String.valueOf(progress));
                // get value of seekBar
                ageValue=String.valueOf(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

    //
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), info.class);

                //name
                intent.putExtra("name",name.getText().toString());
                //phone
                intent.putExtra("phone",phone.getText().toString());
                // handle Switch
                intent.putExtra("gender", gender.isChecked());
                //handle Spinner
                levelValue = level.getSelectedItem().toString();
                intent.putExtra("level", levelValue);
                //handle Seekbar
                intent.putExtra("ageValue", ageValue);
                // handle checkbox
                intent.putExtra("sport",sport.isChecked());
                //handle radio btn
                RadioGroup rg = (RadioGroup)findViewById(R.id.radioGroup);
                String radiovalue = ((RadioButton)findViewById(rg.getCheckedRadioButtonId())).getText().toString();
                intent.putExtra("radio",radiovalue);
                startActivity(intent);
            }
        });


    }
}