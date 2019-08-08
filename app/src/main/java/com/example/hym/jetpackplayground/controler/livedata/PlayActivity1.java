package com.example.hym.jetpackplayground.controler.livedata;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

/**
 *
 */
public class PlayActivity1 extends AppCompatActivity
{
	private LiveDataTimerVM liveDataTimerVM;
	
	@Override
	protected void onCreate( @Nullable Bundle savedInstanceState )
	{
		super.onCreate( savedInstanceState );
		liveDataTimerVM = new ViewModelProvider( this,new ViewModelProvider.AndroidViewModelFactory( this.getApplication() ) ).get( LiveDataTimerVM.class );
		subscribe();
	}
	
	private void subscribe()
	{
		final Observer<Long> longObserver = new Observer<Long>()
		{
			@Override
			public void onChanged( @Nullable Long aLong )
			{
				Log.d("ChronoActivity3", "Updating timer");
			}
		};
		
		liveDataTimerVM.getmElapsedTime().observe( this,longObserver );
	}
	
}
