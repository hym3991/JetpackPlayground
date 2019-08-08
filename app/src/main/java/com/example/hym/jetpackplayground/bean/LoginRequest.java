package com.example.hym.jetpackplayground.bean;

import com.example.hym.jetpackplayground.BR;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

/**
 *
 */
public class LoginRequest extends BaseObservable
{
	private String userName;
	private String pwd;
	
	@Bindable
	public String getUserName()
	{
		return userName;
	}
	
	public void setUserName( String userName )
	{
		this.userName = userName;
		notifyPropertyChanged( BR.userName );
	}
	
	@Bindable
	public String getPwd()
	{
		return pwd;
	}
	
	public void setPwd( String pwd )
	{
		this.pwd = pwd;
		notifyPropertyChanged( BR.pwd );
	}
}

