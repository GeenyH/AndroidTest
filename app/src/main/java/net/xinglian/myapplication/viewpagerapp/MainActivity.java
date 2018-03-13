package net.xinglian.myapplication.viewpagerapp;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Toast;

import net.xinglian.myapplication.R;

public class MainActivity extends Activity {

	private ViewPager pager;
	//每一个界面
	private List<View> views;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(LayoutParams.FLAG_FORCE_NOT_FULLSCREEN, 
				LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);


		setContentView(R.layout.activity_viewpager);
		pager=(ViewPager) findViewById(R.id.pager);
		views=new ArrayList<View>();
		LayoutInflater li=getLayoutInflater();
		views.add(li.inflate(R.layout.f1, null));
		views.add(li.inflate(R.layout.f2, null));
		views.add(li.inflate(R.layout.f3, null));

		//需要给ViewPager设置适配器
		PagerAdapter adapter=new PagerAdapter() {
			
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
		
		//给ViewPager添加事件监听
		pager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "您选择了："+arg0+"页面", 0).show();
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
