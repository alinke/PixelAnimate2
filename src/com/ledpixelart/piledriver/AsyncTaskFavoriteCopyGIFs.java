package com.ledpixelart.piledriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.io.OutputStream;

import com.ledpixelart.piledriver.MainActivity.AsyncTaskLoadFiles;

import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;

 public class AsyncTaskFavoriteCopyGIFs extends AsyncTask<Void, String, Void> {

    	  @Override
    	  protected void onPreExecute() {
    		  
    	  //ideally it would be nice to access the pre-packaged pixel art from assets directly and not have to copy to the sd card but wtih Android you can't access assets via file path, only inputstreeam. So this is why we're using the sd card, you can turn a file from an inputstream but this will take longer, save this for another day, we'll use the sd card for now
    		  
    	
    	   
    	   super.onPreExecute();
    	  }

    	  @Override
    	  protected Void doInBackground(Void... params) {
    	   
    		   	//let's first copy the original png
	        	InputStream in = null;
	            OutputStream out = null;
	            
	            File PNGPath = new File(MainActivity.originalImagePath); //sdcard/pixel/gifs/decoded/tree.rgb565
	        	if (PNGPath.exists()) { //if it doesn't exist
   	            try {
   	            	 
	     	             in = new FileInputStream(MainActivity.originalImagePath);
	     	             out = new FileOutputStream(MainActivity.FavGIFPath + MainActivity.filename_no_extension + ".png");
	     	             MainActivity.copyFile(in, out);
	     	             in.close();
	     	             in = null;
	     	             out.flush();
	     	             out.close();
	     	             out = null;  
	     	              
	     	              //no need to register these with mediascanner as these are internal gifs , the workaround for the gifs with a black frame as the first frame
   	           
	     	            } catch(Exception e) {
	     	                Log.e("copy ERROR", e.toString());
	     	                e.printStackTrace();
	     	            }  
   	            
   	           
   	           
	        	} 
        
            
	            File RGB565path = new File(MainActivity.gifPath_ + "decoded/" + MainActivity.filename_no_extension + ".rgb565"); //sdcard/pixel/gifs/decoded/tree.rgb565
	        	if (RGB565path.exists()) { //if it doesn't exist
	             //now let's get the rgb565
   	             try {
	     	             in = new FileInputStream(MainActivity.gifPath_ + "decoded/" + MainActivity.filename_no_extension + ".rgb565");
	     	             out = new FileOutputStream(MainActivity.FavGIFPath + "decoded/" + MainActivity.filename_no_extension + ".rgb565");
	     	             MainActivity.copyFile(in, out);
	     	             in.close();
	     	             in = null;
	     	             out.flush();
	     	             out.close();
	     	             out = null;  
	     	              
	     	              //no need to register these with mediascanner as these are internal gifs , the workaround for the gifs with a black frame as the first frame
   	           
	     	            } catch(Exception e) {
	     	                Log.e("copy ERROR", e.toString());
	     	                e.printStackTrace();
	     	            }  
   	            RGB565path.delete();
				}
	             
	            //now let's get the txt
	            File TXTpath = new File(MainActivity.gifPath_ + "decoded/" + MainActivity.filename_no_extension + ".txt"); //sdcard/pixel/gifs/decoded/tree.rgb565
	        	if (TXTpath.exists()) { //if it doesn't exist
   	             try {
	     	             in = new FileInputStream(MainActivity.gifPath_ + "decoded/" + MainActivity.filename_no_extension + ".txt");
	     	             out = new FileOutputStream(MainActivity.FavGIFPath + "decoded/" + MainActivity.filename_no_extension + ".txt");
	     	             MainActivity.copyFile(in, out);
	     	             in.close();
	     	             in = null;
	     	             out.flush();
	     	             out.close();
	     	             out = null;  
	     	              
	     	              //no need to register these with mediascanner as these are internal gifs , the workaround for the gifs with a black frame as the first frame
   	           
	     	            } catch(Exception e) {
	     	                Log.e("copy ERROR", e.toString());
	     	                e.printStackTrace();
	     	            } 
   	            TXTpath.delete();
	        	}
	        	
	        	//lastly we need to copy over the originanl GIF
	        	 File originalGIF = new File(MainActivity.gifPath_ + "gifsource/" + MainActivity.filename_no_extension + ".gif"); 
		        	if (originalGIF.exists()) { //if it doesn't exist
	     	             try {
		     	             in = new FileInputStream(MainActivity.gifPath_ + "gifsource/" + MainActivity.filename_no_extension + ".gif");
		     	             out = new FileOutputStream(MainActivity.FavGIFPath + "gifsource/" + MainActivity.filename_no_extension + ".gif");
		     	             MainActivity.copyFile(in, out);
		     	             in.close();
		     	             in = null;
		     	             out.flush();
		     	             out.close();
		     	             out = null;  
		     	              
		     	              //no need to register these with mediascanner as these are internal gifs , the workaround for the gifs with a black frame as the first frame
	     	           
		     	            } catch(Exception e) {
		     	                Log.e("copy ERROR", e.toString());
		     	                e.printStackTrace();
		     	            } 
	     	             
	     	            originalGIF.delete();
	     	             
		        	}
      	
      		
      	//now we need to delete the old ones from the griview
	    //and add the new one to the top
    		  
      
	
	   	  
   return null;
   
  }	  

    	  @Override
    	  protected void onProgressUpdate(String... values) {
    	   //myTaskAdapter.add(values[0]);  //this is where we add the image to the gridview
    	   super.onProgressUpdate(values);
    	  }

    	  @Override
    	  protected void onPostExecute(Void result) {
    		  
    		  MainActivity.myTaskAdapter.remove(MainActivity.gridViewPosition); //remove the old one
    		  MainActivity.myTaskAdapter.add(MainActivity.FavGIFPath + MainActivity.filename_no_extension + ".png"); 
    		  MainActivity.myTaskAdapter.notifyDataSetChanged();
    		  //MainActivity.myTaskAdapter.clear();
    		  
    		 // MainActivity.myTaskAdapter.//
    		  
    		 // x.new(MainAcitivty();
    		  
    		  //MainActivity myActivity = new MainActivity();
    		  //MainActivity.parseYouTubeAndYahoo asyncTask = myActivity.new parseYouTubeAndYahoo();
    		  
    		  //MainActivity.myAsyncTaskLoadFiles = new MainActivity.AsyncTaskLoadFiles(myActivity.myImageAdapter);
    		  //MainActivity.myAsyncTaskLoadFiles.execute();
    		  
    		  //new MainActivity.myAsyncTaskLoadFiles.execute();
    		  
    		  MainActivity.PNGPathFile.delete();
    		  
    		  
    		  
    	  // myTaskAdapter.notifyDataSetChanged();
    	   super.onPostExecute(result);
    	  }

    	 }