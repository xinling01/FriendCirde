package com.linger.friendcircle;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by linger on 2018/10/15.
 */

public class MyPagerAdapter extends PagerAdapter{

    private List<View> list;
    public MyPagerAdapter(List<View> list) {
        this.list = list;
    }
    @Override
    public int getCount() {
        if(list!=null&&list.size()>0){
            return list.size();
        }else {
            return 0;
        }
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(list.get(position));
        return list.get(position);
    }
}
