package com.example.sarah.crunchtime;

import android.support.v4.view.ViewPager;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sarah on 2/5/2016.
 */
public class PageListener extends ViewPager.SimpleOnPageChangeListener {

//    ViewPager viewPager;
    ArrayList<Exercise> exerciseArrayList;
    TextView calorieText;

    public PageListener(ArrayList<Exercise> exerciseArrayList, TextView calorieText) {
//        this.viewPager = viewPager;
        this.exerciseArrayList = exerciseArrayList;
        this.calorieText = calorieText;
    }

    @Override
    public void onPageSelected(int position) {
        int numCalories = Integer.parseInt(calorieText.getText().toString());
        Exercise e = exerciseArrayList.get(position);
        String newBurned = Integer.toString(e.update(numCalories));
        TextView updatedView = e.getTextView();
        updatedView.setText(newBurned);
    }
}
