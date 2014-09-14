package com.ledpixelart.piledriver;

import ioio.lib.api.exception.ConnectionLostException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.ref.WeakReference;

import com.ledpixelart.piledriver.MainActivity.writePixelAsync;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.Toast;

//import com.ioiomint.ledalbum.MainActivity.writePixelAsync;


public class createSlideShowAsyncNotWorking extends AsyncTask<Void, Integer, Void>{
		 
	  private final WeakReference<MainActivity> mainActivityWeakRef;
	  int progress_status;
	  ProgressDialog progress;
	  private Context context;
      //Activity activity;
       

      public createSlideShowAsyncNotWorking(MainActivity mainActivity) {
          super();
          this.mainActivityWeakRef = new WeakReference<MainActivity>(mainActivity);
          //this.activity = mainActivity;
      } 
	
   /*   Log.d("onpostexecute", (mainActivityWeakRef.get() != null) + "");
      if (mainActivityWeakRef.get() != null && !mainActivityWeakRef.get().isFinishing()) {
           
          AlertDialog alertDialog = new AlertDialog.Builder(mainActivityWeakRef.get()).create();
          alertDialog.setTitle(result);
          alertDialog.setMessage("On post execute");
          alertDialog.setCancelable(false);
          alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                  new DialogInterface.OnClickListener() {
                      public void onClick(DialogInterface dialog,
                              int which) {
                          dialog.dismiss();
                      }
                  });

          alertDialog.show();
      }*/
	     
	    /* public createSlideShowAsync(Context cxt) {
	            context = cxt;
	            progress = new ProgressDialog(context);
	        }*/
	      
	     @Override
	  protected void onPreExecute() {
		   // update the UI immediately after the task is executed
		   super.onPreExecute();
		   //showToast("Creating Slide Show...");
		   System.out.println("Number of Images in Slide Show: " + MainActivity.SlideShowLength);
		   
		   if (mainActivityWeakRef.get() != null && !mainActivityWeakRef.get().isFinishing()) {
			//progress = new ProgressDialog(Context cxt);
				progress = new ProgressDialog(mainActivityWeakRef.get());
		        progress.setTitle("Creating Slide Show...");
		        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		        progress.setCancelable(false); //must have this as we don't want users cancel while it's writing
		        progress.setMax(MainActivity.SlideShowLength);
		        progress.show();
		   }
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
			
			/*//had to add this delay , otherwise especially on older phones, all the images don't load the first time
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} */
	   return null;
	  }
	
	  
	  @Override
	  protected void onProgressUpdate(Integer... values) {
	   super.onProgressUpdate(values);
	  // progress.incrementProgressBy(1);
	 }
	   
	  @Override
	  protected void onPostExecute(Void result) {
	   super.onPostExecute(result);
	  // progress.dismiss(); //we're done so now hide the progress update box
	   //now let's put PIXEL in local playback mode
	   try {
		   
		MainActivity.matrix_.playFile();
		
		} catch (ConnectionLostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
		  //MainActivity.writePixelAsync loadApplication = new writePixelAsync();
		  //loadApplication.execute();
		}
//} //end async task
  
    
    private void createSlideShow() throws ConnectionLostException {
    	
	    
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
    	
    		int i = 0;
	        
	        for (i = 0; i < MainActivity.SlideShowLength; i++) { 
	        	
	        	MainActivity.imagePath = MainActivity.SlideShowArray[i];
	        	
		        //add for loop here for the slide delay
	        	
	        	int y = 0;
	        	
	        	for (y = 0; y < MainActivity.imageDisplayDuration; y++) {
	        	
	        		MainActivity.WriteImagetoMatrix();	//we are streaming here, not writing
	        		
	        		/* imageDisplayDuration = Integer.valueOf(prefs.getString(   
	        		  	        resources.getString(R.string.pref_imageDisplayDuration),
	        		  	        resources.getString(R.string.imageDisplayDurationDefault)));   
	        		     
	        		     slideShowFPS = 1000.f / imageDisplayDuration*1000;     // fps = 1000/5000;
	        		 
	        		    
	        		     
	        		     pauseBetweenImagesDuration = Integer.valueOf(prefs.getString(   
	        		  	        resources.getString(R.string.pref_pauseBetweenImagesDuration),
	        		  	        resources.getString(R.string.pauseBetweenImagesDurationDefault)));  */
	        	
	        	}
		        //***********
		        
	        	progress_status++;
	        	
	        	publishProgress(progress_status);
		        
		        //need to have a loop within a loop here to have longer than 1 sec frame
		      
		       /* try {
					appendWrite(MainActivity.BitmapBytes, MainActivity.decodedDirPath + "/" + "slideshow" + ".rgb565");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
	        }
    }
    
/*
	    public void appendWrite(byte[] data, String filename) throws IOException {
		 FileOutputStream fos = new FileOutputStream(filename, true);  //true means append, false is over-write
	     fos.write(data);
	     fos.close();
	}*/
    
    }