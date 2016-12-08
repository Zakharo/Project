package com.example.vladzakharo.project;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ActivityFragments extends AppCompatActivity {

    FragmentOne mFragmentOne;
    FragmentTwo mFragmentTwo;
    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments);

        //mFragmentOne = new FragmentOne();
        //mFragmentTwo = new FragmentTwo();

        fm = getSupportFragmentManager();

        Fragment fragmentOne = fm.findFragmentById(R.id.fragmentF1);
        if(fragmentOne == null){
            fragmentOne = new FragmentOne();
            fm.beginTransaction()
                    .add(R.id.fragmentF1, fragmentOne)
                    .commit();
        }

        Fragment fragmentTwo = fm.findFragmentById(R.id.fragmentF2);
        if(fragmentTwo == null){
            fragmentTwo = new FragmentTwo();
            fm.beginTransaction()
                    .add(R.id.fragmentF2, fragmentTwo)
                    .commit();
        }
    }
}
