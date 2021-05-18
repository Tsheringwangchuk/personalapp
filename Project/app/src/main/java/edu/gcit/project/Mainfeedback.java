package edu.gcit.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Mainfeedback extends AppCompatActivity implements View.OnClickListener {
    private Button sendButton, clearButton;
    private EditText editTextname, editTextmessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainfeedback);
        sendButton = (Button)findViewById(R.id.sendbutton);
        clearButton = (Button)findViewById(R.id.clearbutton);
        editTextname = (EditText)findViewById(R.id.nameEdittext);
        editTextmessage = (EditText) findViewById(R.id.messageedittext);

        sendButton.setOnClickListener(this);
        clearButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        try {
            String name = editTextname.getText().toString();
            String message = editTextmessage.getText().toString();
            if(v.getId()==R.id.sendbutton)
            {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/email");
                intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"edzongkha2021@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback");
                intent.putExtra(Intent.EXTRA_TEXT, "name: "+name+"\n Message: "+message);
                startActivity(Intent.createChooser(intent, "Share With"));
            }
            else if(v.getId()==R.id.clearbutton)
            {
                editTextmessage.setText(" ");
                editTextname.setText(" ");
            }

        }catch (Exception e)
        {
            Toast.makeText(this, "Exception :" + e, Toast.LENGTH_SHORT).show();

        }

    }
}