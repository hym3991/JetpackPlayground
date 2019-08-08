package com.example.hym.jetpackplayground.db.dao;

import com.example.hym.jetpackplayground.db.entity.WordEntity;
import java.util.List;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

/**
 *
 */
@Dao
public interface WordDao
{
	@Insert
	void insert( WordEntity wordEntity );
	
	@Query( value = "DELETE FROM word_table" )
	void deleteAll();
	
	@Query( value = "SELECT * from word_table" )
	LiveData<List<WordEntity>> getAllWords();
}
