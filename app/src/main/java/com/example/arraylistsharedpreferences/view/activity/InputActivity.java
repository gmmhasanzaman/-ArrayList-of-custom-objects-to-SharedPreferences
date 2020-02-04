package com.example.arraylistsharedpreferences.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.arraylistsharedpreferences.model.ExampleItem;
import com.example.arraylistsharedpreferences.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class InputActivity extends AppCompatActivity {


    private static final String TAG = "InputActivity";
    private List<ExampleItem> itemList;
    private EditText nameET, designationET;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        nameET = findViewById(R.id.nameET);
        designationET = findViewById(R.id.designationET);

        itemList = new ArrayList<>();


    }

    public void saveItem(View view) {

        String name = nameET.getText().toString().trim();
        String designation = designationET.getText().toString().trim();
        ExampleItem item = new ExampleItem(name,designation);




        SharedPreferences sharedPreferences = getSharedPreferences("sharedPreferences",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String stringJson = sharedPreferences.getString("task list",null);
        Type type = new TypeToken<List<ExampleItem>>(){}.getType();
        itemList = gson.fromJson(stringJson,type);



        //itemList.add(item);


        String json = gson.toJson(itemList);
        editor.putString("task list", json);
        editor.apply();

        onBackPressed();
    }

    public void incrementHigh(View view) {

        String name = nameET.getText().toString().trim();
        String designation = designationET.getText().toString().trim();
        ExampleItem item = new ExampleItem(name,designation);



        SharedPreferences sharedPreferences = getSharedPreferences("sharedPreferences",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String stringJson = sharedPreferences.getString("task list",null);
        Type type = new TypeToken<List<ExampleItem>>(){}.getType();
        itemList = gson.fromJson(stringJson,type);


        itemList.add(item);


        String json = gson.toJson(itemList);
        editor.putString("task list", json);
        editor.apply();


        for (ExampleItem exampleItem : itemList){
            Log.d(TAG, "incrementHigh: Item"+exampleItem.toString());
        }


    }

    public void clearPreference(View view) {

        SharedPreferences sharedPreferences = getSharedPreferences("sharedPreferences",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("sharedPreferences").apply();
    }

    public void incrementLow(View view) {
    }
}
