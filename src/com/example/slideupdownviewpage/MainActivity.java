package com.example.slideupdownviewpage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

/**
 * ���»�����ViewPagerʵ��
 * @author ��Сǿ
 *
 */
public class MainActivity extends FragmentActivity {

	//��������Fragment����
	
	private ViewPager mViewPager;
	private ViewPagerAdapter mViewPagerAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		setUpViewPage();
	}
	
	private void setUpViewPage(){
		mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
		mViewPager = (ViewPager) findViewById(R.id.viewpager);
		mViewPager.setAdapter(mViewPagerAdapter);
	}
	
	/**
	 * ViewPager������
	 * @author ��Сǿ
	 *
	 */
	class ViewPagerAdapter extends FragmentPagerAdapter{
		
		private Class[] fragments;
		public ViewPagerAdapter(FragmentManager fm) {
			super(fm);
			fragments = new Class[]{Fragment1.class, Fragment2.class, Fragment3.class};
		}

		@Override
		public Fragment getItem(int position) {
			try {
				return (Fragment) fragments[position].newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
				return null;
			} catch (IllegalAccessException e) {
				e.printStackTrace();
				return null;
			}
		}	

		@Override
		public int getCount() {
			return fragments.length;
		}
		
	}
}
