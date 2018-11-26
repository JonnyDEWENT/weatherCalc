package com.cs357.conversioncalculator.dummy;

import android.support.v7.widget.DividerItemDecoration;

import com.cs357.conversioncalculator.HistoryAdapter;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HistoryContent {
    public static final List<HistoryItem> ITEMS = new ArrayList<HistoryItem>();

    public static void addItem(HistoryItem item)
    {

        ITEMS.add(item);


    }

    public static class HistoryItem {
        public final Double fromVal;
        public final Double toVal;
        public final String mode;
        public final String fromUnits;
        public final String toUnits;
        public String _key;


        public final DateTime timestamp;

        public HistoryItem(Double fromVal, Double toVal, String mode,
                           String fromUnits, String toUnits, DateTime timestamp) {
            this.fromVal = fromVal;
            this.toVal = toVal;
            this.mode = mode;
            this.fromUnits = fromUnits;
            this.toUnits = toUnits;
            this.timestamp = timestamp;
        }

        @Override
        public String toString() {
            return this.fromVal + " " + this.fromUnits + " = " + this.toVal + " " + this.toUnits;
        }
    }
}

