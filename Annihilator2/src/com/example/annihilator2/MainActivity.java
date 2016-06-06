package com.example.annihilator2;

import java.util.Arrays;
import java.util.Collections;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		setListAdapter(new MyAdapter(this, android.R.layout.simple_list_item_1,R.id.textView1, getResources().getStringArray(R.array.wallpapers)));
		
		ImageView image1 = (ImageView) findViewById(R.id.imageView1);
		Intent intent = getIntent();
		String action = intent.getAction();
		if (Intent.ACTION_SEND.equals(action)){		
		image1.setImageURI((Uri) getIntent().getExtras().get(Intent.EXTRA_STREAM));
		}
		
		
		final EditText edit1 = (EditText) findViewById(R.id.editText1);
					
		Button but1 = (Button) findViewById(R.id.button1);
		but1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent1 = new Intent(MainActivity.this,Second.class);
				intent1.putExtra("text",edit1.getText().toString());
				startActivity(intent1);
				
				Log.d("ME","button1 was clicked");
				
			}
		});
	}
	
	private class MyAdapter extends ArrayAdapter<String>{

		public MyAdapter(Context context, int resource, int textViewResourceId, String[] strings) {
			super(context, resource, textViewResourceId, strings);
			// TODO Auto-generated constructor stub
		} 
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			
			LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View row = inflater.inflate(R.layout.list_item, parent, false);
			
			String[] items = getResources().getStringArray(R.array.wallpapers);
			System.out.println(Arrays.toString(items));
			ImageView image1 = (ImageView) row.findViewById(R.id.imageView1);
			TextView text1 = (TextView) row.findViewById(R.id.textView1);
			
			text1.setText(items[position]);
			
			if (items[position].equals("penguins")){
				image1.setImageResource(R.drawable.penguins);
						}
			else if (items[position].equals("desert")){
				image1.setImageResource(R.drawable.desert);
						}
			else if (items[position].equals("tulips")){
				image1.setImageResource(R.drawable.tulips);
			}
			return row;
			
		//	return super.getView(position, convertView, parent);
		}
	}
}
