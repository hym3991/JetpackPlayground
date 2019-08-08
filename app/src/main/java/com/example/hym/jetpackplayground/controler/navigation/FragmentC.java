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
public class FragmentC extends Fragment
{
	@Nullable
	@Override
	public View onCreateView(
			@NonNull LayoutInflater inflater ,
			@Nullable ViewGroup container ,
			@Nullable Bundle savedInstanceState )
	{
		return inflater.inflate( R.layout.fragment_c,container,false );
	}
	
}
