package com.example.hym.jetpackplayground.db.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 *
 */
@Entity(tableName = "word_table")
public class WordEntity
{
	@PrimaryKey
	@NonNull
	private String word;

	public WordEntity(){}
	
	@Ignore
	public WordEntity(String word)
	{
		this.word = word;
	}
	
	public String getWord()
	{
		return word;
	}
	
	public void setWord( String mWord )
	{
		this.word = mWord;
	}
}
