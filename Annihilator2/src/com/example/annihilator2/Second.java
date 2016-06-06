package com.example.annihilator2;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Second extends Activity {
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.second);
	
	TextView text2 = (TextView) findViewById(R.id.textView2);
	text2.setText(getIntent().getExtras().getString("text"));
	Log.d("ME","button1 was clicked2");
	
	
}
}
