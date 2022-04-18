package com.example.benkol;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class OnBoarding extends AppCompatActivity {

    public static final int max = 3;

    public String[] judul_array ={"Selamat Datang di Benkol !",
            "Temukan Bengkel didekatmu",
            "Montir akan segera datang Hello world!"};

    public String[] deskripsi_array = {
            "Aplikasi yang bikin perawatan atau service kendaraan kamu lebih mudah, siap melayani kamu dimanapun dan kapanpun"
            , "Temukan bengkel terdekat dari lokasi kamu sekarang"
            , "Montir akan datang ke lokasi kamu untuk memeriksa dan memperbaiki kendaraan kamu"
    };

    public  int[] gambar_array = {
            R.drawable.gambar3
            ,R.drawable.gambar2
            ,R.drawable.gambar1
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onboarding_activity);
        Komponen();
    }



    public class MyViewPagerAdapter extends PagerAdapter
    {
        public MyViewPagerAdapter() {
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position)
        {
            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = layoutInflater.inflate(R.layout.item_onboarding, container, false);
            ((TextView) view.findViewById(R.id.judul)).setText(judul_array[position]);
            ((TextView) view.findViewById(R.id.deskripsi)).setText(deskripsi_array[position]);
            ((ImageView) view.findViewById(R.id.gambar)).setImageResource(gambar_array[position]);
            container.addView(view);

            return view;

        }

        @Override
        public int getCount() {
            return judul_array.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }

    }


    public void Komponen()
    {
        ViewPager viewPager = findViewById(R.id.viewPager);





        MyViewPagerAdapter myViewPagerAdapter = new MyViewPagerAdapter();
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                progressDot(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager.setAdapter(myViewPagerAdapter);
        progressDot(0);


    }

    public void progressDot(int index)
    {
        LinearLayout dotsLayout = findViewById(R.id.layoutDots);
        ImageView[] dots = new ImageView[max];

        dotsLayout.removeAllViews();
        for (int i = 0;i<dots.length;i++)
        {
            dots[i] = new ImageView(this);
            int width_heigh =15;
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(width_heigh,width_heigh));
            params.setMargins(10,10,10,10);
            dots[i].setLayoutParams(params);
            dots[i].setImageResource(R.drawable.dot);
            dots[i].setColorFilter(getResources().getColor(R.color.teal_200), PorterDuff.Mode.SRC_IN);
            dotsLayout.addView(dots[i]);
        }

        dots[index].setImageResource(R.drawable.dot);
        dots[index].setColorFilter(getResources().getColor(R.color.biru), PorterDuff.Mode.SRC_IN);

    }
}