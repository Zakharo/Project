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

    private static final String ARG_NAME_RES_ID = "nri";
    private static final String ARG_DRAWABLE_RES_ID = "dri";

    private ImageView mFruitImageView;
    private TextView mFruit;

    private int mNameResId;
    private int mDrawableResId;

    public static FragmentTwo newInstance(int nameResId, int drawableResId){
        Bundle args = new Bundle();
        args.putInt(ARG_NAME_RES_ID, nameResId);
        args.putInt(ARG_DRAWABLE_RES_ID, drawableResId);

        FragmentTwo fragment = new FragmentTwo();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        mNameResId = getArguments().getInt(ARG_NAME_RES_ID);
        mDrawableResId = getArguments().getInt(ARG_DRAWABLE_RES_ID);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_two, container, false);
        mFruitImageView = (ImageView)v.findViewById(R.id.imageViewFruit);
        mFruit = (TextView)v.findViewById(R.id.textViewFruit);

        mFruit.setText(getString(mNameResId));
        mFruitImageView.setImageResource(mDrawableResId);
        return v;
    }
}
