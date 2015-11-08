package com.example.ultimatefitnessapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

/**
 * Created by sergio gil on 11/7/15.
 */
public class BMRActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmr); /* TODO */

        //Get the bundle
        Bundle bundle = getIntent().getExtras();

        //Extract the data…
        String data = bundle.getString("Trans");
        double bmi = Double.parseDouble(data);
        //truncating
        bmi = roundTwoDecimals(bmi);
        data = String.valueOf(bmi);
        String bmiStat = "";
        TextView outbmi = (TextView) findViewById(R.id.bmiResult);
        TextView statbmi = (TextView)findViewById(R.id.tStatb);
        if(bmi<18.5)
        {
            outbmi.setText(data);
            bmiStat = "UnderWeight";
            statbmi.setText(bmiStat);

        }
        else if (bmi<24.9)
        {
            outbmi.setText(data);
            bmiStat = "Healthy";
            statbmi.setText(bmiStat);
        }
        else if (bmi<29.9)
        {
            outbmi.setText(data);
            bmiStat = "OverWeight";
            statbmi.setText(bmiStat);
        }
        else
        {
            outbmi.setText(data);
            bmiStat = "Obese";
            statbmi.setText(bmiStat);
        }

        Button bmiWeb = (Button) findViewById(R.id.bBMIweb);
        bmiWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri uri = Uri.parse("http://www.cdc.gov/healthyweight/assessing/bmi/adult_bmi/"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.bmi, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public double roundTwoDecimals(double d) {
        DecimalFormat twoDForm = new DecimalFormat("#.##");
        return Double.valueOf(twoDForm.format(d));
    }
}
