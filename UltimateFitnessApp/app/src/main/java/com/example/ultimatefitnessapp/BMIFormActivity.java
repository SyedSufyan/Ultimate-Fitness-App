package com.example.ultimatefitnessapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BMIFormActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiform);

        Button bBMI = (Button) findViewById(R.id.bcalBMI);
        bBMI.setOnClickListener(new View.OnClickListener() {

            @Override
            //this will have all the things that the button Compute will do on click
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //go to aws option page
                //read the form values
                EditText heightField = (EditText) findViewById(R.id.eHeight);
                String heightS = heightField.getText().toString();
                int height = Integer.parseInt(heightS);
                EditText weightField = (EditText) findViewById(R.id.eWeight);
                String weightS = weightField.getText().toString();
                int weight = Integer.parseInt(weightS);
                String bmiStat = "";
                double bmi = (weight/2.20462)/((height/100)^2);
                TextView outbmi = (TextView) findViewById(R.id.bmiResult);

                String tBmi = String.valueOf(bmi);
                Toast.makeText(getApplicationContext(), String.valueOf(bmi),
                        Toast.LENGTH_LONG).show();
                /*
                if(bmi<18.5)
                {
                    outbmi.setText(tBmi);
                    bmiStat = "Under Weight";
                }
                else if (bmi<24.9)
                {
                    outbmi.setText(tBmi);
                    bmiStat = "Under Weight";
                }
                else if (bmi<29.9)
                {
                    outbmi.setText(tBmi);
                    bmiStat = "Under Weight";
                }
                else
                {
                    outbmi.setText(tBmi);
                    bmiStat = "Under Weight";
                }


                Intent intent = new Intent(BMIFormActivity.this, BMIActivity.class);

                startActivity(intent); */
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bmiform, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
