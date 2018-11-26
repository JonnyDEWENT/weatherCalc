package com.cs357.conversioncalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.cs357.conversioncalculator.dummy.HistoryContent;

public class HistoryActivity extends AppCompatActivity implements HistoryFragment.OnListFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);


    }

    @Override
    public void onListFragmentInteraction(HistoryContent.HistoryItem item) {
        System.out.println("Interact!");
        Intent intent = new Intent();
        String[] vals = {item.fromVal.toString(), item.toVal.toString(), item.mode, item.fromUnits, item.toUnits};
        intent.putExtra("item", vals);
        setResult(MainActivity.HISTORY_RESULT,intent);
        finish();

    }

}
