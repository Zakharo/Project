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

public class FragmentTwo extends Fragment {

    private static final String ARG_FRUIT = "arg_fruit";

    private ImageView mFruitImageView;
    private TextView mFruit;
    private String mTextOfFruit;

    public static FragmentTwo newInstance(String fruit){
        Bundle args = new Bundle();
        args.putString(ARG_FRUIT, fruit);

        FragmentTwo fragment = new FragmentTwo();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        mTextOfFruit = getArguments().getString(ARG_FRUIT);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_two, container, false);
        mFruitImageView = (ImageView)v.findViewById(R.id.imageViewFruit);
        mFruit = (TextView)v.findViewById(R.id.textViewFruit);
        mFruit.setText(mTextOfFruit);

        switch (mTextOfFruit){
            case "Apple":
                mFruitImageView.setImageResource(R.drawable.apple);
                break;
            case "Banana":
                mFruitImageView.setImageResource(R.drawable.banana);
                break;
            case "Pineapple":
                mFruitImageView.setImageResource(R.drawable.pineapple);
                break;
            case "Cherry":
                mFruitImageView.setImageResource(R.drawable.cherry);
                break;
            case "Kiwi":
                mFruitImageView.setImageResource(R.drawable.kiwi);
                break;
            case "Яблоко":
                mFruitImageView.setImageResource(R.drawable.apple);
                break;
            case "Банан":
                mFruitImageView.setImageResource(R.drawable.banana);
                break;
            case "Ананас":
                mFruitImageView.setImageResource(R.drawable.pineapple);
                break;
            case "Вишня":
                mFruitImageView.setImageResource(R.drawable.cherry);
                break;
            case "Киви":
                mFruitImageView.setImageResource(R.drawable.kiwi);
                break;
        }
        return v;
    }
}
