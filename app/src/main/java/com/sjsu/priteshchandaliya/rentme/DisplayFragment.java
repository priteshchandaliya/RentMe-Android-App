package com.sjsu.priteshchandaliya.rentme;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class DisplayFragment extends AppCompatActivity {

    ViewPager viewpager;
    CustomSwipeAdapter adapter;

    public static String[] IMAGE_NAME = {"pritesh"};

    private ViewPager mViewPager;
    private ImageFragmentPagerAdapter imageFragmentPagerAdapter;

    public void setImageShown(String imageIndentifier){
        if (imageIndentifier == "A")
        {
            IMAGE_NAME = new String[] {"image1", "image2", "image3"};

        }
        else if(imageIndentifier == "B")
        {
            IMAGE_NAME = new String[] {"image4", "image5", "image6"};
        }
        else if (imageIndentifier == "C")
        {
            IMAGE_NAME = new String[] {"image7", "image8", "image9"};
        }

        /*Fragment frg = null;
        frg = getSupportFragmentManager().findFragmentByTag("imageView");
        final FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.detach(frg);
        ft.attach(frg);
        ft.commit();*/
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_fragment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mViewPager = (ViewPager) findViewById(R.id.slider_image);
        imageFragmentPagerAdapter = new ImageFragmentPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(imageFragmentPagerAdapter);

    }

    public static class ImageFragmentPagerAdapter extends FragmentPagerAdapter {
        public ImageFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return IMAGE_NAME.length;
        }

        @Override
        public Fragment getItem(int position) {
            return SwipeFragment.newInstance(position);
        }
    }

    public static class SwipeFragment extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View swipeView = inflater.inflate(R.layout.swipefragment, container, false);
            ImageView imageView = (ImageView) swipeView.findViewById(R.id.imageView);
            Bundle bundle = getArguments();
            int position = bundle.getInt("position");
            Log.d("position check:", position + "");
            String imageFileName = IMAGE_NAME[position];
            Log.d("position file name:", imageFileName);

            int imgResId = getResources().getIdentifier(imageFileName, "drawable", "com.sjsu.priteshchandaliya.rentme");
            Log.d("image resource id: ", imgResId + "");
            try {
                Picasso.with(getContext()).load(imgResId).into(imageView);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            return swipeView;
        }

        static SwipeFragment newInstance(int position) {
            SwipeFragment swipeFragment = new SwipeFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("position", position);
            swipeFragment.setArguments(bundle);
            return swipeFragment;
        }


    }
}


