package com.lgh.chess.chess;

import android.content.Context;
import com.lgh.chess.GloableValues;
import com.lgh.chess.ui.ChessView;

public class Ju extends ChessView {

	public Ju(Context context) {
		super(context);
	}

	@Override
	public void moveTo(int position_x, int position_y) {
		int[] currentPos = getPosition();
		// 只有当车走直线的时候 才可以move
		if ((currentPos[0] - position_x) * (currentPos[1] - position_y) == 0) {
			// 只有当车正前方没有障碍的时候 才可以move
			// 判断当前点与目标点之间是否有障碍存在

			// 车竖直移动 中间有障碍物的处理
			if (currentPos[0] - position_x == 0) {

				for (int i = 0; i < GloableValues.allChessList.size(); i++) {
					int[] otherChessPosition = GloableValues.allChessList.get(i).getPosition();
					if (currentPos[0] == otherChessPosition[0]) {
						if (currentPos[1] < position_y && (otherChessPosition[1] > currentPos[1] && otherChessPosition[1] < position_y)) {
							return;
						} else if (position_y < currentPos[1] && (otherChessPosition[1] < currentPos[1] && otherChessPosition[1] > position_y)) {
							return;
						}
					}
				}
			}

			// 车水平移动 中间障碍物的处理
			if (currentPos[1] - position_y == 0) {

				for (int i = 0; i < GloableValues.allChessList.size(); i++) {
					int[] otherChessPosition = GloableValues.allChessList.get(i).getPosition();
					if (currentPos[1] == otherChessPosition[1]) {
						if (currentPos[0] < position_x && (otherChessPosition[0] > currentPos[0] && otherChessPosition[0] < position_x)) {
							return;
						} else if (position_x < currentPos[0] && (otherChessPosition[0] < currentPos[0] && otherChessPosition[0] > position_x)) {
							return;
						}
					}
				}
			}
			super.moveTo(position_x, position_y);
		}

	}

}
