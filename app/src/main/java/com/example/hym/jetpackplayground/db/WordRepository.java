package com.example.hym.jetpackplayground.db;

import android.app.Application;
import android.util.Log;

import com.example.hym.jetpackplayground.db.dao.WordDao;
import com.example.hym.jetpackplayground.db.entity.WordEntity;

import java.util.List;

import androidx.lifecycle.LiveData;

/**
 *
 */
public class WordRepository
{
	private WordDao wordDao;
	private LiveData<List<WordEntity>> mAllWords;
	
	public WordRepository( Application application )
	{
		AppDataBase db = AppDataBase.getDatabase( application );
		wordDao = db.wordDao();
		mAllWords = wordDao.getAllWords();
		Log.d( "hym","WordRepository  getmAllWords:"+mAllWords.getValue() );
	}
	
	public LiveData<List<WordEntity>> getmAllWords()
	{
		return mAllWords;
	}
	public void insert(WordEntity wordEntity)
	{
		new InsertAsyncTask(wordDao).execute( wordEntity );
	}
}
