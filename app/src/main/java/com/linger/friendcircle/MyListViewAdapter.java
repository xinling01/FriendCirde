package com.linger.friendcircle;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;



/**
 * Created by linger on 2018/10/15.
 */

public class MyListViewAdapter extends BaseAdapter{
    int[] image={R.mipmap.a,R.mipmap.b,R.mipmap.c,R.mipmap.d,R.mipmap.g,R.mipmap.b,R.mipmap.c, R.mipmap.h,R.mipmap.d};
    ArrayList<HashMap<String,Object>> imageList;

    public MyListViewAdapter(Context context) {
        this.context = context;
        imageList =new ArrayList<>();
        for (int i = 0; i <9 ; i++) {
           HashMap<String,Object> map=new HashMap<String, Object>();
            map.put("image",image[i]);
            imageList.add(map);
        }
    }

    private Context context;
    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 5;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyHolder holder=new MyHolder();
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.list_item_layout,null);
            holder.titleTV=convertView.findViewById(R.id.list_title_text);
            holder.titleIV=convertView.findViewById(R.id.list_title_image);
            holder.gridView=convertView.findViewById(R.id.list_item_grid_view);
            convertView.setTag(holder);
        }else {
            holder= (MyHolder) convertView.getTag();
        }
        holder.titleTV.setText("这是朋友圈的第"+(position+1)+"条数据");
        SimpleAdapter simpleAdapter=new SimpleAdapter(context,imageList,R.layout.grid_item_layout,
                new String[]{"image"},new int[]{R.id.grid_item_image});
        holder.gridView.setAdapter(simpleAdapter);
        holder.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(context,ShowImageActivity.class);
                intent.putExtra("id",position);
                intent.putExtra("image",image);
                context.startActivity(intent);
            }
        });
        return convertView;
    }
    class MyHolder{
        ImageView titleIV;
        TextView titleTV;
        MyGridView gridView;
    }
}
