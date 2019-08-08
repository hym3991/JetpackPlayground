package com.example.hym.jetpackplayground.controler.livedata;

import android.os.SystemClock;

import java.util.Timer;
import java.util.TimerTask;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 *
 */
public class LiveDataTimerVM extends ViewModel
{
	private static final int ONE_SECOND = 1000;
	private MutableLiveData<Long> mElapsedTime = new MutableLiveData<>();
	private long mInitialTime;
	
	public LiveDataTimerVM()
	{
		mInitialTime = SystemClock.elapsedRealtime();
		Timer timer = new Timer(  );
		timer.scheduleAtFixedRate( new TimerTask()
		{
			@Override
			public void run()
			{
				final long newValue = (SystemClock.elapsedRealtime() - mInitialTime)/1000;
				mElapsedTime.postValue( newValue );
			}
		} ,ONE_SECOND,ONE_SECOND);
	}
	
	public MutableLiveData<Long> getmElapsedTime()
	{
		return mElapsedTime;
	}
}
