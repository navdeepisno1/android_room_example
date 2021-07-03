package com.suvidha.roomdatabasel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.Fts4;
import androidx.room.Insert;
import androidx.room.PrimaryKey;
import androidx.room.Query;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText editText_fname,editText_lname;
    Button button_add;
    RecyclerView recyclerView_items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_fname = findViewById(R.id.main_et_fname);
        editText_lname = findViewById(R.id.main_et_lname);
        button_add = findViewById(R.id.main_btn_add);
        recyclerView_items = findViewById(R.id.main_rv_items);

        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editText_fname.getText().toString().trim().isEmpty() || editText_fname.getText().toString().trim().isEmpty())
                {
                    return;
                }
                User user = new User();
                user.firstName = editText_fname.getText().toString().trim();
                user.lastName = editText_lname.getText().toString().trim();
            }
        });

        //new insertInfo().execute();


    }

    public class insertInfo extends AsyncTask<Void,Void,Void>
    {

        @Override
        protected Void doInBackground(Void... voids) {
            AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                    AppDatabase.class, "database-name").build();
            Log.e("db","created");
            UserDao dao = db.getUserDao();
            Log.e("dao","created");
            User user = new User();
            user.firstName = "Navdeep";
            user.lastName = "Sharma";
            Log.e("user","created");
            dao.insertAll(user);
            Log.e("user","inserted");

            db.close();
            Log.e("db","closed");
            return null;
        }
    }





}