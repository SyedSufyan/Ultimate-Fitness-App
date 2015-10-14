package com.example.ultimatefitnessapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FormActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_form);
		
		/*EditText ageField = (EditText) findViewById(R.id.eAge);
		String ageS = ageField.getText().toString();
		int age = Integer.parseInt(ageS);
		EditText sexField = (EditText) findViewById(R.id.eSex);
		String sex = sexField.getText().toString();
		EditText heightField = (EditText) findViewById(R.id.eHeight);
		String heightS = heightField.getText().toString();
		int height = Integer.parseInt(heightS);
		EditText weightField = (EditText) findViewById(R.id.eWeight);
		String weightS = weightField.getText().toString();
		int weight = Integer.parseInt(weightS);
		EditText waistField = (EditText) findViewById(R.id.eWaist);
		String waistS = waistField.getText().toString();
		int waist = Integer.parseInt(waistS);
		*/
		Button bSubmit = (Button) findViewById(R.id.bSubmit);
		bSubmit.setOnClickListener(new View.OnClickListener() {
				
				@Override
				//this will have all the things that the button Compute will do on click
				public void onClick(View v) {
					// TODO Auto-generated method stub
					//go to aws option page
					
					Intent intent= new Intent(FormActivity.this,OptionActivity.class);
					startActivity(intent);
				}
			});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.form, menu);
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
}
