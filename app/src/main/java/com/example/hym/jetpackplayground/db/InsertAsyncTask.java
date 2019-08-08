package com.example.hym.jetpackplayground.db;

import android.os.AsyncTask;

import com.example.hym.jetpackplayground.db.dao.WordDao;
import com.example.hym.jetpackplayground.db.entity.WordEntity;

/**
 *
 */
public class InsertAsyncTask extends AsyncTask<WordEntity,Void,Void>
{
	private WordDao asyncTaskDao;
	
	InsertAsyncTask(WordDao dao)
	{
		asyncTaskDao = dao;
	}
	
	@Override
	protected Void doInBackground( WordEntity... wordEntities )
	{
		asyncTaskDao.insert( wordEntities[0] );
		return null;
	}
}
