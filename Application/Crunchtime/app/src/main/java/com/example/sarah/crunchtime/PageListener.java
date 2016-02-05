package com.example.sarah.crunchtime;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sarah on 2/5/2016.
 */
public class PageListener extends ViewPager.SimpleOnPageChangeListener {

    ArrayList<Exercise> exerciseArrayList;
    TextView calorieText;
    Button prev;
    Button next;

    public PageListener(ArrayList<Exercise> exerciseArrayList, TextView calorieText, Button prev, Button next) {
        this.exerciseArrayList = exerciseArrayList;
        this.calorieText = calorieText;
        this.prev = prev;
        this.next = next;
    }

    @Override
    public void onPageSelected(int position) {
        if (position == 0) {
            prev.setVisibility(View.INVISIBLE);
        } else if (position == exerciseArrayList.size() - 1) {
            next.setVisibility(View.INVISIBLE);
        } else {
            prev.setVisibility(View.VISIBLE);
            next.setVisibility(View.VISIBLE);
        }

        double numCalories = Double.parseDouble(calorieText.getText().toString());
        Exercise e = exerciseArrayList.get(position);
        double amount = e.update(numCalories);
        String newBurned;
        if (amount % 1 == 0) {
            newBurned = String.valueOf((int)amount);
        } else {
            newBurned = String.valueOf(e.update(numCalories));
        }
        TextView updatedView = e.getTextView();
        updatedView.setText(newBurned);
    }

}
