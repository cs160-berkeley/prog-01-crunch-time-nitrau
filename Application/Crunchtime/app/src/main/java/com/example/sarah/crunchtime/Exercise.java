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
    private String exerciseName;
    private TextView textView;

    public Exercise(int image, int conversion, String exerciseType, String exerciseName) {
        this.image = image;
        this.conversion = conversion;
        this.exerciseName = exerciseName;
        this.exerciseType = exerciseType;
    }

    public TextView getTextView() {
        return textView;
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }

    public int convert(int number) {
        return number * 100 / this.conversion;
    }

    public int getImage() {
        return image;
    }

    public String getExerciseType() {
        return exerciseType;
    }

    public int update(int number) {
        int doNumber = number * conversion / 100;
        return doNumber;
    }

    public String getExerciseName() {
        return exerciseName;
    }
}
