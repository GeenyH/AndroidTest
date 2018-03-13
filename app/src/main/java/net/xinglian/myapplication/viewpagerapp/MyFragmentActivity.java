package net.xinglian.myapplication.viewpagerapp;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;

import net.xinglian.myapplication.R;

public class MyFragmentActivity extends FragmentActivity {

	private ViewPager pager;
	private List<Fragment>list;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_tab);
		list=new ArrayList<Fragment>();
		list.add(new ChatFragment());
		list.add(new FindFragment());
		list.add(new ContactFragment());
		pager=(ViewPager) findViewById(R.id.pager);
		MyAdapter adapter=new MyAdapter(getSupportFragmentManager());
		pager.setAdapter(adapter);
	}
	
	//处理Fragment和ViewPager的适配器
	private class MyAdapter extends FragmentPagerAdapter{

		public MyAdapter(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}

		@Override
		public Fragment getItem(int arg0) {
			// TODO Auto-generated method stub
			return list.get(arg0);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return list.size();
		}
		
	}
}
