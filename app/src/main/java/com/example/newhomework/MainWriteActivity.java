package com.example.newhomework;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainWriteActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editTextForWriteName, editTextForWriteSName, editTextForWriteNumber, editTextForWriteEmail,
            editTextForWriteTwitter, edittextForhistory1, edittextForeducation2;
    ImageView imageViewForChangePhoto;
    RadioButton radioBtnMale, radioBtnFemale, radioBtnGreen, radioBtnRed, radioBtnYellow;
    RadioGroup radioGroupForColor;
    Button buttonForDone;
    TextView textViewForCareerHistoryForChangeSize, textForEducation, textviewForClicPhoto;
    private final int BROWSEPICTURE = 1;
    private Uri uripimage;
    final int MENU_SIZE_22 = 1;
    final int MENU_SIZE_26 = 2;
    final int MENU_SIZE_30 = 3;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_write);
      //  textviewForClicPhoto = findViewById(R.id.textviewForClicPhoto);
        editTextForWriteName = findViewById(R.id.editTextForWriteName);
        editTextForWriteSName = findViewById(R.id.editTextForWriteSName);
        editTextForWriteNumber = findViewById(R.id.editTextForWriteNumber);
        editTextForWriteEmail = findViewById(R.id.editTextForWriteEmail);
        editTextForWriteTwitter = findViewById(R.id.editTextForWriteTwitter);
        edittextForhistory1 = findViewById(R.id.edittextForhistory1);
        edittextForeducation2 = findViewById(R.id.edittextForeducation2);
        radioGroupForColor = findViewById(R.id.radiogrubButtenForColor);
        imageViewForChangePhoto = findViewById(R.id.imageViewForChangePhoto);
        radioBtnMale = findViewById(R.id.radioBtnMale);
        radioBtnFemale = findViewById(R.id.radioBtnFemale);
        radioBtnGreen = findViewById(R.id.radioBtnGreen);
        radioBtnRed = findViewById(R.id.radioBtnRed);
        radioBtnYellow = findViewById(R.id.radioBtnYellow);
        buttonForDone = findViewById(R.id.buttonForDoneAll);

        buttonForDone.setOnClickListener(this);
        findViewById(R.id.textviewForClicPhoto).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uripimage = null;
                checkPicture();
            }
        });
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

    private void checkPicture() {
        Intent intent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, BROWSEPICTURE);
    }

    @Override
    public void onClick(View view) {
        /*Intent intent = new Intent();


            intent.putExtra("name", editTextForWriteName.getText().toString());
            setResult(RESULT_OK, intent);
            intent.putExtra("sname", editTextForWriteSName.getText().toString());
            setResult(RESULT_OK, intent);
            finish();*/

        sendData();
    }

    private void sendData() {
        String strsName = editTextForWriteSName.getText().toString();
        String strName = editTextForWriteName.getText().toString();
        String strHistory = edittextForhistory1.getText().toString();
        String strEducate = edittextForeducation2.getText().toString();
        String strNumber = editTextForWriteNumber.getText().toString();
        String StrMail = editTextForWriteEmail.getText().toString();
        String strTwit = editTextForWriteTwitter.getText().toString();
        ColorStateList radioGreen = radioBtnGreen.getTextColors();


        ColorType colorType = null;
        int v = radioGroupForColor.getCheckedRadioButtonId();
        switch (v) {
            case R.id.radioBtnGreen:
                colorType = ColorType.GRE;
                break;
            case R.id.radioBtnRed:
                colorType = ColorType.RED;
                break;
            case R.id.radioBtnYellow:
                colorType = ColorType.YEL;
                break;
        }
        Bundle bnd = new Bundle();
        bnd.putString("sname", strsName);
        bnd.putString("name", strName);
        bnd.putString("hist", strHistory);
        bnd.putString("edu", strEducate);
        bnd.putString("numb", strNumber);
        bnd.putString("mail", StrMail);
        bnd.putString("twitt", strTwit);
//        bnd.putString("color", colorType.toString());
       bnd.putString( "uri" , uripimage.toString() );
        Intent intent = new Intent();
        intent.putExtras(bnd);
        setResult(RESULT_OK, intent);
        finishAfterTransition();
    }
    @Override protected void onActivityResult( int requestCode , int resultCode , @Nullable Intent data )
    {
        super.onActivityResult( requestCode , resultCode , data );

        if(requestCode == BROWSEPICTURE && resultCode == RESULT_OK && data != null)
        {
            uripimage =  data.getData();
            if(uripimage != null)
                imageViewForChangePhoto.setImageURI(uripimage);
        }
    }
}
