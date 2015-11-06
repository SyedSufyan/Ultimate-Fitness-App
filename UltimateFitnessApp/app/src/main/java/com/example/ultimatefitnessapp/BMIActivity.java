package com.example.ultimatefitnessapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class BMIActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bmi);

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
