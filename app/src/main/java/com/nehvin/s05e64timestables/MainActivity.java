package com.nehvin.s05e64timestables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView timesTablesListView = null;
    SeekBar timesTablesSeekBar = null;

    public void generateTimesTables(int timesTable)
    {
        List<String> timesTableContent = new ArrayList<String>();

        for(int i = 1; i<11; i++)
        {
            timesTableContent.add(Integer.toString(i*timesTable));
        }

        ArrayAdapter<String> timesTableAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,timesTableContent);
        timesTablesListView.setAdapter(timesTableAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timesTablesSeekBar = (SeekBar) findViewById(R.id.timesTableSeekBar);
        timesTablesListView = (ListView) findViewById(R.id.timesTableListView);

        timesTablesSeekBar.setMax(20);
        timesTablesSeekBar.setProgress(10);
        generateTimesTables(10);

        timesTablesSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {

                int min = 1;
                int timesTable;
                if(progress < min)
                {
                    timesTable = min;
                    timesTablesSeekBar.setProgress(min);
                }
                else
                {
                    timesTable = progress;
                }
                generateTimesTables(timesTable);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}
