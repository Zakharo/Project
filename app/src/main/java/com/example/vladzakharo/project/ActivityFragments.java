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
    private String mFruit;
    private boolean isCheck;

    private static final String TITLE = "title";
    private static final String MESSAGE = "message";
    private static final String SPINNER = "spinner";
    private static final String CHECK = "check";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments);

        mTitle = getIntent().getStringExtra("title");
        mMessage = getIntent().getStringExtra("message");
        mFruit = getIntent().getStringExtra("fruit");
        isCheck = getIntent().getExtras().getBoolean("check");

        getSupportActionBar().setTitle(mTitle);

        if (isCheck){
            fm = getSupportFragmentManager();
            Fragment fragmentOne = fm.findFragmentById(R.id.fragmentF1);
            if(fragmentOne == null){
                fm.beginTransaction()
                        .add(R.id.fragmentF1, FragmentTwo.newInstance(mMessage))
                        .commit();
            }

            Fragment fragmentTwo = fm.findFragmentById(R.id.fragmentF2);
            if(fragmentTwo == null){
                fm.beginTransaction()
                        .add(R.id.fragmentF2, FragmentOne.newInstance(mFruit))
                        .commit();
            }
        }else{
            fm = getSupportFragmentManager();
            Fragment fragmentOne = fm.findFragmentById(R.id.fragmentF1);
            if(fragmentOne == null){
                fm.beginTransaction()
                        .add(R.id.fragmentF1, FragmentOne.newInstance(mMessage))
                        .commit();
            }

            Fragment fragmentTwo = fm.findFragmentById(R.id.fragmentF2);
            if(fragmentTwo == null){
                fm.beginTransaction()
                        .add(R.id.fragmentF2, FragmentTwo.newInstance(mFruit))
                        .commit();
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            Intent intent = new Intent(ActivityFragments.this, MainActivity.class);
            intent.putExtra(CHECK, isCheck);
            intent.putExtra(TITLE, mTitle);
            intent.putExtra(MESSAGE, mMessage);
            intent.putExtra(SPINNER, mFruit);
            startActivity(intent);
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ActivityFragments.this, MainActivity.class);
        startActivity(intent);
        super.onBackPressed();
    }
}
