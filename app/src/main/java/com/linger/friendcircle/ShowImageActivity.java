package com.linger.friendcircle;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linger on 2018/10/15.
 */

public class ShowImageActivity extends AppCompatActivity{
    private ViewPager viewPager;
    private List<View> listViews;
    private int index=0;
    private MyPagerAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_image_layout);
        init();
    }

    private void init() {
        final Intent intent=getIntent();
        viewPager= (ViewPager) findViewById(R.id.show_view_pager);
        listViews = new ArrayList<View>();   //��ʼ��list
        for (int i = 0; i <intent.getIntArrayExtra("image").length ; i++) {
            View view= LayoutInflater.from(getApplicationContext()).inflate(
			R.layout.view_pager_item,null);
            ImageView iv=view.findViewById(R.id.view_image);
            iv.setBackgroundResource(intent.getIntArrayExtra("image")[i]);
            listViews.add(view);
        }
        adapter=new MyPagerAdapter(listViews);
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new PageChangeListener());
        viewPager.setCurrentItem(intent.getIntExtra("id", 0));

    }


    private class PageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrollStateChanged(int arg0) {

            }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageSelected(int arg0) {
            index = arg0;
        }

    }
}
