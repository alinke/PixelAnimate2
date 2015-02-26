package com.ledpixelart.piledriver;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

//import android.util.LruCache;
//import android.widget.GridLayout.LayoutParams;

import android.support.v4.util.LruCache;
import android.support.v4.view.ViewPager.LayoutParams;
import android.support.v7.appcompat.*;


@SuppressLint("NewApi")
public class ListAdapter extends BaseAdapter {

	Context context;
	ArrayList<String> items;
	private LruCache<String, Bitmap> mMemoryCache;
	
	//private Context mContext;
  	
	 /*public ImageAdapter2(Context c) {
	   mContext = c;
	  }*/

	public ListAdapter(Context context, ArrayList<String> items) {
		this.context = context;
		//mContext = context;
		this.items = items;
		
		

		// Get memory class of this device, exceeding this amount will throw an
		// OutOfMemory exception.
		final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);

		// Use 1/8th of the available memory for this memory cache.
		final int cacheSize = maxMemory / 8;

		mMemoryCache = new LruCache<String, Bitmap>(cacheSize) {

			protected int sizeOf(String key, Bitmap bitmap) {
				// The cache size will be measured in bytes rather than number
				// of items.
				return bitmap.getRowBytes() * bitmap.getHeight(); //changed this because getByteCount is only in API12 and above but according to http://stackoverflow.com/questions/12581322/android-bitmap-getbytecount-in-api-lesser-than-12 is the same
				//return bitmap.getByteCount();
			}

		};
	}

	@Override
	public int getCount() {
		return items.size();
	}

	@Override
	public Object getItem(int arg0) {
		return items.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int arg0, View convertView, ViewGroup arg2) {
		ImageView img = null;

		if (convertView == null) {
			img = new ImageView(context);
			img.setScaleType(ImageView.ScaleType.CENTER_CROP);
			img.setLayoutParams(new GridView.LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
			
			// imageView = new ImageView(mContext);
			
			if (MainActivity.targetScreenResolution < 481) { //the small screen can't take the larger icons
				img.setLayoutParams(new GridView.LayoutParams(128/MainActivity.gridScale,128/MainActivity.gridScale)); 
			}
			else {
				img.setLayoutParams(new GridView.LayoutParams(256/MainActivity.gridScale,256/MainActivity.gridScale)); //256,256
			}
			
	    	   // img.setLayoutParams(new GridView.LayoutParams(128,128)); //this used to be 256, 256 which explains why the grids were too small for the 128 sizes images
	    	img.setScaleType(ImageView.ScaleType.CENTER_CROP);
	    	img.setPadding(1, 1, 1, 1);
			
			
		} else {
			img = (ImageView) convertView;
		}

		int resId = context.getResources().getIdentifier(items.get(arg0),  //  res/drawable/gifname
				"drawable", context.getPackageName());
		
		String imagePath = items.get(arg0); //string path of the images

		//loadBitmap(resID, img);
		loadBitmap(imagePath, img);

		return img;
	}

	/*public void loadBitmap(int resId, ImageView imageView) {  //resId is the path in drawables
	
		if (cancelPotentialWork(resID, imageView)) {
			final BitmapWorkerTask task = new BitmapWorkerTask(imageView);
			imageView.setBackgroundResource(R.drawable.empty_photo);
			task.execute(resID);
		}
	}*/
	
	
		public void loadBitmap(String imathPath, ImageView imageView) {
			if (cancelPotentialWork(imathPath, imageView)) {
				final BitmapWorkerTask task = new BitmapWorkerTask(imageView);
				imageView.setBackgroundResource(R.drawable.empty_photo);
				task.execute(imathPath);
			}
		}

	static class AsyncDrawable extends BitmapDrawable {
		private final WeakReference<BitmapWorkerTask> bitmapWorkerTaskReference;

		public AsyncDrawable(Resources res, Bitmap bitmap,
				BitmapWorkerTask bitmapWorkerTask) {
			super(res, bitmap);
			bitmapWorkerTaskReference = new WeakReference<BitmapWorkerTask>(
					bitmapWorkerTask);
		}

		public BitmapWorkerTask getBitmapWorkerTask() {
			return bitmapWorkerTaskReference.get();
		}
	}

	/*public static boolean cancelPotentialWork(int data, ImageView imageView) {
	
		final BitmapWorkerTask bitmapWorkerTask = getBitmapWorkerTask(imageView);

		if (bitmapWorkerTask != null) {
			final int bitmapData = bitmapWorkerTask.data;
			if (bitmapData != data) {
				// Cancel previous task
				bitmapWorkerTask.cancel(true);
			} else {
				// The same work is already in progress
				return false;
			}
		}
		// No task associated with the ImageView, or an existing task was
		// cancelled
		return true;
	}
	*/
	public static boolean cancelPotentialWork(String data, ImageView imageView) { //data is the imagepath string, it was the resid
		
		final BitmapWorkerTask bitmapWorkerTask = getBitmapWorkerTask(imageView);

		if (bitmapWorkerTask != null) {
			final String bitmapData = bitmapWorkerTask.data;
			if (bitmapData != data) {
				// Cancel previous task
				bitmapWorkerTask.cancel(true);
			} else {
				// The same work is already in progress
				return false;
			}
		}
		// No task associated with the ImageView, or an existing task was
		// cancelled
		return true;
	}

	private static BitmapWorkerTask getBitmapWorkerTask(ImageView imageView) {
		if (imageView != null) {
			final Drawable drawable = imageView.getDrawable();
			if (drawable instanceof AsyncDrawable) {
				final AsyncDrawable asyncDrawable = (AsyncDrawable) drawable;
				return asyncDrawable.getBitmapWorkerTask();
			}
		}
		return null;
	}

	public void addBitmapToMemoryCache(String key, Bitmap bitmap) {
		if (getBitmapFromMemCache(key) == null) {
			mMemoryCache.put(key, bitmap);
		}
	}

	public Bitmap getBitmapFromMemCache(String key) {
		return (Bitmap) mMemoryCache.get(key);
	}

	/*class BitmapWorkerTask extends AsyncTask<Integer, Void, Bitmap> {
		public int data = 0;
		private final WeakReference<ImageView> imageViewReference;

		public BitmapWorkerTask(ImageView imageView) {
			// Use a WeakReference to ensure the ImageView can be garbage
			// collected
			imageViewReference = new WeakReference<ImageView>(imageView);
		}*/
		
	class BitmapWorkerTask extends AsyncTask<String, Void, Bitmap> {
		public String data = null;
		private final WeakReference<ImageView> imageViewReference;

		public BitmapWorkerTask(ImageView imageView) {
			// Use a WeakReference to ensure the ImageView can be garbage
			// collected
			imageViewReference = new WeakReference<ImageView>(imageView);
		}

		/*// Decode image in background.
		@Override
		protected Bitmap doInBackground(Integer... params) {
			data = params[0];
			final Bitmap bitmap = decodeSampledBitmapFromResource(
					context.getResources(), data, 128, 128);
			addBitmapToMemoryCache(String.valueOf(params[0]), bitmap);
			return bitmap;
		}*/
		
		//try adding statement here to change 128 to something smaller is the screen size is smaller
		
		protected Bitmap doInBackground(String... params) {
				data = params[0];
				
				final Bitmap bitmap;
				
				if (MainActivity.targetScreenResolution < 481) { //the small screen can't take the larger icons
					bitmap = decodeSampledBitmapFromUri(
							data, 128/MainActivity.gridScale,128/MainActivity.gridScale);
				}
				else {
					bitmap = decodeSampledBitmapFromUri( //but use the larger icons for the bigger screen
							data, 256/MainActivity.gridScale,256/MainActivity.gridScale); //256, 256
				}
				addBitmapToMemoryCache(params[0], bitmap); //params is the key
				return bitmap;
			}
			
			public Bitmap decodeSampledBitmapFromUri(String imagePath, int reqWidth,
		    	    int reqHeight) {

		    	   Bitmap bm = null;
		    	   // First decode with inJustDecodeBounds=true to check dimensions
		    	   final BitmapFactory.Options options = new BitmapFactory.Options();
		    	   options.inJustDecodeBounds = true;
		    	   BitmapFactory.decodeFile(imagePath, options);

		    	   // Calculate inSampleSize
		    	   options.inSampleSize = calculateInSampleSize(options, reqWidth,
		    	     reqHeight);

		    	   // Decode bitmap with inSampleSize set
		    	   options.inJustDecodeBounds = false;
		    	   bm = BitmapFactory.decodeFile(imagePath, options);
		    	   
		    	 
	    	   return bm;
	    	  }
				
	/*	// Decode image in background.
		@Override
		protected Bitmap doInBackground(Integer... params) {
			data = params[0];
			final Bitmap bitmap = decodeSampledBitmapFromResource(
					context.getResources(), data, 128, 128);
			addBitmapToMemoryCache(String.valueOf(params[0]), bitmap);
			return bitmap;
		}		
		*/

		// Once complete, see if ImageView is still around and set bitmap.
		@Override
		protected void onPostExecute(Bitmap bitmap) {
			if (imageViewReference != null && bitmap != null) {
				final ImageView imageView = imageViewReference.get();
				if (imageView != null) {
					imageView.setImageBitmap(bitmap);
				}
			}
		}

	

	/*public static Bitmap decodeSampledBitmapFromResource(Resources res,
			int resId, int reqWidth, int reqHeight) {

		// First decode with inJustDecodeBounds=true to check dimensions
		final BitmapFactory.Options options = new BitmapFactory.Options();
		options.inJustDecodeBounds = true;
		BitmapFactory.decodeResource(res, resId, options);

		// Calculate inSampleSize
		options.inSampleSize = calculateInSampleSize(options, reqWidth,
				reqHeight);

		// Decode bitmap with inSampleSize set
		options.inJustDecodeBounds = false;
		return BitmapFactory.decodeResource(res, resId, options);
	}*/
	
	  

	public int calculateInSampleSize(BitmapFactory.Options options,
			int reqWidth, int reqHeight) {
		// Raw height and width of image
		final int height = options.outHeight;
		final int width = options.outWidth;
		int inSampleSize = 1;

		if (height > reqHeight || width > reqWidth) {

			// Calculate ratios of height and width to requested height and
			// width
			final int heightRatio = Math.round((float) height
					/ (float) reqHeight);
			final int widthRatio = Math.round((float) width / (float) reqWidth);

			// Choose the smallest ratio as inSampleSize value, this will
			// guarantee
			// a final image with both dimensions larger than or equal to the
			// requested height and width.
			inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
		}

		return inSampleSize;
	}

}
}
