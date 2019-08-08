package com.example.hym.jetpackplayground.controler.word;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hym.jetpackplayground.R;
import com.example.hym.jetpackplayground.db.entity.WordEntity;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 *
 */
public class WordAdapter extends RecyclerView.Adapter<WordAdapter.WordViewHolder>
{
	private final LayoutInflater layoutInflater;
	private List<WordEntity> mWords;
	
	WordAdapter( Context context )
	{
		layoutInflater = LayoutInflater.from( context );
	}
	
	
	@NonNull
	@Override
	public WordViewHolder onCreateViewHolder(
			@NonNull ViewGroup parent ,
			int viewType )
	{
		View itemView = layoutInflater.inflate( R.layout.recyclerview_item,parent ,false);
		return new WordViewHolder( itemView );
	}
	
	@Override
	public void onBindViewHolder(
			@NonNull WordViewHolder holder ,
			int position )
	{
		if( mWords != null )
		{
			WordEntity wordEntity = mWords.get( position );
			holder.textView.setText( wordEntity.getWord() );
		}
		else
		{
			holder.textView.setText( "no word" );
		}
	}
	
	void setWords(List<WordEntity> words)
	{
		mWords = words;
		notifyDataSetChanged();
	}
	
	@Override
	public int getItemCount()
	{
		return mWords != null?mWords.size():0;
	}
	
	class WordViewHolder extends RecyclerView.ViewHolder
	{
		private final TextView textView;
		private WordViewHolder( View itemView )
		{
			super(itemView);
			textView = itemView.findViewById( R.id.textView );
		}
	}
	
	
}
