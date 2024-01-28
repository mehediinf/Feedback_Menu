package com.example.feedback_menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Feedback_activity extends AppCompatActivity implements View.OnClickListener {

    private Button sendButton,clearButton;
    private EditText nameEditText,messageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        sendButton = findViewById(R.id.sendButton_Id);
        clearButton = findViewById(R.id.clearButton_Id);

        nameEditText = findViewById(R.id.nameEditText_Id);
        messageEditText = findViewById(R.id.messageEditText_Id);


        sendButton.setOnClickListener(this);
        clearButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        String name = nameEditText.getText().toString();
        String message = messageEditText.getText().toString();


        try {
            if (v.getId()==R.id.sendButton_Id){

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/email");

                intent.putExtra(Intent.EXTRA_EMAIL,new String[] {"mehediinform@gmail.com"});

                intent.putExtra(Intent.EXTRA_SUBJECT,"Feedback from app");
                intent.putExtra(Intent.EXTRA_TEXT,"Name : "+ name + "\n Message : " + message );

                startActivity(Intent.createChooser(intent,"Feedback with"));


            }

            else if (v.getId()==R.id.clearButton_Id){

                nameEditText.setText("");
                messageEditText.setText("");

            }

        }catch (Exception e){

            Toast.makeText(getApplicationContext(),"Exception : "+e,Toast.LENGTH_SHORT).show();

        }




    }
}