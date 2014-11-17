package com.ledpixelart.piledriver;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

 public class ImageAdapter2 extends BaseAdapter {

    	  private Context mContext;
    	  ArrayList<String> itemList = new ArrayList<String>();
    	  
    	  
    	  

    	  public ImageAdapter2(Context c) {
    	   mContext = c;
    	  }

    	  void add(String path) {
    	   itemList.add(path);
    	  }
    	  
    	  void clear() {
    	   itemList.clear();
    	  }
    	  
    	  void remove(int index){
    	   itemList.remove(index);
    	  }

    	  @Override
    	  public int getCount() {
    	   return itemList.size();
    	  }

    	  @Override
    	  public Object getItem(int position) {
    	   // TODO Auto-generated method stub
    	   return itemList.get(position);
    	  }

    	  @Override
    	  public long getItemId(int position) {
    	   // TODO Auto-generated method stub
    	   return 0;
    	  }
    	  

    	  @Override
    	  public View getView(int position, View convertView, ViewGroup parent) {
    	   ImageView imageView;
    	   if (convertView == null) { // if it's not recycled, initialize some
    	          // attributes
    	    imageView = new ImageView(mContext);
    	    imageView.setLayoutParams(new GridView.LayoutParams(128,128));
    	    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    	    imageView.setPadding(4, 4, 4, 4);
    	   } else {
    	    imageView = (ImageView) convertView;
    	   }

    	   Bitmap bm = decodeSampledBitmapFromUri(itemList.get(position), 128,
    	     128);

    	   imageView.setImageBitmap(bm);
    	   
    	  // ImageView profileImgView = (ImageView) gridCell.findViewById(R.id.profileImg);
          // ImageLoaderHelper.getImageLoader(context).displayImage(getItem(position).getImageUrl(), profileImgView);

    	   
    	   
    	   return imageView;
    	  }

    	  public Bitmap decodeSampledBitmapFromUri(String path, int reqWidth,
    	    int reqHeight) {

    	   Bitmap bm = null;
    	   // First decode with inJustDecodeBounds=true to check dimensions
    	   final BitmapFactory.Options options = new BitmapFactory.Options();
    	   options.inJustDecodeBounds = true;
    	   BitmapFactory.decodeFile(path, options);

    	   // Calculate inSampleSize
    	   options.inSampleSize = calculateInSampleSize(options, reqWidth,
    	     reqHeight);

    	   // Decode bitmap with inSampleSize set
    	   options.inJustDecodeBounds = false;
    	   bm = BitmapFactory.decodeFile(path, options);
    	   
    	 
    	   return bm;
    	  }
    	  
    	  

    	  public int calculateInSampleSize(

    	  BitmapFactory.Options options, int reqWidth, int reqHeight) {
    	   // Raw height and width of image
    	   final int height = options.outHeight;
    	   final int width = options.outWidth;
    	   int inSampleSize = 1;

    	   if (height > reqHeight || width > reqWidth) {
    	    if (width > height) {
    	     inSampleSize = Math.round((float) height
    	       / (float) reqHeight);
    	    } else {
    	     inSampleSize = Math.round((float) width / (float) reqWidth);
    	    }
    	   }

    	   return inSampleSize;
    	  }

    	 }