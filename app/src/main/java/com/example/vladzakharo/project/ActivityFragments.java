package com.example.vladzakharo.project;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class ActivityFragments extends AppCompatActivity {

    FragmentManager fm;

    private String mTitle;
    private String mMessage;
    private boolean isCheck;

    private Fruit fruit;

    Fragment fragmentOne;
    Fragment fragmentTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments);

        if(getIntent() != null){
            mTitle = getIntent().getStringExtra(MainActivity.TITLE);
            mMessage = getIntent().getStringExtra(MainActivity.MESSAGE);
            isCheck = getIntent().getExtras().getBoolean(MainActivity.CHECK);
            fruit = (Fruit)getIntent().getSerializableExtra(MainActivity.FRUIT);
            getSupportActionBar().setTitle(mTitle);
        }

        fm = getSupportFragmentManager();
        fragmentOne = fm.findFragmentById(R.id.fragmentF1);
        fragmentTwo = fm.findFragmentById(R.id.fragmentF2);

        if (isCheck){
            firstFragmentDown();
        }else{
            firstFragmentUp();
        }

    }

    private void firstFragmentDown(){
        fm.beginTransaction()
                .replace(R.id.fragmentF1, FragmentTwo.newInstance(fruit.getNameResId(), fruit.getDrawableResId()))
                .commit();
        fm.beginTransaction()
                .replace(R.id.fragmentF2, FragmentOne.newInstance(mMessage))
                .commit();
    }

    private void firstFragmentUp() {
        fm.beginTransaction()
                .replace(R.id.fragmentF1, FragmentOne.newInstance(mMessage))
                .commit();
        fm.beginTransaction()
                .replace(R.id.fragmentF2, FragmentTwo.newInstance(fruit.getNameResId(), fruit.getDrawableResId()))
                .commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            setResult(RESULT_OK);
            finish();
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        setResult(RESULT_CANCELED);
        finish();
    }
}
