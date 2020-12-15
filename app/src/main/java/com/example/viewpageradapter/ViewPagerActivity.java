package com.example.viewpageradapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerTabStrip;
import androidx.viewpager.widget.ViewPager;


import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.Toast;

public class ViewPagerActivity extends AppCompatActivity implements OnPageClickListener {
    int [] imagesIds = new int[] {
            R.drawable.a1,
            R.drawable.a2,
            R.drawable.a3,
            R.drawable.a4,
            R.drawable.a5,
            R.drawable.a6,
            R.drawable.a7,
            R.drawable.a8
    };
    String [] imagesTitles = new String[]{
            "Flower 1",
            "Flower 2",
            "Flower 3",
            "Flower 4",
            "Flower 5",
            "Flower 6",
            "Flower 7",
            "Flower 8",
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        ViewPager viewPager = findViewById(R.id.pager);
        MyFragmentPagerAdapter myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager() , imagesIds);
        viewPager.setAdapter(myFragmentPagerAdapter);
        PagerTabStrip pagerTabStrip = findViewById(R.id.pager_titles);
        pagerTabStrip.setTextSize(TypedValue.COMPLEX_UNIT_DIP , 25);
        pagerTabStrip.setTextColor(Color.BLUE);
//        int space = getResources().getDisplayMetrics().widthPixels / 2 ;
//        pagerTabStrip.setTextSpacing(space);
        pagerTabStrip.setDrawFullUnderline(false);
        pagerTabStrip.setTabIndicatorColor(Color.RED);
    }

    @Override
    public void onPageClick(int index) {
        Toast.makeText(this, index + "Clicked!", Toast.LENGTH_SHORT).show();
    }


    // بستخدم الفراقمينت بيج أدابتر لمن يكون عندي عدد الفراقمينت محدود أما الفراقمينت استيت بيجير أدابتر لمن يكون عندي عدد غير محدود مثلا أكون جايب صور من لداتا بيس
    class MyFragmentPagerAdapter extends FragmentStatePagerAdapter {
        int[] imagesIds;
        public MyFragmentPagerAdapter(@NonNull FragmentManager fm , int[] imagesIds) {
            super(fm);
            this.imagesIds = imagesIds;
            System.out.println("m");
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position){
                    case 0 :
                    return ImageFragment_0.newInstance(position , imagesIds[position]);
                    case 1:
                    return ImageFragment_1.newInstance(position , imagesIds[position]);
                    case 2 :
                    return ImageFragment_2.newInstance(position , imagesIds[position]);
                    case 3 :
                    return ImageFragment_3.newInstance(position , imagesIds[position]);
                    case 4 :
                    return ImageFragment_4.newInstance(position , imagesIds[position]);
                    case 5:
                    return ImageFragment_5.newInstance(position , imagesIds[position]);
                    case 6 :
                    return ImageFragment_6.newInstance(position , imagesIds[position]);
                    case 7 :
                    return ImageFragment_7.newInstance(position , imagesIds[position]);

            }
            return ImageFragment_0.newInstance(position , imagesIds[position]);
        }

        @Override
        public int getCount() {
            return imagesIds.length;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return imagesTitles[position];
        }
    }
}