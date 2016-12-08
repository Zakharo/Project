package com.example.vladzakharo.project;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private EditText mTitle;
    private EditText mMessage;
    private Spinner mSpinner;
    private CheckBox mCheckBox;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTitle = (EditText) findViewById(R.id.edit_text_title);
        mMessage = (EditText) findViewById(R.id.edit_text_message);
        mSpinner = (Spinner) findViewById(R.id.spinner);
        mCheckBox = (CheckBox) findViewById(R.id.checkBox);
        mButton = (Button) findViewById(R.id.button_send);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTitle.length() == 0 || mMessage.length() == 0){
                    Snackbar.make(findViewById(R.id.activity_main), R.string.snackbar_warning, Snackbar.LENGTH_SHORT).show();
                }
            }
        });
    }

}
