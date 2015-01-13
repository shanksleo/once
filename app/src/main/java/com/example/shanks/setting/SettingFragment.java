package com.example.shanks.setting;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.example.shanks.once.R;

/**
 * Created by shanks on 15/1/12.
 */
public class SettingFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.perference_setting);
    }
}
