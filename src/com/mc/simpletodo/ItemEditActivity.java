package com.mc.simpletodo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class ItemEditActivity extends Activity {
	EditText et;
	int index;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_item_edit);
		et = (EditText) findViewById(R.id.editText1);
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			String value = extras.getString("value");
			index = extras.getInt("index");
			Log.i("newValue", value);
			et.setText(value);
			et.setSelection(et.getText().length());
		}

	}

	
	public void submit(View v) {
		EditText etName = (EditText) findViewById(R.id.editText1);
		Intent i = new Intent();
		i.putExtra("value", etName.getText().toString());
		i.putExtra("index", index);
		setResult(RESULT_OK, i);
		finish();
	}

}
