package com.lgh.chess.chess;

import android.content.Context;

import com.lgh.chess.GloableValues;
import com.lgh.chess.ui.ChessView;

public class Ma extends ChessView {

	public Ma(Context context) {
		super(context);
	}

	@Override
	public void moveTo(int position_x, int position_y) {
		int[] currentPos = getPosition();
		int currentX = currentPos[0];
		int currentY = currentPos[1];
		// 马只能走日 也就是x±1的时候y只能±2，x±2的时候y只能±1
		// 并且当x±2的时候如果x±1的位置有棋子 则不能移动
		// 当y±2的时候如果y±1的位置有棋子 则不能移动
		if ((Math.abs(currentX - position_x) == 2 && Math.abs(currentY - position_y) == 1)) {
			for (int i = 0; i < GloableValues.allChessList.size(); i++) {
				int[] otherChessPosition = GloableValues.allChessList.get(i).getPosition();
				// 左右马腿被憋的状态
				if (currentY == otherChessPosition[1]) {
					// 当正右方马腿被憋
					if ((otherChessPosition[0] == currentX + 1) && Math.abs(position_y - currentY) == 1 && position_x - currentX == 2) {
						return;
					}
					// 当正左方马腿被憋
					if ((otherChessPosition[0] == currentX - 1) && Math.abs(position_y - currentY) == 1 && currentX - position_x == 2) {
						return;
					}
				}
			}
		} else if ((Math.abs(currentX - position_x) == 1 && Math.abs(currentY - position_y) == 2)) {
			for (int i = 0; i < GloableValues.allChessList.size(); i++) {
				int[] otherChessPosition = GloableValues.allChessList.get(i).getPosition();
				// 上下马腿被憋的状态
				if (currentX == otherChessPosition[0]) {
					// 当正上方马腿被憋
					if ((otherChessPosition[1] == currentY + 1) && Math.abs(position_x - currentX) == 1 && position_y - currentY == 2) {
						return;
					}
					// 当正左方马腿被憋
					if ((otherChessPosition[1] == currentY - 1) && Math.abs(position_x - currentX) == 1 && currentY - position_y == 2) {
						return;
					}
				}
			}
		} else {
			return;
		}
		super.moveTo(position_x, position_y);
	}
}
