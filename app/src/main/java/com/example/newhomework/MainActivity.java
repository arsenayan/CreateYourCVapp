package com.example.newhomework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    Animation uptodown1,downtoup;
    LinearLayout linearfirst1,linearsecond2;
    Button btnletsgoo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnletsgoo=findViewById(R.id.btnletsgo);
        linearfirst1=findViewById(R.id.linearfirst);
        linearsecond2=findViewById(R.id.linearsecond);
        uptodown1= AnimationUtils.loadAnimation(this,R.anim.uptodown);
        downtoup= AnimationUtils.loadAnimation(this,R.anim.downtoup);
        linearfirst1.setAnimation(uptodown1);
        linearsecond2.setAnimation(downtoup);

        btnletsgoo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity();

            }
        });
    }
    public void openActivity(){
        Intent intent=new Intent(this,MainBasicActivity.class);
        startActivity(intent);

    }
}
