package com.aimandaniel.meritcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ChooseStreamActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_stream);
    }

    public void science_stream_button_clicked(View v)
    {
        Intent choose_science_stream = new Intent(this, ScienceStreamCalculatorActivity.class);
        choose_science_stream.setAction(Intent.ACTION_VIEW);

        startActivity(choose_science_stream);
    }

    public void literature_stream_button_clicked(View v)
    {
        Intent choose_lit_stream = new Intent(this, LiteratureStreamCalculatorActivity.class);
        choose_lit_stream.setAction(Intent.ACTION_VIEW);

        startActivity(choose_lit_stream);
    }
}
