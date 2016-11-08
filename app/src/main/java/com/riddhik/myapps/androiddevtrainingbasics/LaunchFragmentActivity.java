package com.riddhik.myapps.androiddevtrainingbasics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LaunchFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_fragment);

        if (findViewById(R.id.fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            NewsFragment newsFragment = new NewsFragment();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, newsFragment)
                    .commit();
        }
    }
}
