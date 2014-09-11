package com.ledpixelart.piledriver;

import ioio.lib.api.exception.ConnectionLostException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import com.ledpixelart.piledriver.MainActivity.writePixelAsync;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.Toast;

//import com.ioiomint.ledalbum.MainActivity.writePixelAsync;


public class createSlideShowAsync extends AsyncTask<Void, Integer, Void>{
		 
	     int progress_status;
	     int slideshowPosition = 0;
	      
	     @Override
	  protected void onPreExecute() {
		   // update the UI immediately after the task is executed
		   super.onPreExecute();
		   showToast("Creating Slide Show");
	  }
	      
	  private void showToast(final String msg) {
	/*	  runOnUiThread(new Runnable() {
				@Override
				public void run() {
					Toast toast = Toast.makeText(createSlideShowAsync.this, msg, Toast.LENGTH_LONG);
	                toast.show();
				}
			});*/
			
		}

	@Override
	  protected Void doInBackground(Void... params) {
		  	
		  try {
			createSlideShow();
		} catch (ConnectionLostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
			//had to add this delay , otherwise especially on older phones, all the images don't load the first time
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	   return null;
	  }
	
	  
	  @Override
	  protected void onProgressUpdate(Integer... values) {
	   super.onProgressUpdate(values);
	   //progress.incrementProgressBy(1);
	 }
	   
	  @Override
	  protected void onPostExecute(Void result) {
	   super.onPostExecute(result);
	   //progress.dismiss(); //we're done so now hide the progress update box
	   //now let's put PIXEL in local playback mode
	   try {
		   
		MainActivity.matrix_.interactive();
		//matrix_.writeFile(imageDisplayDuration);
		MainActivity.matrix_.writeFile(MainActivity.fps);
		
		} catch (ConnectionLostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
		  // MainActivity.writePixelAsync loadApplication = new writePixelAsync();
		  // loadApplication.execute();
		}
//} //end async task
  
    
    private void createSlideShow() throws ConnectionLostException {
    	//we'll need to 
    	
    	// Get the data location of the image
       /* String[] projection = {MediaStore.Images.Media.DATA};
        
	       //will need to chagne this
        	cursor = managedQuery(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                projection, 
                MediaStore.Images.Media.DATA + " like ? ",
                new String[] {"%pngs%"},  
                null);*/
	       
    	
	    	File decodedFileDir = new File(MainActivity.decodedDirPath); //pixel/decoded  ,create it if not there
			if(decodedFileDir.exists() == false) {
				decodedFileDir.mkdirs();
			}
	        	
    		File decodedFile = new File(MainActivity.decodedDirPath + "/slideshow.rgb565"); //decoded/slideshow.rgb565 , if it's already there, then we need to delete
    		if(decodedFile.exists()) {
    			decodedFile.delete(); //delete the file as we're going to re-create it
    		}
    		
    		File decodedFileTxt = new File(MainActivity.decodedDirPath + "/slideshow.txt"); //pixel/decoded/slideshow.txt  ,delete it if there
			if(decodedFileTxt.exists()) {
				decodedFileTxt.delete(); //delete the file as we're going to re-create it
			}
			
			String filetag = String.valueOf(MainActivity.SlideShowArray.length) + "," + String.valueOf(MainActivity.imageDisplayDuration*1000) + "," + String.valueOf(MainActivity.currentResolution);  //our format is number of frames,delay 72,60,32 equals 72 frames, 60 ms time delay, 32 resolution   resolution is 16 for 16x32 or 32 for 32x32 led matrix, we need this in case the user changes the resolution in the app, then we'd need to catch this mismatch and re-decode
	        
	        String exStorageState = Environment.getExternalStorageState();
	     	if (Environment.MEDIA_MOUNTED.equals(exStorageState)){
	     		try {
	     			
	     		   File myFile = new File(MainActivity.decodedDirPath + "/" + "slideshow.txt");  //decoded/slideshow.txt					       
	     		   myFile.createNewFile();
		           FileOutputStream fOut = null;
				   fOut = new FileOutputStream(myFile);
		           OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
				   myOutWriter.append(filetag);
				   myOutWriter.close();
				   fOut.close();
	     			
	     		} catch (IOException e) {
	     			e.printStackTrace();
	     			//Toast.makeText(this, "Couldn't save", Toast.LENGTH_SHORT);
	     		}
	     	}	
		
    	
    		MainActivity.slideshowPosition = 0;
    		int i = 0;
	        
	        for (i = 0; i < MainActivity.SlideShowArray.length; i++) {
		        
		        //cursor.moveToPosition(slideshowPosition);
		        //columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA); //this is crashing things
		        //showToast("colum index: " + getString(columnIndex)); //this does not work for some reason and causes slideshow to not go
		        
	        	
	        	slideshowPosition++; //increment it so we can play the next one
		        
		        // Get image filename
		        //imagePath = cursor.getString(columnIndex);
	        	MainActivity.imagePath = MainActivity.SlideShowArray[slideshowPosition];
		        MainActivity.WriteImagetoMatrix();	        
		      
		        try {
					appendWrite(MainActivity.BitmapBytes, MainActivity.decodedDirPath + "/" + "slideshow" + ".rgb565");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
    }
    

	    public void appendWrite(byte[] data, String filename) throws IOException {
		 FileOutputStream fos = new FileOutputStream(filename, true);  //true means append, false is over-write
	     fos.write(data);
	     fos.close();
	}
    
    }