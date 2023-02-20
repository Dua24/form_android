package com.example.form;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class info extends AppCompatActivity {
TextView name,phone,gender,level,age,sport,music;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        name=findViewById(R.id.textView23);
        phone=findViewById(R.id.textView24);
        gender=findViewById(R.id.textView26);
        level=findViewById(R.id.textView27);
        age=findViewById(R.id.textView28);
        sport=findViewById(R.id.textView29);
        music=findViewById(R.id.textView31);

        Intent intent = getIntent();
        //name
        String nameValue = intent.getStringExtra("name");
        name.setText(nameValue);
        //phone
        String phoneValue = intent.getStringExtra("phone");
        phone.setText(phoneValue);
        //gender
        boolean genderBln = intent.getBooleanExtra("gender",false);
        if(genderBln) {
            gender.setText("Nam");
        } else{
            gender.setText("Nữ");
        }
        //Level
        String levelValue = intent.getStringExtra("level");
        level.setText(levelValue);
        //Age
        String ageValue = intent.getStringExtra("ageValue");
        age.setText(ageValue);
       //sport
        boolean sportBln = intent.getBooleanExtra("sport",false);
        if(genderBln) {
            sport.setText("Có thể thao");
        } else{
            sport.setText("Không thể thao");
        }
        //Music
       String musicValue = intent.getStringExtra("radio");
        music.setText(musicValue);

    }
}