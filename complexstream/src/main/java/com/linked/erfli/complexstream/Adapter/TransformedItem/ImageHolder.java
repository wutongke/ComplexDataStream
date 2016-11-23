package com.linked.erfli.complexstream.Adapter.TransformedItem;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.linked.complexstream.R;
import com.linked.complexstream.databinding.ImageItemBinding;
import com.linked.erfli.complexstream.Model.BaseItem;
import com.linked.erfli.complexstream.Model.HeaderImageCardItem;
import com.linked.erfli.complexstream.Model.HeaderImageItem;
import com.linked.erfli.complexstream.Model.HeaderTextImageViewItem;

import java.util.List;

/**
 * Created by erfli on 11/21/16.
 */

public class ImageHolder extends BaseHolder {
    ImageItemBinding imageItemBinding;

    @Override
    public void setup(View view) {
        super.setup(view);
        imageItemBinding = DataBindingUtil.bind(view);
    }

    @Override
    public void render(BaseItem baseItem) {
        super.render(baseItem);
        ArrayAdapter arrayAdapter = (ArrayAdapter) imageItemBinding.imageGrid.getAdapter();
        if (arrayAdapter == null) {
            arrayAdapter = new ImageAdapter(itemView.getContext(), 0);
        }
        List<String> images = null;
        if (baseItem instanceof HeaderImageCardItem) {
            images = ((HeaderImageCardItem) baseItem).getImages();
        } else if (baseItem instanceof HeaderImageItem) {
            images = ((HeaderImageItem) baseItem).getImages();
        } else if (baseItem instanceof HeaderTextImageViewItem) {
            images = ((HeaderTextImageViewItem) baseItem).getImages();
        }
        arrayAdapter.clear();
        arrayAdapter.addAll(images);
        imageItemBinding.imageGrid.setAdapter(arrayAdapter);
    }

    static class ImageAdapter extends ArrayAdapter<String> {

        public ImageAdapter(Context context, int resource) {
            super(context, resource);
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            String url = getItem(position);
            ImageView imageView = null;
            if (convertView == null) {
                imageView = new ImageView(getContext());
            } else {
                imageView = (ImageView) convertView;
            }
            imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            Glide.clear(imageView);
            Glide.with(imageView.getContext())
                    .load(url)
                    .placeholder(R.drawable.pictures)
                    .into(imageView);
            return imageView;
        }
    }
}
