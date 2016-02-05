package com.example.sarah.crunchtime;

import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Sarah on 2/4/2016.
 */
public class Exercise {

    private int image;
    private double conversion;
    private String exerciseType;
    private String exerciseName;
    private TextView textView;

    public Exercise(int image, double conversion, String exerciseType, String exerciseName) {
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

    public double convert(double number) {
        return Math.floor(number * 100 / this.conversion * 10) / 10;
    }

    public int getImage() {
        return image;
    }

    public String getExerciseType() {
        return exerciseType;
    }

    public double update(double number) {
        double doNumber = Math.floor(number * conversion / 10) / 10;
        return doNumber;
    }

    public String getExerciseName() {
        return exerciseName;
    }
}
