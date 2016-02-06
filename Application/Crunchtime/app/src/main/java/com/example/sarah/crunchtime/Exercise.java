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
    private double factor;

    public Exercise(int image, double conversion, String exerciseType, String exerciseName, double weight) {
        this.image = image;
        this.conversion = conversion;
        this.exerciseName = exerciseName;
        this.exerciseType = exerciseType;
        this.factor = weight / 150;
    }

    public TextView getTextView() {
        return textView;
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }

    public double convert(double number) {
        double burned = factor * number * 100 / this.conversion;
        return Math.floor(burned * 10) / 10;
    }

    public int getImage() {
        return image;
    }

    public String getExerciseType() {
        return exerciseType;
    }

    public int update(double number) {
        double doNumber = number * conversion / 100 / factor;
        return (int)Math.ceil(doNumber);
    }

    public String getExerciseName() {
        return exerciseName;
    }
}
