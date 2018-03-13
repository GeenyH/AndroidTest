package net.xinglian.myapplication.viewpagerapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

import net.xinglian.myapplication.R;

public class LanuchActivity extends Activity {

	public void mybtn(View view) {
		// TODO Auto-generated method stub
		int id=view.getId();
		if(id== R.id.btn1){
			startActivity(new Intent(this,MainActivity.class));
		}
		else if(id==R.id.btn2){
			startActivity(new Intent(this,TestActivity.class));
		}
		else if(id==R.id.btn3){
			startActivity(new Intent(this,MyTabActivity.class));
		}
		else if(id==R.id.btn4){
			startActivity(new Intent(this,MyFragmentActivity.class));
		}
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lanuch);
	}
}
