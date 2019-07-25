package com.example.newhomework;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

import static com.example.newhomework.ColorType.GRE;
import static com.example.newhomework.ColorType.RED;
import static com.example.newhomework.ColorType.YEL;
import static java.lang.Enum.valueOf;

public class MainBasicActivity extends AppCompatActivity {

    TextView textViewForName, textViewForSName, textViewForNumber, textViewForEmail, textforMaleFemale,
            textViewForTwitter, textViewForCareerHistory, textViewForEducation;
    ImageView imageViewperson;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_basic);


        textViewForName =findViewById(R.id.textViewForName);
        textViewForSName=findViewById(R.id.textViewForSName);
        textViewForNumber=findViewById(R.id.textViewForNumber);
        textViewForEmail=findViewById(R.id.textViewForEmail);
        textforMaleFemale=findViewById(R.id.textforMaleFemale);
        textViewForTwitter=findViewById(R.id.textViewForTwitter);
        textViewForCareerHistory=findViewById(R.id.textViewForCareerHistory);
        textViewForEducation=findViewById(R.id.textViewForEducation);

        imageViewperson=findViewById(R.id.imageViewperson);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openActivityforwrite();

            }
        });
    }

    private void setType(String str )
    {
        LinearLayout v = findViewById(R.id.linearForChangeColor);
      /*  TextView textViewEdu= findViewById(R.id.edittextForeducation2);
        TextView textViewHist= findViewById(R.id.edittextForhistory1);*/

        switch (valueOf(str)){
            case GRE:
                v.setBackgroundColor( ContextCompat.getColor( getBaseContext(), R.color.colorPrimary));
                break;
            case YEL:
                v.setBackgroundColor( ContextCompat.getColor( getBaseContext(), R.color.colorYellow));
                break;
            case RED:
                v.setBackgroundColor( ContextCompat.getColor( getBaseContext(), R.color.colorAccent));
                break;
        }
    }

    public void openActivityforwrite() {
        Intent intent = new Intent(this, MainWriteActivity.class);
        startActivityForResult(intent,1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            return;

        } else {
            Bundle bnd = data.getExtras();


            textViewForSName.setText( Objects.requireNonNull( bnd.get( "sname" ) ).toString() );
            textViewForName.setText( Objects.requireNonNull( bnd.get( "name" ) ).toString() );
            textViewForCareerHistory.setText( Objects.requireNonNull( bnd.get( "hist" ) ).toString() );
            textViewForEducation.setText( Objects.requireNonNull( bnd.get( "edu" ) ).toString() );
            textViewForNumber.setText( Objects.requireNonNull( bnd.get( "numb" ) ).toString() );
            textViewForEmail.setText(Objects.requireNonNull(bnd.get("mail")).toString());
            textViewForTwitter.setText(Objects.requireNonNull(bnd.get("twitt")).toString());
            setType(bnd.getString( "type" ));



           /* String name = data.getStringExtra("name");
            textViewForName.setText(name);
            String sname = data.getStringExtra("sname");
            textViewForSName.setText(name);*/
        }
    }
}
