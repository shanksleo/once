package com.example.shanks.list;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.shanks.database.Diary;
import com.example.shanks.once.R;
import com.example.shanks.util.SimpleBaseAdapter;

import java.util.List;

/**
 * Created by shanks on 14/12/30.
 */
public class ListAdapter extends SimpleBaseAdapter<Diary> {
    public ListAdapter(Context context, List<Diary> data) {
        super(context, data);
    }



    @Override
    public int getItemResource() {
        return R.layout.list_item_single;
    }

    @Override
    public View getItemView(int position, View convertView, ViewHolder viewHolder) {
        TextView textView = viewHolder.getView(R.id.list_sigle_text);
        textView.setText(((Diary)getItem(position)).getArticle());

        return convertView;
    }
}
