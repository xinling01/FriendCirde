package com.linger.friendcircle;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by linger on 2018/10/15.
 */

public class MyGridView extends GridView{
    public MyGridView(Context context) {
        super(context);
    }

    public MyGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST)
        // 就是生成一个符合MeasureSpec的一个32位的包含测量模式和测量高度的int值。
        int expendSpec=MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>>2,MeasureSpec.AT_MOST);

        super.onMeasure(widthMeasureSpec, expendSpec);

    }
}
