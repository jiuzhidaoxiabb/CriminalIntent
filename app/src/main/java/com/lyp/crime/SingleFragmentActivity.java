package com.lyp.crime;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import java.util.UUID;

/**
 * @author Lyp
 * @create 2019/4/23
 */
public abstract class SingleFragmentActivity extends AppCompatActivity {
    public static final String EXTRA_CRIME_ID = "crime_id";

    public static Intent newIntent(Context context, UUID crimeId){
        Intent intent = new Intent(context,CrimeActivity.class);
        intent.putExtra(EXTRA_CRIME_ID,crimeId);
        return intent;
    }

    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.frame_container);

        if (fragment == null) {
            fragment = createFragment();
            fm.beginTransaction().add(R.id.frame_container,fragment).commit();
        }
    }
}
