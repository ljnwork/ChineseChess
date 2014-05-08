package com.lgh.chess;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HelpActivity extends Activity {
	private TextView tv_helpText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.chess_help);
		tv_helpText = (TextView) findViewById(R.id.tv_helpText);
		tv_helpText.setText("用鼠标点击选中您\n所需移动的棋子,\n然后再次点击需要\n移动到的位置，当\n符合规则时，将移\n动成功。");
	}

	public void back(View view) {
		finish();
	}

}
