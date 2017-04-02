package com.putraa.spendboss;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * SpendBoss Android - UpdateData
 * This refers to 'activity_update_data.xml' and this activity enable user to add/edit data.
 *
 * Here user will be able to:
 * - add data
 * - edit data
 * - save data
 * - back to 'MainActivity'
 *
 * @author Adrian Pratama Putra
 * @version 0.1
 * @since 2017-01-23
 */

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
        dbHandler = new MyDBHandler(this); //Call MyDBHandler.java

        usr_bank = (EditText) findViewById(R.id.usr_bank);
        usr_wallet = (EditText) findViewById(R.id.usr_wallet);
        usr_date = (EditText) findViewById(R.id.usr_date);
        usr_earning = (EditText) findViewById(R.id.usr_earning);
        usr_additional = (EditText) findViewById(R.id.usr_additional);
        usr_cutters = (EditText) findViewById(R.id.usr_cutters);
    }

    public void buttonSaveUpdate(View view) {
        /* Button - add data to database and go back to ActivityMain */
        UserData userdata = new UserData(usr_bank.getText().toString(),
                usr_wallet.getText().toString(), usr_date.getText().toString(),
                usr_earning.getText().toString(), usr_additional.getText().toString(),
                usr_cutters.getText().toString());
        boolean isInserted = dbHandler.addUserData(userdata);
        if(isInserted)
            Toast.makeText(UpdateData.this,"Data Inserted", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(UpdateData.this,"Data NOT Inserted", Toast.LENGTH_LONG).show();

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
