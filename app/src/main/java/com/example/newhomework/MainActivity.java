package com.example.newhomework;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {
    Animation uptodown1,downtoup;
    LinearLayout linearfirst1,linearsecond2;
    Button btnletsgoo;
LottieAnimationView animationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        animationView= (LottieAnimationView) findViewById(R.id.lottieAnimationView);
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
       // startCheckAnimation();
    }

   /* private void startCheckAnimation(){
          final ValueAnimator animator =ValueAnimator.ofFloat(0f,1f).setDuration(3000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                animationView.setProgress((Float)animator.getAnimatedValue());
            }
        });
       if ((animationView.getProgress() == 1f)  ){

            animator.start();

        }
        else{
            animationView.setProgress(0f);
        }

    }*/
    public void openActivity(){
        Intent intent=new Intent(this,MainBasicActivity.class);
        startActivity(intent);

    }
}
