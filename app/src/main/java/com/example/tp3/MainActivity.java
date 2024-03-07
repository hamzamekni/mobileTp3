package com.example.tp3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView TvContentMain;
    private EditText EtSend;
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TvContentMain = (TextView) findViewById(R.id.TvContentMain);
        EtSend = (EditText) findViewById(R.id.EdSend);
        btnSend = (Button) findViewById(R.id.BtnSend);

        btnSend.setOnClickListener(v -> {
            Intent intent = new Intent(this, Reply.class);
            intent.putExtra("message", EtSend.getText().toString());
            startActivityForResult(intent,2);
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 2){
            if (resultCode == 3){
                String res = data.getStringExtra("message");
                TvContentMain.setText(res);
            }
        }
    }
}