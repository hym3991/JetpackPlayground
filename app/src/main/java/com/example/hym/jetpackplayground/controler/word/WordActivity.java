package com.example.hym.jetpackplayground.controler.word;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.hym.jetpackplayground.R;
import com.example.hym.jetpackplayground.db.entity.WordEntity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 *
 */
public class WordActivity extends AppCompatActivity
{
	private WordViewModel wordViewModel;
	private FloatingActionButton button;
	@Override
	protected void onCreate( @Nullable Bundle savedInstanceState )
	{
		super.onCreate( savedInstanceState );
		setContentView( R.layout.activity_main );
		button = (FloatingActionButton)findViewById( R.id.main_btn );
		wordViewModel = ViewModelProviders.of( this ).get( WordViewModel.class );
		
		RecyclerView recyclerView = findViewById( R.id.recyclerview );
		final WordAdapter adapter = new WordAdapter(this );
		recyclerView.setAdapter( adapter );
		recyclerView.setLayoutManager( new LinearLayoutManager( this ) );
		
		wordViewModel.getmAllWords().observe( this , new Observer<List<WordEntity>>()
		{
			@Override
			public void onChanged( List<WordEntity> wordEntities )
			{
				adapter.setWords( wordEntities );
			}
		} );
		button.setOnClickListener( new View.OnClickListener()
		{
			@Override
			public void onClick( View v )
			{
				Intent intent = new Intent( WordActivity.this, NewWordActivity.class);
				startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);
			}
		} );
	}
	public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		
		if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
			WordEntity word = new WordEntity(data.getStringExtra(NewWordActivity.EXTRA_REPLY));
			wordViewModel.insert(word);
		} else {
			Toast.makeText(
					getApplicationContext(),
					R.string.empty_not_saved,
					Toast.LENGTH_LONG).show();
		}
	}
}
