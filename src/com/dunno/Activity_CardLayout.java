package com.dunno;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.dunno.cardlayout.R;

public class Activity_CardLayout extends ListActivity 
{
    private Context mContext = Activity_CardLayout.this;
	
	@Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // Generate some data for cards
        ArrayList<CardContent> cards = new ArrayList<CardContent>();
        for (int i = 0; i < 20; i++)
        {
        	cards.add(new CardContent("Title: " + Integer.toString(i), "Content: " + Integer.toString(i)));
        }
        
        // Set Adapter
        CardArrayAdapter arrayAdapter = new CardArrayAdapter(mContext, R.layout.card_layout, cards);
        setListAdapter(arrayAdapter);
    }
	
	private class CardArrayAdapter extends ArrayAdapter<CardContent>
	{
		private ArrayList<CardContent> cards = null;
		private Context mContext = null;
		
		public CardArrayAdapter(Context c, int viewResourceId, ArrayList<CardContent> cards)
		{
			super(c, viewResourceId, cards);
			this.cards = cards;
			this.mContext = c;
		}
		
		public View getView(int position, View convertView, ViewGroup parent)
		{
			View v = convertView;
			
			if (v == null)
			{
				LayoutInflater layoutInflater = LayoutInflater.from(mContext);
				
				v = layoutInflater.inflate(R.layout.card_layout, null);
			}
			
			CardContent c = cards.get(position);
			
			TextView title = (TextView) v.findViewById(R.id.card_title);
			TextView content = (TextView) v.findViewById(R.id.card_content);
			
			if (c != null)
			{
				title.setText(c.getTitle());
				content.setText(c.getContent());
			}
			
			return v;
		}
	}
}