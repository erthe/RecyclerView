package com.example.nagaiakiranari.recycler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.app.FragmentTransaction;
import android.app.FragmentManager;

/**
 * Created by nagaiakiranari on 2016/10/13.
 */

public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        FragmentManager manager = getFragmentManager();
        RecyclerFragment fragment = new RecyclerFragment();

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add( R.id.recycler_fragment, fragment, "test" );
        transaction.commit();

    }
}