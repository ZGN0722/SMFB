package com.example.wordapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.Map;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Bundle bundle = this.getIntent().getExtras();

        ArrayList<Map<String, String>> items= (ArrayList<Map<String, String>>) bundle.getSerializable("result");
        setWordsListView(items);
    }
    private void setWordsListView(ArrayList<Map<String, String>> items){
        SimpleAdapter adapter = new SimpleAdapter(this, items, R.layout.item,
                new String[]{"id",
                        Words.Word.COLUMN_NAME_WORD,
                        Words.Word.COLUMN_NAME_MEANING,
                        Words.Word.COLUMN_NAME_SAMPLE,
                },
                new int[]{R.id.textId,R.id.textViewWord, R.id.textViewMeaning, R.id.textViewSample});

        ListView list = (ListView) findViewById(R.id.SerWords);
        list.setAdapter(adapter);
    }
}