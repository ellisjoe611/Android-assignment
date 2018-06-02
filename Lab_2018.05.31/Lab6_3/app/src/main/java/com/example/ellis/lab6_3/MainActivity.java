package com.example.ellis.lab6_3;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText_name, editText_sn;
    Button button_add, button_delete;
    ListView listView;
    public static String[] list;

    SQLiteDatabase db;
    MySQLiteOpenHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper = new MySQLiteOpenHelper(MainActivity.this, "person.db", null, 1);

        editText_name = findViewById(R.id.editText_name);
        editText_sn = findViewById(R.id.editText_sn);
        button_add = findViewById(R.id.button_add);
        button_delete = findViewById(R.id.button_delete);

        listView = findViewById(R.id.listView);
        invalidate();

        //add row
        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText_name.getText().toString();
                String sn = editText_sn.getText().toString();
                if(name.equalsIgnoreCase("") || sn.equalsIgnoreCase("")){
                    Toast.makeText(MainActivity.this, "모든 항목을 입력하세요.", Toast.LENGTH_SHORT).show();
                }else{
                    insert(name, sn);
                    invalidate();
                    editText_sn.setText("");
                    editText_name.setText("");
                }
                
            }
        });

        //delete row
        button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText_name.getText().toString();
                String sn = editText_sn.getText().toString();
                if(name.equalsIgnoreCase("")){
                    Toast.makeText(MainActivity.this, "이름을 입력하세요.", Toast.LENGTH_SHORT).show();
                }else{
                    delete(name);
                    invalidate();
                    editText_sn.setText("");
                    editText_name.setText("");
                }
            }
        });

    }

    public void insert(String name, String sn){
        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("name", name);
        values.put("sn", sn);
        db.insert("person", null, values);
        Log.i("db1", name + "이 정상적으로 추가됨.");
        Toast.makeText(getApplicationContext(), name + " 추가 완료", Toast.LENGTH_SHORT).show();
    }

    public void delete(String name){
        db = helper.getWritableDatabase();
        db.delete("person", "name=?", new String[]{name});
        Log.i("db1", name + "이 정상적으로 삭제됨.");
        Toast.makeText(getApplicationContext(), name + " 삭제 완료", Toast.LENGTH_SHORT).show();
    }

    public void select(){
        db = helper.getReadableDatabase();
        Cursor cursor = db.query("person", null, null, null, null, null, null);

        list = new String[cursor.getCount()];
        int count = 0;

        while(cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String sn = cursor.getString(cursor.getColumnIndex("sn"));

            list[count] = name + " " + sn;
            count += 1;
        }

        cursor.close();
    }

    private void invalidate(){
        select();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
    }
}
