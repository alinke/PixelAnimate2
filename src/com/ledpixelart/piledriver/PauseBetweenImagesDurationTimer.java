package com.ledpixelart.piledriver;

import ioio.lib.api.exception.ConnectionLostException;
import alt.android.os.CountDownTimer;
import com.ledpixelart.piledriver.MainActivity;

 public class PauseBetweenImagesDurationTimer extends CountDownTimer
	{

		public PauseBetweenImagesDurationTimer(long startTime, long interval)
			{
				super(startTime, interval);
			}

		@Override
		public void onFinish()
			{
			try {
				MainActivity.SlideShow(false);
			} catch (ConnectionLostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //we've paused long enough, show the next image
			MainActivity.pausebetweenimagesdurationTimer.cancel();
				
			}

		@Override
		public void onTick(long millisUntilFinished)				{
			//not used
		}
	}