package com.example.hym.jetpackplayground.controler.login;

import android.os.Bundle;

import com.example.hym.jetpackplayground.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 *
 */
public class LoginActivity extends AppCompatActivity
{
	private LoginActivityVM vm;
	@Override
	protected void onCreate( @Nullable Bundle savedInstanceState )
	{
		super.onCreate( savedInstanceState );
		setContentView( R.layout.activity_login );
	}
}
