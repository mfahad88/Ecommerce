package com.example.ecommerce.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;


import com.example.ecommerce.Model.NewArrivals;
import com.example.ecommerce.Model.Promotion;
import com.example.ecommerce.R;
import com.example.ecommerce.adapter.SlidingImage_Adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private int counterPage=0;
    private View root;
    private SlidingImage_Adapter adapter;
    private ViewPager mPager;
    private LinearLayout linear_horizontal_scroll_view;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);

        root = inflater.inflate(R.layout.fragment_home, container, false);
        mPager = root.findViewById(R.id.pager);
        linear_horizontal_scroll_view=root.findViewById(R.id.linear_horizontal_scroll_view);
        populateViewPager();
        scrollViewPager();
        newArrivals(root.getContext());
        return root;
    }

    private void populateViewPager(){
        List<Promotion> list=new ArrayList<>();
        Promotion promotion=new Promotion();
        promotion.setId(1);
        promotion.setImage(R.drawable.outerwear);
        promotion.setContent("Test Message1");
        list.add(promotion);

        promotion.setId(2);
        promotion.setImage(R.drawable.outerwear);
        promotion.setContent("Test Message2");
        list.add(promotion);

        promotion.setId(3);
        promotion.setImage(R.drawable.outerwear);
        promotion.setContent("Test Message3");
        list.add(promotion);

        promotion.setId(4);
        promotion.setImage(R.drawable.outerwear);
        promotion.setContent("Test Message4");
        list.add(promotion);

        promotion.setId(5);
        promotion.setImage(R.drawable.outerwear);
        promotion.setContent("Test Message5");
        list.add(promotion);

        adapter = new SlidingImage_Adapter(root.getContext(),list);
    }

    private void scrollViewPager(){
        mPager.setAdapter(adapter);
        Timer timer=new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(counterPage==mPager.getAdapter().getCount()){
                    counterPage=0;
                }
                mPager.post(new Runnable() {
                    @Override
                    public void run() {
                        mPager.setCurrentItem(counterPage++,true);
                    }
                });


            }
        },2000,2000);
    }

    private void newArrivals(Context context){
        List<NewArrivals> list=new ArrayList<>();
        list.add(new NewArrivals(1,R.drawable.outerwear,"Product1"));
        list.add(new NewArrivals(2,R.drawable.outerwear,"Product2"));
        list.add(new NewArrivals(3,R.drawable.outerwear,"Product3"));
        list.add(new NewArrivals(4,R.drawable.outerwear,"Product4"));
        list.add(new NewArrivals(5,R.drawable.outerwear,"Product5"));
        for(NewArrivals newArrivals:list) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(LinearLayout.VERTICAL);
            ImageView imageView=new ImageView(context);
            imageView.setImageDrawable(ContextCompat.getDrawable(context,newArrivals.getImage()));
            imageView.setLayoutParams(new ViewGroup.LayoutParams(450,450));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            linearLayout.addView(imageView);
            TextView textView=new TextView(context);
            textView.setText(newArrivals.getTitle());
            textView.setGravity(Gravity.CENTER);
            linearLayout.addView(textView);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            layoutParams.setMargins(18, 10, 18, 0);
            linear_horizontal_scroll_view.addView(linearLayout,layoutParams);
        }

    }
}