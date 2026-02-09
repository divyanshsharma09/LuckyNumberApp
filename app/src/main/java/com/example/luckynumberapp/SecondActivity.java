package com.example.luckynumberapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {
    Button btn1;
    TextView txt1,txt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        btn1 = findViewById(R.id.button1);
        txt1 = findViewById(R.id.welcometextView21);
        txt2 = findViewById(R.id.luckytextView22);
        Intent i = getIntent();
        String name = i.getStringExtra("name");
        int random_num = lucky_number();
        txt2.setText(""+random_num);
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                shareData(name,random_num);
            }

        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public int lucky_number(){w
        Random random = new Random();
        int min = 1;
        int max = 1000;
        int random_int = random.nextInt((max-min+1) +min);
        return random_int;

    }
    public void shareData(String name,int random_num){
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT,name+"got lucky today");
        i.putExtra(Intent.EXTRA_TEXT,"Lucky number is "+random_num);
        startActivity(Intent.createChooser(i,"Share"));

    }
}