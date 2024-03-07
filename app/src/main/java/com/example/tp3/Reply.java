package com.example.tp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Reply extends AppCompatActivity {

    private TextView message;
    private EditText EtReply;
    private Button btnReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply);

        message = (TextView) findViewById(R.id.TvSendedMessage);
        EtReply = (EditText) findViewById(R.id.EtReply);
        btnReply = (Button) findViewById(R.id.BtnReply);

        String Message =getIntent().getStringExtra("message");
        message.setText(Message);

        btnReply.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("message", EtReply.getText().toString());
            setResult(3,intent);
            finish();
        });
    }
}