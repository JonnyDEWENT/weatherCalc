package com.cs357.conversioncalculator.dummy;

import android.support.v7.widget.DividerItemDecoration;

import com.cs357.conversioncalculator.HistoryAdapter;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

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


        public final String timestamp;

        public HistoryItem(Double fromVal, Double toVal, String mode,
                           String fromUnits, String toUnits, String timestamp) {
            this.fromVal = fromVal;
            this.toVal = toVal;
            this.mode = mode;
            this.fromUnits = fromUnits;
            this.toUnits = toUnits;
            this.timestamp = timestamp;
        }

        public HistoryItem()
        {

            this.fromVal = 0.0;
            this.toVal = 0.0;
            this.mode = "Length";
            this.fromUnits = "Meters";
            this.toUnits = "Yards";
            this.timestamp = "N/A";
        }

        @Override
        public String toString() {
            return this.fromVal + " " + this.fromUnits + " = " + this.toVal + " " + this.toUnits;
        }
    }
}

