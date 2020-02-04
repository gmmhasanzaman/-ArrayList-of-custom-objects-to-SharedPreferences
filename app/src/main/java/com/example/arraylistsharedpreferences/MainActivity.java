package com.example.arraylistsharedpreferences;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.arraylistsharedpreferences.view.activity.InputActivity;
import com.example.arraylistsharedpreferences.model.ExampleItem;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private List<ExampleItem> mExampleList;
    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerView);

        //buildRecyclerView();


    }

    @Override
    protected void onStart() {
        super.onStart();

        loadData();
    }

    private void loadData() {


        mExampleList = new ArrayList<>();


        SharedPreferences sharedPreferences = getSharedPreferences("sharedPreferences",MODE_PRIVATE);
        Gson gson = new Gson();
        String stringJson = sharedPreferences.getString("task list",null);
        Type type = new TypeToken<List<ExampleItem>>(){}.getType();
        mExampleList = gson.fromJson(stringJson,type);

        Log.d(TAG, "loadData: "+mExampleList.toString());
        Log.d(TAG, "loadData: "+mExampleList.size());


        mAdapter = new ExampleAdapter(this,mExampleList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();


    }

    public void startInputActivity(View view) {

        startActivity(new Intent(this, InputActivity.class));
    }

    private void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mExampleList = new ArrayList<>();
        mAdapter = new ExampleAdapter(this,mExampleList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
    }
}
