//this package not used right now, but it's for trying to make the scrolling faster

package com.ledpixelart.piledriver;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;

public class ImageLoaderHelper {
    private static String TAG = "ImageLoaderHelper.class";

    private ImageLoaderHelper(){

    }

    public static ImageLoader getImageLoader(Context context){
        try {
            if (ImageLoader.getInstance().isInited()) {
                return ImageLoader.getInstance();
            }
            DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                    .showStubImage(R.drawable.loading)
                    .showImageForEmptyUri(R.drawable.loading)
                    .showImageOnFail(R.drawable.loading).cacheInMemory()
                    .cacheOnDisc().bitmapConfig(Bitmap.Config.RGB_565)
                    .build();
            ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                    context)
                    .defaultDisplayImageOptions(defaultOptions).build();
            ImageLoader.getInstance().init(config);
            return ImageLoader.getInstance();
        } catch (Exception ex) {
            Log.e(TAG, "Error when get image loader instance: " + ex);
            return null;
        }
    }
}