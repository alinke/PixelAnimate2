package com.ledpixelart.piledriver;

import ioio.lib.api.exception.ConnectionLostException;
import alt.android.os.CountDownTimer;
import com.ledpixelart.piledriver.MainActivity;

public class ImageDisplayDurationTimer extends CountDownTimer
{

	public ImageDisplayDurationTimer(long startTime, long interval)
		{
			super(startTime, interval);
		}

	@Override
	public void onFinish()
		{
		MainActivity.imagedisplaydurationTimer.cancel();//added this back to see if it will stop crashing
		try {
			MainActivity.clearMatrixImage();
		} catch (ConnectionLostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}

	@Override
	public void onTick(long millisUntilFinished)				{
		//not used
	}
}
