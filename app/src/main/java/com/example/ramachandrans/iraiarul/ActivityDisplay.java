package com.example.ramachandrans.iraiarul;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.ramachandrans.iraiarul.activity.key;

public class ActivityDisplay extends Activity {
    TextView t1;
    Button b1;
    String text="";
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
        b1 = findViewById(R.id.b1);
        t1 = findViewById(R.id.t1);

        b1.setText("மீண்டும் செல்ல கிளிக் செய்க");
        Intent intent = getIntent();
        text = intent.getStringExtra(key);
        t1.setText(text);
        t1.setVerticalScrollBarEnabled(true);
        t1.setMovementMethod(new ScrollingMovementMethod());
    }

    public void launchHome(View v){
        Intent intent = new Intent(v.getContext(),activity.class);
        startActivity(intent);
    }
}
