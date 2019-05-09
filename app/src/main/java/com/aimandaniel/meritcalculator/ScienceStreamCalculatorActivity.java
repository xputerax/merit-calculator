package com.aimandaniel.meritcalculator;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class ScienceStreamCalculatorActivity extends AppCompatActivity {

    private Spinner maths_spinner;
    private Spinner addmaths_spinner;
    private Spinner physics_spinner;
    private Spinner chem_spinner;
    private Spinner bio_spinner;
    private Spinner other1_spinner;
    private Spinner other2_spinner;
    private Spinner other3_spinner;
    private EditText cocu_points_input;
    private TextView merit_label;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science_stream_calculator);

        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.grades, R.layout.support_simple_spinner_dropdown_item);

        this.maths_spinner = findViewById(R.id.maths_spinner);
        this.addmaths_spinner = findViewById(R.id.addmaths_spinner);
        this.physics_spinner = findViewById(R.id.physics_spinner);
        this.chem_spinner = findViewById(R.id.chem_spinner);
        this.bio_spinner = findViewById(R.id.bio_spinner);
        this.other1_spinner = findViewById(R.id.other1_spinner);
        this.other2_spinner = findViewById(R.id.other2_spinner);
        this.other3_spinner = findViewById(R.id.other3_spinner);
        this.cocu_points_input = findViewById(R.id.cocu_points_input);
        this.merit_label = findViewById(R.id.merit_label);

        this.maths_spinner.setAdapter(adapter);
        this.addmaths_spinner.setAdapter(adapter);
        this.physics_spinner.setAdapter(adapter);
        this.chem_spinner.setAdapter(adapter);
        this.bio_spinner.setAdapter(adapter);
        this.other1_spinner.setAdapter(adapter);
        this.other2_spinner.setAdapter(adapter);
        this.other3_spinner.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void science_calculate_button_clicked(View v)
    {
        Resources res = getResources();
        int[] grade_points = res.getIntArray(R.array.grade_points);

        int maths_position = this.maths_spinner.getSelectedItemPosition();
        int maths_point = grade_points[maths_position];

        int addmaths_position = this.addmaths_spinner.getSelectedItemPosition();
        int addmaths_point = grade_points[addmaths_position];

        int physics_position = this.physics_spinner.getSelectedItemPosition();
        int physics_point = grade_points[physics_position];

        int chem_position = this.chem_spinner.getSelectedItemPosition();
        int chem_point = grade_points[chem_position];

        int bio_position = this.bio_spinner.getSelectedItemPosition();
        int bio_point = grade_points[bio_position];

        int other1_position = this.other1_spinner.getSelectedItemPosition();
        int other1_point = grade_points[other1_position];

        int other2_position = this.other2_spinner.getSelectedItemPosition();
        int other2_point = grade_points[other2_position];

        int other3_position = this.other3_spinner.getSelectedItemPosition();
        int other3_point = grade_points[other3_position];

        int main_subjects_point_sum = maths_point + addmaths_point + physics_point + chem_point + bio_point;

        int other_subjects_point_sum = other1_point + other2_point + other3_point;
        BigDecimal other_subjects_point_sum_part = new BigDecimal((long) other_subjects_point_sum * 30.0 / 54.0);

        BigDecimal sum_main_other = other_subjects_point_sum_part.add(new BigDecimal(main_subjects_point_sum));

        BigDecimal total_academic_points = sum_main_other.multiply(new BigDecimal(90))
                .divide(new BigDecimal(120))
                .setScale(3, RoundingMode.HALF_EVEN);

        String cocu_points;
        String cocu_points_input = this.cocu_points_input.getText().toString();

        if (cocu_points_input.isEmpty()) {
            cocu_points = "0.00";
        } else {
            cocu_points = cocu_points_input;
        }

        BigDecimal merit = new BigDecimal(total_academic_points.add(new BigDecimal(cocu_points)).toPlainString());

        this.merit_label.setText("Your merit point is: " + merit.toPlainString());
    }

    public void science_help_button_clicked(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.science_stream_help_dialog, null);

        builder.setView(view);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();

        dialog.show();
    }

}
