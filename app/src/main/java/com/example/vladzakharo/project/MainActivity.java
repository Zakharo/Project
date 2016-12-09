package com.example.vladzakharo.project;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private EditText mTitle;
    private EditText mMessage;
    private Spinner mSpinner;
    private CheckBox mCheckBox;
    private Button mButton;

    private static final String TITLE = "title";
    private static final String MESSAGE = "message";
    private static final String FRUIT = "fruit";
    private static final String CHECK = "check";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTitle = (EditText) findViewById(R.id.edit_text_title);
        mMessage = (EditText) findViewById(R.id.edit_text_message);
        mSpinner = (Spinner) findViewById(R.id.spinner);
        mCheckBox = (CheckBox) findViewById(R.id.checkBox);
        mButton = (Button) findViewById(R.id.button_send);

        String spinnerValue = getIntent().getStringExtra("spinner");

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.fruit_array,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(adapter);

        boolean savedCheck = getIntent().getBooleanExtra("check", false);
        if (savedCheck){
            mCheckBox.setChecked(savedCheck);
        }
        mTitle.setText(getIntent().getStringExtra("title"));
        mMessage.setText(getIntent().getStringExtra("message"));
        int spinnerPosition = adapter.getPosition(spinnerValue);
        mSpinner.setSelection(spinnerPosition);


        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTitle.length() == 0 || mMessage.length() == 0){
                    Snackbar.make(findViewById(R.id.activity_main), R.string.snackbar_warning, Snackbar.LENGTH_SHORT).show();
                }else{
                    boolean isCheck = mCheckBox.isChecked();

                    Intent intent = new Intent(MainActivity.this, ActivityFragments.class);
                    intent.putExtra(CHECK, isCheck);
                    intent.putExtra(TITLE, mTitle.getText().toString());
                    intent.putExtra(MESSAGE, mMessage.getText().toString());
                    intent.putExtra(FRUIT, mSpinner.getSelectedItem().toString());
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_item_quit:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
