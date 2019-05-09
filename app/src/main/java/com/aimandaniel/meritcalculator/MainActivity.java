package com.aimandaniel.meritcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button1;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.button1 = (Button) findViewById(R.id.button1_button);
        this.button2 = (Button) findViewById(R.id.button2_button);
    }

    public void button1_clicked(View v)
    {
        Intent choose_stream_intent = new Intent(this, ChooseStreamActivity.class);
        choose_stream_intent.setAction(Intent.ACTION_VIEW);

        startActivity(choose_stream_intent);
    }

    public void button2_clicked(View v)
    {
        Toast.makeText(this, "This feature is not available yet. Please try again later.", Toast.LENGTH_SHORT).show();
    }
}
