package com.lyp.crime;

import android.support.v4.app.Fragment;
/**
 * @author Lyp
 * @create 2019/4/23
 */
public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
