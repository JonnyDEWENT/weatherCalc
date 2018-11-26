package com.cs357.conversioncalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SettingsActivity extends AppCompatActivity {

    public String fromSelection = "X";
    public String toSelection = "Y";
    public String curFromUnit;
    public String curToUnit;
    public int UNIT_SELECTION = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Intent intentSettings = getIntent();
        Bundle b = intentSettings.getExtras();

        if (b != null)
        {
            UNIT_SELECTION = (int)b.getInt("mode");
            curFromUnit = (String)b.getString("curFromUnit");
            curToUnit = (String)b.getString("curToUnit");
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent();
                Bundle b = new Bundle();

                b.putString("fromSelection", fromSelection);
                b.putString("toSelection", toSelection);

                intent.putExtras(b);
                setResult(MainActivity.RESULT_OK, intent);
                finish();
            }
        });

        Spinner fromSpinner = (Spinner) findViewById(R.id.fromSpinner);
        Spinner toSpinner = (Spinner) findViewById(R.id.toSpinner);

        ArrayAdapter<CharSequence> length_adapter = ArrayAdapter.createFromResource(this,
                R.array.length_units, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> volume_adapter = ArrayAdapter.createFromResource(this,
                R.array.volume_units, android.R.layout.simple_spinner_item);

        if (UNIT_SELECTION == 1)
        {
            fromSpinner.setAdapter(length_adapter);
            toSpinner.setAdapter(length_adapter);

            fromSpinner.setSelection(length_adapter.getPosition(curFromUnit));
            toSpinner.setSelection(length_adapter.getPosition(curToUnit));
        }
        else if (UNIT_SELECTION == 2)
        {
            fromSpinner.setAdapter(volume_adapter);
            toSpinner.setAdapter(volume_adapter);

            fromSpinner.setSelection(volume_adapter.getPosition(curFromUnit));
            toSpinner.setSelection(volume_adapter.getPosition(curToUnit));
        }

        fromSelection = curFromUnit;
        toSelection = curToUnit;

        fromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                fromSelection = (String) adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }

        });

        toSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                toSelection = (String) adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }

        });
    }

}
