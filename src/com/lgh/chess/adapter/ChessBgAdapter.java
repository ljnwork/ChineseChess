package com.lgh.chess.adapter;

import com.lgh.chess.R;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ChessBgAdapter extends BaseAdapter {
	Context ct;
	public ChessBgAdapter(Context ct) {
		this.ct = ct;
	}

	@Override
	public int getCount() {
		return 90;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	} 

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = View.inflate(ct, R.layout.chess_point, null);
		return view;
	}

}
