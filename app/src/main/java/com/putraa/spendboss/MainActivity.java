package com.putraa.spendboss;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

/**
 * SpendBoss Android - MainActivity
 * This refers to 'activity_main.xml' and this activity is the main interface
 * that the user will interact when they open the app.
 *
 * Here user will be able to:
 * - overview their data in graphical format
 * - navigate to add/remove
 * - navigate to setting
 * - sign out
 *
 * @author Adrian Pratama Putra
 * @version 0.1
 * @since 2017-01-23
 */

public class MainActivity extends AppCompatActivity {
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHandler = new MyDBHandler(this);

        Bundle database_data = getIntent().getExtras();
        if(database_data==null) {
            return;
        }
    }

    public void gotoUpdateData(View view) {
        /* Change Activity to UpdateData */
        Intent i = new Intent(this, UpdateData.class);
        startActivity(i);
    }

    public void dataViewAllAlert(View view) {
        /* Button - open an AlertDialog and display data */
        Cursor res = dbHandler.getAllData();
        if(res.getCount() == 0) {
            showMessage("Error", "NOTHING FOUND!!");
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()) {
            buffer.append("Id :" + res.getString(0)+"\n");
            buffer.append("Date :" + res.getString(1)+"\n");
            buffer.append("DaysAfter :" + res.getString(2)+"\n");
            buffer.append("Hand :" + res.getString(3)+"\n");
            buffer.append("Bank :" + res.getString(4)+"\n");
            buffer.append("Spending :" + res.getString(5)+"\n");
            buffer.append("Additional :" + res.getString(6)+"\n");
            buffer.append("Cutters :" + res.getString(7)+"\n");
            buffer.append("Work :" + res.getString(8)+"\n");
            buffer.append("Skip :" + res.getString(9)+"\n");
            buffer.append("Notes :" + res.getString(10)+"\n\n");
        }

        showMessage("Data", buffer.toString());
    }

    public void showMessage(String title, String Message) {
        /* AlertDialog method that can be taylored in different methods */
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
