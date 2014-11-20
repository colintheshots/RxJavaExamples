package com.colintheshots.rxjavaexamples;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * Created by colin.lee on 11/13/14.
 */
public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().addToBackStack(this.toString())
                .replace(R.id.activity_main, new RxDoubleBindingFragment(), this.toString())
                .commit();
    }
}
