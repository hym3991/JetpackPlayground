package com.example.hym.jetpackplayground.controler.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hym.jetpackplayground.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 *
 */
public class FragmentB extends Fragment
{
	@Nullable
	@Override
	public View onCreateView(
			@NonNull LayoutInflater inflater ,
			@Nullable ViewGroup container ,
			@Nullable Bundle savedInstanceState )
	{
		return inflater.inflate( R.layout.fragment_b,container,false );
	}
	
	@Override
	public void onResume()
	{
		super.onResume();
		FragmentBArgs bundle = FragmentBArgs.fromBundle( getArguments() );
		String title = bundle.getTitle();
		int num = bundle.getNum();
	}
}
