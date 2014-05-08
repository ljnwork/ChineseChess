package com.lgh.chess;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import com.lgh.chess.chess.Bing;
import com.lgh.chess.chess.Jiang;
import com.lgh.chess.chess.Ju;
import com.lgh.chess.chess.Ma;
import com.lgh.chess.chess.Pao;
import com.lgh.chess.chess.Shi;
import com.lgh.chess.chess.Xiang;
import com.lgh.chess.domain.Point;
import com.lgh.chess.ui.ChessBgView;
import com.lgh.chess.ui.ChessView;

@SuppressLint("NewApi")
public class ChessVsActivity extends Activity implements OnTouchListener, OnClickListener {

	private ChessBgView cv;
	private RelativeLayout rl_root;
	private Button bt_restart;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		cv = (ChessBgView) findViewById(R.id.cv);
		bt_restart = (Button) findViewById(R.id.bt_restart);
		bt_restart.setOnClickListener(this);

		cv.setOnTouchListener(this);
		rl_root = (RelativeLayout) findViewById(R.id.rl_root);

		GloableValues.positionArray = new Point[9][10];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 10; j++) {
				GloableValues.positionArray[i][j] = new Point(i * 35 + 12, j * 33 + 24);
			}
		}

		initChess();

	}

	private void initChess() {
		GloableValues.allChessList = new ArrayList<ChessView>();
		GloableValues.allChessList.add(new Ju(getApplicationContext()));
		GloableValues.allChessList.add(new Ma(getApplicationContext()));
		GloableValues.allChessList.add(new Xiang(getApplicationContext()));
		GloableValues.allChessList.add(new Shi(getApplicationContext()));
		GloableValues.allChessList.add(new Jiang(getApplicationContext()));// 5
																			// 红帅
		GloableValues.allChessList.add(new Shi(getApplicationContext()));// 6 士
		GloableValues.allChessList.add(new Xiang(getApplicationContext()));// 7
																			// 相
		GloableValues.allChessList.add(new Ma(getApplicationContext()));// 8 马
		GloableValues.allChessList.add(new Ju(getApplicationContext()));// 9 车
		GloableValues.allChessList.add(new Pao(getApplicationContext()));// 10
																				// 炮
		GloableValues.allChessList.add(new Pao(getApplicationContext()));// 11
																				// 炮
		GloableValues.allChessList.add(new Bing(getApplicationContext()));// 12
																			// 兵
		GloableValues.allChessList.add(new Bing(getApplicationContext()));// 13
																			// 兵
		GloableValues.allChessList.add(new Bing(getApplicationContext()));// 14
																			// 兵
		GloableValues.allChessList.add(new Bing(getApplicationContext()));// 15
																			// 兵
		GloableValues.allChessList.add(new Bing(getApplicationContext()));// 16
																			// 兵
		GloableValues.allChessList.add(new Ju(getApplicationContext()));// 17 黑車
		GloableValues.allChessList.add(new Ma(getApplicationContext()));// 18 马
		GloableValues.allChessList.add(new Xiang(getApplicationContext()));// 19
																			// 象
		GloableValues.allChessList.add(new Shi(getApplicationContext()));// 20 士
		GloableValues.allChessList.add(new Jiang(getApplicationContext()));// 21
																			// 将
		GloableValues.allChessList.add(new Shi(getApplicationContext()));// 22 士
		GloableValues.allChessList.add(new Xiang(getApplicationContext()));// 23
																			// 象
		GloableValues.allChessList.add(new Ma(getApplicationContext()));// 24 马
		GloableValues.allChessList.add(new Ju(getApplicationContext()));// 25 車
		GloableValues.allChessList.add(new Pao(getApplicationContext()));// 26
																				// 炮
		GloableValues.allChessList.add(new Pao(getApplicationContext()));// 27
																				// 炮
		GloableValues.allChessList.add(new Bing(getApplicationContext()));// 28
																			// 卒
		GloableValues.allChessList.add(new Bing(getApplicationContext()));// 29
																			// 卒
		GloableValues.allChessList.add(new Bing(getApplicationContext()));// 30
																			// 卒
		GloableValues.allChessList.add(new Bing(getApplicationContext()));// 31
																			// 卒
		GloableValues.allChessList.add(new Bing(getApplicationContext()));// 32
																			// 卒

		// GloableValues.redChessList =
		// GloableValues.GloableValues.redChessList;
		GloableValues.redChessList = new ArrayList<ChessView>();
		GloableValues.blackChessList = new ArrayList<ChessView>();

		GloableValues.allChessList.get(0).setColor("red");
		GloableValues.allChessList.get(0).setName("车");
		GloableValues.allChessList.get(0).setPosition(new int[] { 0, 0 });
		GloableValues.redChessList.add(GloableValues.allChessList.get(0));

		GloableValues.allChessList.get(1).setColor("red");
		GloableValues.allChessList.get(1).setName("马");
		GloableValues.allChessList.get(1).setPosition(new int[] { 1, 0 });
		GloableValues.redChessList.add(GloableValues.allChessList.get(1));

		GloableValues.allChessList.get(2).setColor("red");
		GloableValues.allChessList.get(2).setName("相");
		GloableValues.allChessList.get(2).setPosition(new int[] { 2, 0 });
		GloableValues.redChessList.add(GloableValues.allChessList.get(2));

		GloableValues.allChessList.get(3).setColor("red");
		GloableValues.allChessList.get(3).setName("士");
		GloableValues.allChessList.get(3).setPosition(new int[] { 3, 0 });
		GloableValues.redChessList.add(GloableValues.allChessList.get(3));

		GloableValues.allChessList.get(4).setColor("red");
		GloableValues.allChessList.get(4).setName("帅");
		GloableValues.allChessList.get(4).setPosition(new int[] { 4, 0 });
		GloableValues.redChessList.add(GloableValues.allChessList.get(4));

		GloableValues.allChessList.get(5).setColor("red");
		GloableValues.allChessList.get(5).setName("士");
		GloableValues.allChessList.get(5).setPosition(new int[] { 5, 0 });
		GloableValues.redChessList.add(GloableValues.allChessList.get(5));

		GloableValues.allChessList.get(6).setColor("red");
		GloableValues.allChessList.get(6).setName("相");
		GloableValues.allChessList.get(6).setPosition(new int[] { 6, 0 });
		GloableValues.redChessList.add(GloableValues.allChessList.get(6));

		GloableValues.allChessList.get(7).setColor("red");
		GloableValues.allChessList.get(7).setName("马");
		GloableValues.allChessList.get(7).setPosition(new int[] { 7, 0 });
		GloableValues.redChessList.add(GloableValues.allChessList.get(7));

		GloableValues.allChessList.get(8).setColor("red");
		GloableValues.allChessList.get(8).setName("车");
		GloableValues.allChessList.get(8).setPosition(new int[] { 8, 0 });
		GloableValues.redChessList.add(GloableValues.allChessList.get(8));

		GloableValues.allChessList.get(9).setColor("red");
		GloableValues.allChessList.get(9).setName("炮");
		GloableValues.allChessList.get(9).setPosition(new int[] { 1, 2 });
		GloableValues.redChessList.add(GloableValues.allChessList.get(9));

		GloableValues.allChessList.get(10).setColor("red");
		GloableValues.allChessList.get(10).setName("炮");
		GloableValues.allChessList.get(10).setPosition(new int[] { 7, 2 });
		GloableValues.redChessList.add(GloableValues.allChessList.get(10));

		GloableValues.allChessList.get(11).setColor("red");
		GloableValues.allChessList.get(11).setName("兵");
		GloableValues.allChessList.get(11).setPosition(new int[] { 0, 3 });
		GloableValues.redChessList.add(GloableValues.allChessList.get(11));

		GloableValues.allChessList.get(12).setColor("red");
		GloableValues.allChessList.get(12).setName("兵");
		GloableValues.allChessList.get(12).setPosition(new int[] { 2, 3 });
		GloableValues.redChessList.add(GloableValues.allChessList.get(12));

		GloableValues.allChessList.get(13).setColor("red");
		GloableValues.allChessList.get(13).setName("兵");
		GloableValues.allChessList.get(13).setPosition(new int[] { 4, 3 });
		GloableValues.redChessList.add(GloableValues.allChessList.get(13));

		GloableValues.allChessList.get(14).setColor("red");
		GloableValues.allChessList.get(14).setName("兵");
		GloableValues.allChessList.get(14).setPosition(new int[] { 6, 3 });
		GloableValues.redChessList.add(GloableValues.allChessList.get(14));

		GloableValues.allChessList.get(15).setColor("red");
		GloableValues.allChessList.get(15).setName("兵");
		GloableValues.allChessList.get(15).setPosition(new int[] { 8, 3 });
		GloableValues.redChessList.add(GloableValues.allChessList.get(15));

		// GloableValues.blackChessList = new ArrayList<ChessView>();

		GloableValues.allChessList.get(16).setColor("black");
		GloableValues.allChessList.get(16).setName("車");
		GloableValues.allChessList.get(16).setPosition(new int[] { 0, 9 });
		GloableValues.blackChessList.add(GloableValues.allChessList.get(16));

		GloableValues.allChessList.get(17).setColor("black");
		GloableValues.allChessList.get(17).setName("馬");
		GloableValues.allChessList.get(17).setPosition(new int[] { 1, 9 });
		GloableValues.blackChessList.add(GloableValues.allChessList.get(17));

		GloableValues.allChessList.get(18).setColor("black");
		GloableValues.allChessList.get(18).setName("象");
		GloableValues.allChessList.get(18).setPosition(new int[] { 2, 9 });
		GloableValues.blackChessList.add(GloableValues.allChessList.get(18));

		GloableValues.allChessList.get(19).setColor("black");
		GloableValues.allChessList.get(19).setName("仕");
		GloableValues.allChessList.get(19).setPosition(new int[] { 3, 9 });
		GloableValues.blackChessList.add(GloableValues.allChessList.get(19));

		GloableValues.allChessList.get(20).setColor("black");
		GloableValues.allChessList.get(20).setName("将");
		GloableValues.allChessList.get(20).setPosition(new int[] { 4, 9 });
		GloableValues.blackChessList.add(GloableValues.allChessList.get(20));

		GloableValues.allChessList.get(21).setColor("black");
		GloableValues.allChessList.get(21).setName("仕");
		GloableValues.allChessList.get(21).setPosition(new int[] { 5, 9 });
		GloableValues.blackChessList.add(GloableValues.allChessList.get(21));

		GloableValues.allChessList.get(22).setColor("black");
		GloableValues.allChessList.get(22).setName("象");
		GloableValues.allChessList.get(22).setPosition(new int[] { 6, 9 });
		GloableValues.blackChessList.add(GloableValues.allChessList.get(22));

		GloableValues.allChessList.get(23).setColor("black");
		GloableValues.allChessList.get(23).setName("馬");
		GloableValues.allChessList.get(23).setPosition(new int[] { 7, 9 });
		GloableValues.blackChessList.add(GloableValues.allChessList.get(23));

		GloableValues.allChessList.get(24).setColor("black");
		GloableValues.allChessList.get(24).setName("車");
		GloableValues.allChessList.get(24).setPosition(new int[] { 8, 9 });
		GloableValues.blackChessList.add(GloableValues.allChessList.get(24));

		GloableValues.allChessList.get(25).setColor("black");
		GloableValues.allChessList.get(25).setName("炮");
		GloableValues.allChessList.get(25).setPosition(new int[] { 1, 7 });
		GloableValues.blackChessList.add(GloableValues.allChessList.get(25));

		GloableValues.allChessList.get(26).setColor("black");
		GloableValues.allChessList.get(26).setName("炮");
		GloableValues.allChessList.get(26).setPosition(new int[] { 7, 7 });
		GloableValues.blackChessList.add(GloableValues.allChessList.get(26));

		GloableValues.allChessList.get(27).setColor("black");
		GloableValues.allChessList.get(27).setName("卒");
		GloableValues.allChessList.get(27).setPosition(new int[] { 0, 6 });
		GloableValues.blackChessList.add(GloableValues.allChessList.get(27));

		GloableValues.allChessList.get(28).setColor("black");
		GloableValues.allChessList.get(28).setName("卒");
		GloableValues.allChessList.get(28).setPosition(new int[] { 2, 6 });
		GloableValues.blackChessList.add(GloableValues.allChessList.get(28));

		GloableValues.allChessList.get(29).setColor("black");
		GloableValues.allChessList.get(29).setName("卒");
		GloableValues.allChessList.get(29).setPosition(new int[] { 4, 6 });
		GloableValues.blackChessList.add(GloableValues.allChessList.get(29));

		GloableValues.allChessList.get(30).setColor("black");
		GloableValues.allChessList.get(30).setName("卒");
		GloableValues.allChessList.get(30).setPosition(new int[] { 6, 6 });
		GloableValues.blackChessList.add(GloableValues.allChessList.get(30));

		GloableValues.allChessList.get(31).setColor("black");
		GloableValues.allChessList.get(31).setName("卒");
		GloableValues.allChessList.get(31).setPosition(new int[] { 8, 6 });
		GloableValues.blackChessList.add(GloableValues.allChessList.get(31));

		for (int i = 0; i < GloableValues.redChessList.size(); i++) {
			RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			int[] position = GloableValues.redChessList.get(i).getPosition();
			int position_x = position[0];
			int position_y = position[1];
			Point point = GloableValues.positionArray[position_x][position_y];
			params.leftMargin = point.getX() - 10;
			params.topMargin = point.getY() - 12;
			// ChessView cv = new
			// ChessView(getApplicationContext(),GloableValues.redChessList.get(i));
			// cv.setLayoutParams(params);
			GloableValues.redChessList.get(i).setLayoutParams(params);
			GloableValues.redChessList.get(i).setOnTouchListener(this);
			rl_root.addView(GloableValues.redChessList.get(i));
		}

		for (int i = 0; i < GloableValues.blackChessList.size(); i++) {
			RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			int[] position = GloableValues.blackChessList.get(i).getPosition();
			int position_x = position[0];
			int position_y = position[1];
			Point point = GloableValues.positionArray[position_x][position_y];
			params.leftMargin = point.getX() - 10;
			params.topMargin = point.getY() - 12;
			// ChessView cv = new
			// ChessView(getApplicationContext(),GloableValues.blackChessList.get(i));
			// cv.setLayoutParams(params);
			GloableValues.blackChessList.get(i).setLayoutParams(params);
			GloableValues.blackChessList.get(i).setOnTouchListener(this);
			rl_root.addView(GloableValues.blackChessList.get(i));
		}
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			float x = event.getX();
			float y = event.getY();
			Log.i("TAG", "X = " + x);
			Log.i("TAG", "Y = " + y);
			int position_x;
			int position_y;
			// 当前被触摸的棋子
			ChessView touchedChess = null;

			// 每当有新的点击时 先遍历所有棋子 获取被点击的棋子的位置 清空所有的chess点击状态为false
			for (ChessView blackChess : GloableValues.blackChessList) {
				if (blackChess.isTouch()) {
					touchedChess = blackChess;
				}
				blackChess.setTouch(false);
			}
			for (ChessView redChess : GloableValues.redChessList) {
				if (redChess.isTouch()) {
					touchedChess = redChess;
				}
				redChess.setTouch(false);
			}

			// 当棋子或者棋盘被点击的时候的事件-----------
			if (GloableValues.blackChessList.indexOf(v) != -1) {
				// 当黑棋被点击时
				((ChessView) v).setTouch(true);
				position_x = ((ChessView) v).getPosition()[0];
				position_y = ((ChessView) v).getPosition()[1];
			} else if (GloableValues.redChessList.indexOf(v) != -1) {
				// 当红棋被点击时
				((ChessView) v).setTouch(true);
				position_x = ((ChessView) v).getPosition()[0];
				position_y = ((ChessView) v).getPosition()[1];
			} else {
				// 将点击的坐标进行转换成9*10的坐标显示
				position_x = (int) ((x - 12) / 35);
				if (((x - 12) % 35 > 17 ? true : false)) {
					position_x = position_x + 1;
				}
				position_y = (int) ((y - 22) / 33);
				if (((y - 22) % 33 > 16 ? true : false)) {
					position_y = position_y + 1;
				}
			}

			// 移动被触摸的棋子到触摸到的位置
			if (touchedChess != null) {
				touchedChess.moveTo(position_x, position_y);
				// 刷新界面
				flash();
			}
			Point point = GloableValues.positionArray[position_x][position_y];
			// Toast.makeText(getApplicationContext(), position_x + "::" +
			// position_y, 0).show();

			break;
		}
		return true;
	}

	/**
	 * 刷新界面棋子位置
	 */
	private void flash() {
		rl_root.removeAllViews();
		rl_root.addView(cv);
		for (int i = 0; i < GloableValues.redChessList.size(); i++) {
			RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			int[] position = GloableValues.redChessList.get(i).getPosition();
			int position_x = position[0];
			int position_y = position[1];
			Point point = GloableValues.positionArray[position_x][position_y];
			params.leftMargin = point.getX() - 10;
			params.topMargin = point.getY() - 12;
			// ChessView cv = new
			// ChessView(getApplicationContext(),GloableValues.redChessList.get(i));
			// cv.setLayoutParams(params);
			GloableValues.redChessList.get(i).setLayoutParams(params);
			GloableValues.redChessList.get(i).setOnTouchListener(this);
			rl_root.addView(GloableValues.redChessList.get(i));
		}

		for (int i = 0; i < GloableValues.blackChessList.size(); i++) {
			RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			int[] position = GloableValues.blackChessList.get(i).getPosition();
			int position_x = position[0];
			int position_y = position[1];
			Point point = GloableValues.positionArray[position_x][position_y];
			params.leftMargin = point.getX() - 10;
			params.topMargin = point.getY() - 12;
			// ChessView cv = new
			// ChessView(getApplicationContext(),GloableValues.blackChessList.get(i));
			// cv.setLayoutParams(params);
			GloableValues.blackChessList.get(i).setLayoutParams(params);
			GloableValues.blackChessList.get(i).setOnTouchListener(this);
			rl_root.addView(GloableValues.blackChessList.get(i));
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bt_restart:
			initChess();
			flash();
			break;
		}
	}
}
