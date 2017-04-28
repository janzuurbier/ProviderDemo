package com.cookbook.provider;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {
	public static final Uri CONTENT_URI=
			Uri.parse("content://zrb.hu.nl.diaries.DiariesProvider/datastorage");

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ContentResolver resolver = getContentResolver();
		Cursor cursor = resolver.query(CONTENT_URI, null, null, null, null);
		TextView tv = (TextView) findViewById(R.id.textview1);
		if (cursor.moveToFirst()){
			while(true){
				tv.append(cursor.getString(1) + "\r\n");
				cursor.moveToNext();
				if(cursor.isAfterLast()) break;
			}
		}
		else
			tv.append("no enties in diary");
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
