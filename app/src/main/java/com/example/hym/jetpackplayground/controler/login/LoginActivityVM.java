package com.example.hym.jetpackplayground.controler.login;

import com.example.hym.jetpackplayground.bean.LoginRequest;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 *
 */
public class LoginActivityVM extends ViewModel
{
	private MutableLiveData<LoginRequest> liveData = new MutableLiveData<>();
	private LoginRequest model;
	public LoginRequest getModel()
	{
		return model;
	}
	
	public void setModel( LoginRequest model )
	{
		this.model = model;
		liveData.setValue( model );
	}
	
	public void doStart()
	{
	}
}
