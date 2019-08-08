package com.example.hym.jetpackplayground.controler.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hym.jetpackplayground.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

/**
 *
 */
public class FragmentA extends Fragment
{
	@Nullable
	@Override
	public View onCreateView(
			@NonNull LayoutInflater inflater ,
			@Nullable ViewGroup container ,
			@Nullable Bundle savedInstanceState )
	{
		return inflater.inflate( R.layout.fragment_a,container,false );
	}
	
	@Override
	public void onResume()
	{
		super.onResume();
		NavHostFragment.findNavController( this ).navigate( R.id.action_fa );
		
		
		FragmentBArgs.Builder args = new  FragmentBArgs.Builder();
		args.setNum( 10 );
		args.setTitle( "sda" );
		NavHostFragment.findNavController( this ).navigate( R.id.action_fa ,args.build().toBundle());
		
	}
}
