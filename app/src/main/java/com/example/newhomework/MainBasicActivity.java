package com.example.newhomework;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainBasicActivity extends AppCompatActivity {

    TextView textViewForName, textViewForSName, textViewForNumber, textViewForEmail, textforMaleFemale,
            textViewForTwitter, textViewForCareerHistory, textViewForEducation;
    ImageView imageViewperson;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        textViewForName =findViewById(R.id.textViewForName);
        textViewForSName=findViewById(R.id.textViewForSName);
        textViewForNumber=findViewById(R.id.textViewForNumber);
        textViewForEmail=findViewById(R.id.textViewForEmail);
        textforMaleFemale=findViewById(R.id.textforMaleFemale);
        textViewForTwitter=findViewById(R.id.textViewForTwitter);
        textViewForCareerHistory=findViewById(R.id.textViewForCareerHistory);
        textViewForEducation=findViewById(R.id.textViewForEducation);

        imageViewperson=findViewById(R.id.imageViewperson);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_basic);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openActivityforwrite();

            }
        });
    }

    public void openActivityforwrite() {
        Intent intent = new Intent(this, MainWriteActivity.class);
        startActivityForResult(intent,1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data==null){
            return;
        } String name = data.getStringExtra("name");
        textViewForName.setText(name);
    }
}
