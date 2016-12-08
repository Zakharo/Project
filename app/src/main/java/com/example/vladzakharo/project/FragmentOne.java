package com.example.vladzakharo.project;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Vlad Zakharo on 08.12.2016.
 */

public class FragmentOne extends Fragment {

    private static final String ARG_MESSAGE = "arg_message";

    private String mTextOfMessage;

    private TextView mMessage;

    public static FragmentOne newInstance(String message){
        Bundle args = new Bundle();
        args.putString(ARG_MESSAGE, message);

        FragmentOne fragment = new FragmentOne();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        mTextOfMessage = getArguments().getString(ARG_MESSAGE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_one, container, false);
        mMessage = (TextView) v.findViewById(R.id.textViewMessage);
        mMessage.setText(mTextOfMessage);
        return v;
    }
}
