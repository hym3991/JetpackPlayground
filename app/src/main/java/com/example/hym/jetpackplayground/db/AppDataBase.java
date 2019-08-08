package com.example.hym.jetpackplayground.db;

import android.content.Context;
import android.os.AsyncTask;

import com.example.hym.jetpackplayground.db.dao.WordDao;
import com.example.hym.jetpackplayground.db.entity.WordEntity;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

/**
 *
 */
@Database( entities = { WordEntity.class },version = 1)
public abstract class AppDataBase extends RoomDatabase
{
	public abstract WordDao wordDao();
	
	private static volatile AppDataBase INSTANCE;
	static AppDataBase getDatabase(final
			Context context )
	{
		if( INSTANCE == null )
		{
			synchronized( AppDataBase.class )
			{
				if( INSTANCE == null )
				{
					INSTANCE = Room.databaseBuilder( context,AppDataBase.class,"word_database" )
							.addCallback( callback ).build();
				}
			}
		}
		return INSTANCE;
	}
	
	
	private static RoomDatabase.Callback callback = new RoomDatabase.Callback()
	{
		@Override
		public void onOpen( @NonNull SupportSQLiteDatabase db )
		{
			super.onOpen( db );
			new PopulateDbAsync(INSTANCE).execute();
		}
	};
	
	private static class PopulateDbAsync extends AsyncTask<Void,Void,Void>
	{
		private final WordDao dao;
		
		PopulateDbAsync(AppDataBase db)
		{
			dao = db.wordDao();
		}
		
		@Override
		protected Void doInBackground( Void... voids )
		{
			dao.deleteAll();
			WordEntity word = new WordEntity("Hello");
			dao.insert(word);
			word = new WordEntity("World");
			dao.insert(word);
			return null;
		}
	}
	
	
}
