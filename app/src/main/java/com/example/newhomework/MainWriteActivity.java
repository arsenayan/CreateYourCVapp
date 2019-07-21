package com.example.newhomework;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainWriteActivity extends AppCompatActivity implements View.OnClickListener{
    EditText editTextForWriteName, editTextForWriteSName, editTextForWriteNumber, editTextForWriteEmail,
            editTextForWriteTwitter, edittextForhistory1, edittextForeducation2;
    ImageView imageViewForChangePhoto;
    RadioButton radioBtnMale, radioBtnFemale, radioBtnGreen, radioBtnRed, radioBtnYellow;
    Button buttonForDone;
    TextView textViewForCareerHistoryForChangeSize, textForEducation;
    final int MENU_SIZE_22 = 1;
    final int MENU_SIZE_26 = 2;
    final int MENU_SIZE_30 = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        editTextForWriteName=findViewById(R.id.editTextForWriteName);
        editTextForWriteSName=findViewById(R.id.editTextForWriteSName);
        editTextForWriteNumber=findViewById(R.id.editTextForWriteNumber);
        editTextForWriteEmail=findViewById(R.id.editTextForWriteEmail);
        editTextForWriteTwitter=findViewById(R.id.editTextForWriteTwitter);
        edittextForhistory1=findViewById(R.id.edittextForhistory1);

        imageViewForChangePhoto=findViewById(R.id.imageViewForChangePhoto);
        radioBtnMale=findViewById(R.id.radioBtnMale);
        radioBtnFemale=findViewById(R.id.radioBtnFemale);
        radioBtnGreen=findViewById(R.id.radioBtnGreen);
        radioBtnRed=findViewById(R.id.radioBtnRed);
        radioBtnYellow=findViewById(R.id.radioBtnYellow);
        buttonForDone=findViewById(R.id.buttonForDone);
 buttonForDone.setOnClickListener(this);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_write);
        if (getActionBar() != null) {
            getActionBar().hide();
        }
        textViewForCareerHistoryForChangeSize = findViewById(R.id.textViewForCareerHistoryForChangeSize);
        textForEducation = findViewById(R.id.edittextForeducation2);


        registerForContextMenu(textForEducation);
        registerForContextMenu(textViewForCareerHistoryForChangeSize);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        switch (v.getId()) {
            case R.id.textViewForCareerHistoryForChangeSize:
                menu.add(0, MENU_SIZE_22, 0, "22sp");
                menu.add(0, MENU_SIZE_26, 0, "26sp");
                menu.add(0, MENU_SIZE_30, 0, "30sp");
                break;
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case MENU_SIZE_22:
                textViewForCareerHistoryForChangeSize.setTextSize(22);
                textViewForCareerHistoryForChangeSize.setText("changed to 22 sp like this");
                break;
            case MENU_SIZE_26:
                textViewForCareerHistoryForChangeSize.setTextSize(26);
                textViewForCareerHistoryForChangeSize.setText("changed to 26 sp like this");
                break;
            case MENU_SIZE_30:
                textViewForCareerHistoryForChangeSize.setTextSize(30);
                textViewForCareerHistoryForChangeSize.setText("changed to 30 sp like this");
                break;

        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        Intent intent =new Intent();
        intent.putExtra("name",editTextForWriteName.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}
