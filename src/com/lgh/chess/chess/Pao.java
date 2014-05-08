package com.lgh.chess.chess;

import android.content.Context;
import android.util.Log;

import com.lgh.chess.GloableValues;
import com.lgh.chess.ui.ChessView;

public class Pao extends ChessView {

	public Pao(Context context) {
		super(context);
	}

	@Override
	public void moveTo(int position_x, int position_y) {
		int[] currentPos = getPosition();
		int currentX = currentPos[0];
		int currentY = currentPos[1];
		
		// 判断走直线
		if ((position_x - currentX) * (position_y - currentY) == 0) {
			Log.i("", "判断走直线");
			for (int i = 0; i < GloableValues.allChessList.size(); i++) {
				ChessView otherChess = GloableValues.allChessList.get(i);
				int[] otherPos = otherChess.getPosition();
				int otherX = otherPos[0];
				int otherY = otherPos[1];
				Log.i("", "----otherX:"+otherX+"--otherY:"+otherY);
				for (int j = 0; j < GloableValues.allChessList.size(); j++) {
					ChessView ateChess = GloableValues.allChessList.get(j);
					int[] atePos = ateChess.getPosition();
					int ateX = atePos[0];
					int ateY = atePos[1];
					// 三颗棋子在一条直线上
					Log.i("", "----ateX:"+ateX+"--ateY:"+ateY);
					if (((otherX - ateX) * (otherY - ateY) == 0) && ((ateX - currentX) * (ateY - currentY) == 0) && ((otherX - currentX) * (otherY - currentY) == 0)) {
						Log.i("", "三颗棋子在一条直线上");

						// 障碍物棋子在被吃掉棋子和当前位置之间
						if ((Math.abs(ateX - currentX) > Math.abs(currentX - otherX)) || (Math.abs(ateY - currentY) > Math.abs(currentY - otherY))) {
							Log.i("", "障碍物棋子在被吃掉棋子和当前位置之间");
							// 被吃掉的棋子就是当前棋子的目标移动位置
							if (ateX == position_x && ateY == position_y) {
								Log.i("", "被吃掉的棋子就是当前棋子的目标移动位置");
								// 被吃掉的棋子和自己的颜色不一样
								if (!ateChess.getColor().equals(getColor())) {
									Log.i("", "被吃掉的棋子和自己的颜色不一样");
									super.moveTo(position_x, position_y);
								}else{
									continue;
								}
							} else if (!(Math.abs(currentX - position_x) > Math.abs(currentX - otherX) || (Math.abs(currentY - position_y) > Math.abs(currentY - otherY)))) {
								// 当障碍物不在目标位置和当前位置之间
								super.moveTo(position_x, position_y);
								Log.i("", "当障碍物不在目标位置和当前位置之间");
							}else {
								continue;
							}
						} else {
							continue;
						}
					} else {
						continue;
					}
				}
				// 当障碍物在目标位置和当前位置之间
				if ((Math.abs(currentX - position_x) > Math.abs(currentX - otherX) && (Math.abs(currentY - position_y) > Math.abs(currentY - otherY)))) {

				} else {
					continue;
				}
			}
		} else {
			return;
		}

		super.moveTo(position_x, position_y);
	}
}
