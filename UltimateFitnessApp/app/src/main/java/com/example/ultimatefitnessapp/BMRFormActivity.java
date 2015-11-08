package com.example.ultimatefitnessapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by sergio gil on 11/7/15.
 */
public class BMRFormActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmrform); /*TODO*/

        Button bBMI = (Button) findViewById(R.id.bcalBMI); /*TODO*/
        bBMI.setOnClickListener(new View.OnClickListener() { /*TODO*/

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

                /* Age */
                EditText ageField = (EditText) findViewById(R.id.eAge);
                String ageS = ageField.getText().toString();
                int age = Integer.parseInt(ageS);

                /* Gender */


                /* Calculations */

                double bmr = 0;

                //if(gender = male)

                bmr = 10 * weight + 6.25 * height - 5 * age + 5;

                //else (female)

                bmr = 10 * weight + 6.25 * height - 5 * age - 161;


                String bmiStat = "";
                double bmi = (weight/2.20462)/((height/100)^2);



                String tBmr = String.valueOf(bmr);

                //Create the bundle
                Bundle bundle = new Bundle();

                //Add your data to bundle
                bundle.putString("Trans", tBmr);



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

                */
                Intent intent = new Intent(BMRFormActivity.this, BMRActivity.class);

                //Add the bundle to the intent
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bmrform, menu);
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
