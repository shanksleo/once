package com.example.shanks.list;

import android.app.Activity;
import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.shanks.database.Diary;
import com.example.shanks.once.R;
import com.example.shanks.util.MyApplication;

import org.litepal.crud.DataSupport;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by shanks on 14/12/27.
 */
public class ListFragment extends Fragment {
    @InjectView(R.id.list_fragment)
    ListView mListFragment;

    public static final String UPDATE = "com.shanks.w3.action.MyBroadcastReceiver";
    private  ListAdapter mListAdapter = null;

    Activity mActivity;
//   使用 lambda表达式写内部类
    BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
    @Override
    public void onReceive(Context context, Intent intent) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mListAdapter.notifyDataSetChanged();
            }
        });


        Toast.makeText(MyApplication.getContext(),"bc",Toast.LENGTH_LONG).show();
    }
};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);
        ButterKnife.inject(this, view);
        mActivity = getActivity();
        List<Diary> list = DataSupport.findAll(Diary.class);
        mListAdapter = new ListAdapter(MyApplication.getContext(), list);
        mListFragment.setAdapter(mListAdapter);
        Log.d("tag","listonCreate");

        return view;

    }

    @Override
    public void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(UPDATE);
        mActivity.registerReceiver(mBroadcastReceiver,intentFilter);
    }

    @Override
    public void onResume() {
        super.onResume();
        mListAdapter.notifyDataSetChanged();
        mActivity.unregisterReceiver(mBroadcastReceiver);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);

    }
    public void upDateUI(){
       mListAdapter.notifyDataSetChanged();
    }
    public void runOnUiThread(Runnable runnable){
        mActivity.runOnUiThread(runnable);
    }
}
