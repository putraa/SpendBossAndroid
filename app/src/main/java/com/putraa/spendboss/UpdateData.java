package com.putraa.spendboss;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateData extends AppCompatActivity {

    EditText usr_bank;
    EditText usr_wallet;
    EditText usr_date;
    EditText usr_earning;
    EditText usr_additional;
    EditText usr_cutters;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);

        usr_bank = (EditText) findViewById(R.id.usr_bank);
        usr_wallet = (EditText) findViewById(R.id.usr_wallet);
        usr_date = (EditText) findViewById(R.id.usr_date);
        usr_earning = (EditText) findViewById(R.id.usr_earning);
        usr_additional = (EditText) findViewById(R.id.usr_additional);
        usr_cutters = (EditText) findViewById(R.id.usr_cutters);
        dbHandler = new MyDBHandler(this); //Call MyDBHandler.java
    }

    //Add data to database
    public void buttonSaveUpdate(View view) {
        Log.d("alongtag", "in buttonsaveupdate");
        UserData userdata = new UserData(usr_bank.getText().toString(),
                usr_wallet.getText().toString(), usr_date.getText().toString(),
                usr_earning.getText().toString(), usr_additional.getText().toString(),
                usr_cutters.getText().toString());
        boolean isInserted = dbHandler.addUserData(userdata);
        if(isInserted)
            Toast.makeText(UpdateData.this,"Data Inserted", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(UpdateData.this,"Data NOT Inserted", Toast.LENGTH_LONG).show();
        // String database_info = printDatabase();

        Intent i = new Intent(this, MainActivity.class);
        // i.putExtra("database_info", database_info);
        startActivity(i);
    }

    public String printDatabase() {
        String dbString = dbHandler.databaseToString();
        usr_bank.setText("");
        usr_wallet.setText("");
        usr_date.setText("");
        usr_earning.setText("");
        usr_additional.setText("");
        usr_cutters.setText("");

        return dbString;
    }
}
