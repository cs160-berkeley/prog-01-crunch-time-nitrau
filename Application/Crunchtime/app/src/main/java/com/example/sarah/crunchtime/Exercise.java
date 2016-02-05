package com.example.sarah.crunchtime;

import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Sarah on 2/4/2016.
 */
public class Exercise {

    private int image;
    private int conversion;
    private String exerciseType;
    private TextView textView;

    public Exercise(int image, int conversion, String exerciseType) {
        this.image = image;
        this.conversion = conversion;
        this.exerciseType = exerciseType;
    }

    public TextView getTextView() {
        return textView;
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }

    public int convert(int number) {
        return number / this.conversion * 100;
    }

    public int getImage() {
        return image;
    }

    public String getExerciseType() {
        return exerciseType;
    }

    public int update(int number) {
        int doNumber = number / 100 * conversion;
        return doNumber;
//        System.out.println(doNumber);
//        textView.setText(Integer.toString(doNumber));
    }
}
