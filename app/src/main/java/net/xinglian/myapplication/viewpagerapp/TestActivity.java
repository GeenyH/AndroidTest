package net.xinglian.myapplication.viewpagerapp;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

import net.xinglian.myapplication.R;

public class TestActivity extends Activity {

	private ViewPager pager;
	//每一个界面
	private List<View> views;
	//标题
	private String[] titles={"新闻","娱乐","军事"};
	
	private PagerTabStrip t;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(LayoutParams.FLAG_FORCE_NOT_FULLSCREEN, 
				LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
		setContentView(R.layout.activity_test);
		
		t=(PagerTabStrip) findViewById(R.id.title);
		//自定义table的样式
		t.setBackgroundColor(Color.MAGENTA);
		t.setTextColor(Color.BLUE);
		t.setTextSize(0, 25f);
		t.setTabIndicatorColor(Color.GREEN);
		
		pager=(ViewPager) findViewById(R.id.pager);
		views=new ArrayList<View>();
		LayoutInflater li=getLayoutInflater();
		views.add(li.inflate(R.layout.f1, null));
		views.add(li.inflate(R.layout.f2, null));
		views.add(li.inflate(R.layout.f3, null));
		//需要给ViewPager设置适配器
		PagerAdapter adapter=new PagerAdapter() {
			
			//提供标题的内容
			@Override
			public CharSequence getPageTitle(int position) {
				// TODO Auto-generated method stub
				return titles[position];
			}
			
			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				// TODO Auto-generated method stub
				return arg0==arg1;
			}
			//有多少个切换页
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return views.size();
			}

			//对超出范围的资源进行销毁
			@Override
			public void destroyItem(ViewGroup container, int position,
					Object object) {
				// TODO Auto-generated method stub
				//super.destroyItem(container, position, object);
				container.removeView(views.get(position));
			}
			//对显示的资源进行初始化
			@Override
			public Object instantiateItem(ViewGroup container, int position) {
				// TODO Auto-generated method stub
				//return super.instantiateItem(container, position);
				container.addView(views.get(position));
				return views.get(position);
			}
			
		};
		pager.setAdapter(adapter);
	}
}
