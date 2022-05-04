package br.com.e_commerce_master_android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import br.com.e_commerce_master_android.R;

public class SliderImagemAdapter extends PagerAdapter {

    private int[] image_resources = {
            R.drawable.shoe,
            R.drawable.shoe1,
            R.drawable.shoe2,
            R.drawable.shoe3,
            R.drawable.shoe4,
            R.drawable.shoe5,
            R.drawable.shoe6,
            R.drawable.shoe7
    };
    private Context ctx;
    private LayoutInflater layoutInflater;

    public SliderImagemAdapter(Context ctx) {
        this.ctx = ctx;
    }
    @Override
    public int getCount() {
        return image_resources.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view == (LinearLayout) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View item_view = layoutInflater.inflate(R.layout.slider_imagem, container, false);
        ImageView imageView = (ImageView) item_view.findViewById(R.id.slider_imageView);
        imageView.setImageResource(image_resources[position]);
        container.addView(item_view);

        return item_view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);
        container.removeView((LinearLayout) object);
    }
}
