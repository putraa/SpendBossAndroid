package com.putraa.spendboss;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnViewAll;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle database_data = getIntent().getExtras();

        if(database_data==null) {
            return;
        }

        btnViewAll = (Button)findViewById(R.id.button_view_data);
        viewAll();
    }

    public void gotoUpdateData(View view) {
        Intent i = new Intent(this, UpdateData.class);
        startActivity(i);
    }

    public void viewAll() {
        btnViewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = dbHandler.getAllData();
                        if(res.getCount() == 0) {
                            showMessage("Error", "Nothing found");
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

                        // show all data
                        showMessage("Data", buffer.toString());
                    }
                }
        );
    }

    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }


}
