package net.xinglian.myapplication.viewpagerapp;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.widget.SearchViewCompat.OnCloseListenerCompat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import net.xinglian.myapplication.R;

public class MyTabActivity extends Activity {

	private ViewPager pager;
	private List<View> views;
	//放标签页
	private List<TextView>tvs=new ArrayList<TextView>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_tab);
		initTextView();
		//初始化ViewPager组件
		initView();
		initViewPager();
	}
	
	public void initTextView() {
		// TODO Auto-generated method stub
		TextView tv1=(TextView) findViewById(R.id.tv1);
		tv1.setTextColor(Color.BLUE);
		TextView tv2=(TextView) findViewById(R.id.tv2);
		TextView tv3=(TextView) findViewById(R.id.tv3);
		//添加点击事件
		//OnClickListener click=new MyClickListener();
		tv1.setOnClickListener(new MyClickListener(0));
		tv2.setOnClickListener(new MyClickListener(1));
		tv3.setOnClickListener(new MyClickListener(2));
		tvs.add(tv1);
		tvs.add(tv2);
		tvs.add(tv3);
	}	
	private class MyClickListener implements OnClickListener{

		private int index;
		public MyClickListener(int index) {
			// TODO Auto-generated constructor stub
			this.index=index;
		}
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			//改变ViewPager当前显示页面
			pager.setCurrentItem(index);
		}
	}

	//初始化ViewPager中显示的数据
	public void initView() {
		// TODO Auto-generated method stub
		views=new ArrayList<View>();
		LayoutInflater li=getLayoutInflater();
		views.add(li.inflate(R.layout.f1, null));
		views.add(li.inflate(R.layout.f2, null));
		views.add(li.inflate(R.layout.f3, null));
	}
	
	
	public void initViewPager() {
		// TODO Auto-generated method stub
		pager=(ViewPager) findViewById(R.id.pager);
		PagerAdapter adapter=new MyPagerAdapter();
		pager.setAdapter(adapter);
		pager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int index) {
				// TODO Auto-generated method stub
				for(int i=0;i<tvs.size();i++){
					if(i==index){
						tvs.get(i).setTextColor(Color.BLUE);
					}else{
						tvs.get(i).setTextColor(Color.rgb(55,55,55));
					}
				}
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
	private class MyPagerAdapter extends PagerAdapter{

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
	}
}
