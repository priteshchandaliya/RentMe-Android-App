package com.sjsu.priteshchandaliya.rentme;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by priteshchandaliya on 7/4/16.
 */
public class CustomSwipeAdapter extends PagerAdapter {

    private int[] image_resources = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5,
            R.drawable.image6,R.drawable.image7,R.drawable.image8,R.drawable.image9};

    private Context ctx;
    private LayoutInflater layoutInflater;

    public CustomSwipeAdapter(Context ctx){

        this.ctx= ctx;

    }

    public int getCount() {

        return image_resources.length;
    }

    public boolean isViewFromObject (View view, Object object)
    {
        return (view ==(LinearLayout)object);
    }
    public  Object instantiateItem(ViewGroup container, int position){

        layoutInflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View  item_view = layoutInflater.inflate(R.layout.swipelayout, container, false);

        //Toast.makeText(ctx,image_resources.length+"", Toast.LENGTH_LONG ).show();

        ImageView imageView = (ImageView) item_view.findViewById(R.id.image_view);
        imageView.setImageResource(image_resources [position]);
        container.addView(item_view);
        return item_view;
    }

    public void destroyItem(ViewGroup container, int position, Object object){
        container.removeView((LinearLayout) object);
    }
}

