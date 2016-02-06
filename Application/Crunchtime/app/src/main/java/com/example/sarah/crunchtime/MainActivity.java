package com.example.sarah.crunchtime;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    CustomSlideAdapter adapter;
    ArrayList<Exercise> exerciseArrayList;
    PageListener pageListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent intent = getIntent();
        String message = intent.getStringExtra(StartActivity.EXTRA_MESSAGE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] imageResources = {R.drawable.pushup, R.drawable.situp, R.drawable.squats, R.drawable.leglift, R.drawable.plank, R.drawable.jumpingjacks, R.drawable.pullup, R.drawable.cycling, R.drawable.walking, R.drawable.jogging, R.drawable.swimming, R.drawable.climbing};
        String[] exerciseTypes = {"reps", "reps", "reps", "min", "min","min", "reps", "min", "min", "min", "min", "min"};
        String[] exerciseNames = {"Pushups", "Situps", "Squats", "Leg-lift", "Plank", "Jumping Jacks", "Pullups", "Cycling", "Walking", "Jogging", "Swimming", "Stair-climbing"};
        double[] num = {350, 200, 225, 25, 25, 10, 100, 12, 20, 12, 13, 15};
        int weight = Integer.parseInt(message);

        exerciseArrayList = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            exerciseArrayList.add(new Exercise(imageResources[i], num[i], exerciseTypes[i], exerciseNames[i], weight));
        }

        Button prev = (Button) findViewById(R.id.prev);
        prev.setVisibility(View.INVISIBLE);
        Button next = (Button) findViewById(R.id.next);

        viewPager = (ViewPager)findViewById(R.id.view_pager);
        adapter = new CustomSlideAdapter(this, exerciseArrayList);
        viewPager.setAdapter(adapter);

        TextView calorieText = (TextView) findViewById(R.id.numCalories);
        pageListener = new PageListener(exerciseArrayList, calorieText, prev, next);
        viewPager.addOnPageChangeListener(pageListener);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onBurnButtonClicked(View view) {
        Exercise currentExercise = exerciseArrayList.get(viewPager.getCurrentItem());
        TextView calorieText = (TextView) findViewById(R.id.numCalories);
        EditText numExercise = (EditText)currentExercise.getTextView();
        String num = numExercise.getText().toString();
        if (num.matches("")) {
            calorieText.setText("0");
        } else {
            String burned;
            double burnedCalories = currentExercise.convert(Double.parseDouble(num));
            if (burnedCalories % 1 == 0) {
                burned = String.valueOf((int)burnedCalories);
            } else {
                burned = String.valueOf(burnedCalories);
            }
            calorieText.setText(burned);
        }
    }

    public void onConvertButtonClicked(View view) {
        Exercise currentExercise = exerciseArrayList.get(viewPager.getCurrentItem());
        EditText calorieText = (EditText) findViewById(R.id.numCalories);
        String numCalories = calorieText.getText().toString();
        TextView numExercise = currentExercise.getTextView();
        if (numCalories.matches("")) {
            numExercise.setText("0");
        } else {
            double calories = Double.parseDouble(numCalories);
            int amount = currentExercise.update(calories);
            String num = String.valueOf(amount);
            numExercise.setText(num);
        }

    }

}
