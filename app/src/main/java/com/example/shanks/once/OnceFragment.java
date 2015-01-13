package com.example.shanks.once;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shanks.MainActivity;
import com.example.shanks.database.Diary;
import com.example.shanks.util.LinkFragment;
import com.example.shanks.util.MyApplication;

import java.util.Date;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by shanks on 14/12/27.
 */
public class OnceFragment extends Fragment implements View.OnClickListener {
    @InjectView(R.id.edit_list)
    EditText mEditList;
    @InjectView(R.id.sure)
    Button mSure;
    @InjectView(R.id.cancel)
    Button mCancel;
    private MainActivity mActivity;
    private  LinkFragment mCallBack;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
             mCallBack = (LinkFragment)activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString()

                    + " must implement OnHeadlineSelectedListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_once, container, false);
        ButterKnife.inject(this, view);
        mActivity = (MainActivity)getActivity();
        mSure.setOnClickListener(this);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.sure :
                    Editable article = mEditList.getText();
                    Diary diary = new Diary(new Date(), new Date(), "title", "comment", article.toString());
                    diary.save();

//                    点击后把消息传给宿主Activity
                mCallBack.onListChanged();


                Toast.makeText(MyApplication.getContext(),"bkc",Toast.LENGTH_LONG).show();
                break;
            case R.id.cancel:
                mEditList.setText("");
                break;
        }

    }
}
