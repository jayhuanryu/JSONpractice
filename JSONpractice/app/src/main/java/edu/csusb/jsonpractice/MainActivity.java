package edu.csusb.jsonpractice;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {


    private ArrayList<Employee> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String fileName = "employee.json";

        try {
            InputStream is = getAssets().open(fileName);

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            String json = new String(buffer, "UTF-8");

            JSONObject jsonObject = new JSONObject(json);

            JSONArray data = jsonObject.getJSONArray("employees");
            Log.d("data", data.toString());

            for (int i = 0 ; i < data.length(); i ++) {
                JSONObject object = data.getJSONObject(i);
                Log.d("employee name", object.getString("name"));
                Employee employee = new Employee(object.getInt("id"), object.getString("name"), object.getInt("age"));
                arrayList.add(employee);
            }


        } catch (JSONException | IOException e) {
            e.printStackTrace();
            Log.e("Error", e.toString());
        }


        ListView listView = (ListView) findViewById(R.id.listView);
        EmployeeAdapter adapter = new EmployeeAdapter(this, arrayList);
        listView.setAdapter(adapter);


    }
}
