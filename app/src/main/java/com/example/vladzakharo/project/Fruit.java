package com.example.vladzakharo.project;

/**
 * Created by Vlad Zakharo on 13.12.2016.
 */

public enum Fruit {
    APPLE (R.string.apple, R.drawable.apple),
    BANANA (R.string.banana, R.drawable.banana),
    PINEAPPLE (R.string.pineapple, R.drawable.pineapple),
    CHERRY (R.string.cherry, R.drawable.cherry),
    KIWI (R.string.kiwi, R.drawable.kiwi);

    private int mNameResId;
    private int mDrawableResId;

    Fruit(int nameResId, int drawableResId){
        this.mNameResId = nameResId;
        this.mDrawableResId = drawableResId;
    }

    public int getNameResId(){
        return mNameResId;
    }

    public int getDrawableResId(){
        return mDrawableResId;
    }
}
