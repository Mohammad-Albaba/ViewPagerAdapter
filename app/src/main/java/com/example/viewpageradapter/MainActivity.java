package com.example.viewpageradapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.pager);
        ImagesAdapter imagesAdapter = new ImagesAdapter(imagesIds);
        viewPager.setAdapter(imagesAdapter);
        int padding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100,getResources().getDisplayMetrics());
        viewPager.setPadding(padding ,0 ,padding ,0);
        viewPager.setClipToPadding(false);
        viewPager.setCurrentItem(4);


    }

    class ImagesAdapter extends PagerAdapter{
        int [] imagesIds;
      public ImagesAdapter(int [] imagesIds){
          this.imagesIds = imagesIds;
      }
        @Override
        public int getCount() {
            return imagesIds.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView = (ImageView) LayoutInflater.from(container.getContext()).inflate(R.layout.item_page , container , false);
        imageView.setImageResource(imagesIds[position]);
        container.addView(imageView);
          return imageView;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }
    }
}