package com.example.vladzakharo.project;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
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

    public static final String TITLE = "title";
    public static final String MESSAGE = "message";
    public static final String FRUIT = "fruit";
    public static final String CHECK = "check";

    private static final int REQUEST_CODE = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTitle = (EditText) findViewById(R.id.edit_text_title);
        mMessage = (EditText) findViewById(R.id.edit_text_message);
        mSpinner = (Spinner) findViewById(R.id.spinner);
        mCheckBox = (CheckBox) findViewById(R.id.checkBox);
        mButton = (Button) findViewById(R.id.button_send);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.fruit_array,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(adapter);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(mTitle.getText()) || TextUtils.isEmpty(mMessage.getText())){
                    Snackbar.make(findViewById(R.id.activity_main), R.string.snackbar_warning, Snackbar.LENGTH_SHORT).show();
                }else{
                    boolean isCheck = mCheckBox.isChecked();

                    Intent intent = new Intent(v.getContext(), ActivityFragments.class);
                    intent.putExtra(CHECK, isCheck);
                    intent.putExtra(TITLE, mTitle.getText().toString());
                    intent.putExtra(MESSAGE, mMessage.getText().toString());
                    intent.putExtra(FRUIT, Fruit.values()[mSpinner.getSelectedItemPosition()]);
                    startActivityForResult(intent, REQUEST_CODE);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE){
            if (resultCode == RESULT_CANCELED){
                mTitle.getText().clear();
                mMessage.getText().clear();
                mSpinner.setSelection(0);
                mCheckBox.setChecked(false);
            }
        }
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
