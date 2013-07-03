package com.desarrollo.metropolitano;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class ViewPagerActivity extends Activity {
	ViewPager vp;
	private vpAdapter miAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.consultartarifario);
		
		vp = (ViewPager)findViewById(R.id.viewpager);
		miAdapter = new vpAdapter();
		vp.setAdapter(miAdapter);
	}
	
	private class vpAdapter extends PagerAdapter{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 3; //cantidad de layouts xml
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			// TODO Auto-generated method stub
			return view == ((LinearLayout)object);
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			// TODO Auto-generated method stub
			((ViewPager)container).removeView((LinearLayout)object);
		}

		@Override
		public void finishUpdate(ViewGroup container) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			// TODO Auto-generated method stub
			LayoutInflater inflater = (LayoutInflater)container.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View v = null;
			switch(position){
			case 0: 
				v = inflater.inflate(R.layout.tarifasolobustroncal, null);
				break;
			case 1: 
				v = inflater.inflate(R.layout.tarifasoloalimentador, null);
				break;
			case 2: 
				v = inflater.inflate(R.layout.tarifaalimentadorytroncal, null);
				break;
			}
			((ViewPager)container).addView(v,0);
			return v;
		}

		@Override
		public Parcelable saveState() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void startUpdate(ViewGroup container) {
			// TODO Auto-generated method stub
			
		}
		
		
	}	
}
