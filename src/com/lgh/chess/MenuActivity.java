package com.lgh.chess;

import com.lgh.chess.service.SoundService;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends Activity {
	private Button bt_menu_startgame;
	private Button bt_menu_opensound;
	private Button bt_menu_help;
	private Button bt_menu_exit;
	private MediaPlayer mediaPlayer = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.chess_menu);

		bt_menu_startgame = (Button) findViewById(R.id.bt_menu_startgame);
		bt_menu_opensound = (Button) findViewById(R.id.bt_menu_opensound);
		bt_menu_help = (Button) findViewById(R.id.bt_menu_help);
		bt_menu_exit = (Button) findViewById(R.id.bt_menu_exit);
		mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.startsound);
	}

	public void startgame(View view) {
		Intent intent = new Intent(MenuActivity.this, ChessVsActivity.class);
		startActivity(intent);
	}

	public void opensound(View view) {

		if ("开启声音".equals(bt_menu_opensound.getText())) {
			bt_menu_opensound.setText("关闭声音");
			if (mediaPlayer != null) {
				mediaPlayer.start();
			}
		} else {
			bt_menu_opensound.setText("开启声音");
			if (mediaPlayer != null) {
				mediaPlayer.stop();
				mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.startsound);
			}
		}
	}

	private class MyConn implements ServiceConnection {

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {

		}

		@Override
		public void onServiceDisconnected(ComponentName name) {

		}

	}

	public void help(View view) {
		Intent intent = new Intent(MenuActivity.this, HelpActivity.class);
		startActivity(intent);
	}

	public void exit(View view) {
		finish();
	}
}
