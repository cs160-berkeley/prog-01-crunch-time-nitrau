package com.example.sarah.crunchtime;

import android.content.Context;
import android.media.Image;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Sarah on 2/3/2016.
 */
public class CustomSlideAdapter extends PagerAdapter {

//    private int[] imageResources = {R.drawable.pushup, R.drawable.situp, R.drawable.squats, R.drawable.leglift, R.drawable.plank, R.drawable.jumpingjacks, R.drawable.pullup, R.drawable.cycling, R.drawable.walking, R.drawable.jogging, R.drawable.swimming, R.drawable.climbing};
//
//    private String[] exerciseTypes = {"reps", "reps", "reps", "min", "min","min", "reps", "min", "min", "min", "min", "min"};

    private Context ctx;
    private LayoutInflater layoutInflater;

    private ArrayList<Exercise> exerciseArrayList;

    public CustomSlideAdapter(Context ctx, ArrayList<Exercise> exerciseArrayList) {
        this.ctx = ctx;
        this.exerciseArrayList = exerciseArrayList;
    }

    @Override
    public int getCount() {
        return exerciseArrayList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = layoutInflater.inflate(R.layout.image_slider, container, false);
        ImageView imgView = (ImageView)itemView.findViewById(R.id.image_view);
        TextView typeView = (TextView)itemView.findViewById(R.id.exercise_type);
        TextView numView = (TextView)itemView.findViewById(R.id.calories_burned);
        imgView.setImageResource(exerciseArrayList.get(position).getImage());
        typeView.setText(exerciseArrayList.get(position).getExerciseType());
        exerciseArrayList.get(position).setTextView(numView);
        container.addView(itemView);
        return itemView;
//        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
//        super.destroyItem(container, position, object);
    }

    @Override
    public float getPageWidth(int position) {
//        return super.getPageWidth(position);
        return 1f;
    }

}
