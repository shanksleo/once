package com.example.shanks.util;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shanks on 14/12/24.
 */
public abstract class SimpleBaseAdapter<T> extends BaseAdapter {
    protected Context context;
    protected List<T> data;

    public SimpleBaseAdapter(Context context, List<T> data){
        this.context = context;
        this.data = data == null ? new ArrayList<T>() : new ArrayList<T>(data);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @SuppressWarnings("unchecked")
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder holder;
        if(null == convertView){
            convertView = View.inflate(context,getItemResource(),null);
            holder = new ViewHolder(convertView);
            //setTag Give this Tab an arbitrary object to hold for later use.
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }
        return getItemView(position,convertView,holder);
    }

    public class ViewHolder{
        private SparseArray<View> views = new SparseArray<View>();
//        被回收的
        private  View convertView;
        public ViewHolder(View convertView){
            this.convertView = convertView;
        }
        //限定类型
        public <T extends View> T getView(int resId){
            View v = views.get(resId);
            if (null == v){
                v = convertView.findViewById(resId);
                views.put(resId,v);
            }
            return (T)v;
        }
    }

    public abstract int getItemResource();

    public abstract View getItemView(int position,View convertView,ViewHolder viewHolder);


    public void addAll(List<T> elem){
        data.addAll(elem);
        notifyDataSetChanged();
    }

    public void remove(T elem){
        data.remove(elem);
        notifyDataSetChanged();
    }

    public void remove(int index){
        data.remove(index);
        notifyDataSetChanged();
    }

    public void removeAll(List<T> elem){
        data.clear();
        data.addAll(elem);
        notifyDataSetChanged();
    }
}
