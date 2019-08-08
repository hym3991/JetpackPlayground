package com.example.hym.jetpackplayground.controler.word;

import android.app.Application;
import android.util.Log;

import com.example.hym.jetpackplayground.db.WordRepository;
import com.example.hym.jetpackplayground.db.entity.WordEntity;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

/**
 *
 */
public class WordViewModel extends AndroidViewModel
{
	private WordRepository wordRepository;
	private LiveData<List<WordEntity>> mAllWords;
	public WordViewModel(Application application)
	{
		super(application);
		wordRepository = new WordRepository(application);
		mAllWords = wordRepository.getmAllWords();
		Log.d( "hym","WordViewModel  getmAllWords:"+mAllWords.getValue() );
	}
	
	public LiveData<List<WordEntity>> getmAllWords()
	{
		return mAllWords;
	}
	
	public void insert(WordEntity wordEntity)
	{
		wordRepository.insert( wordEntity );
	}
}
