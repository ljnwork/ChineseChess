package com.lgh.chess.chess;

import android.content.Context;

import com.lgh.chess.GloableValues;
import com.lgh.chess.ui.ChessView;

public class Xiang extends ChessView {

	public Xiang(Context context) {
		super(context);
	}

	@Override
	public void moveTo(int position_x, int position_y) {

		int[] currentPos = getPosition();
		int current_x = currentPos[0];
		int current_y = currentPos[1];
		if ((Math.abs(current_x - position_x) == 2) && (Math.abs(current_y - position_y)) == 2) {
			// 红棋过河
			// 黑棋过河
			if ((current_y <= 4 && position_y > 4) || (current_y >= 5 && position_y <= 4)) {
				return;
			}

			for (int i = 0; i < GloableValues.allChessList.size(); i++) {
				int[] otherChessPosition = GloableValues.allChessList.get(i).getPosition();
				if (((current_x - otherChessPosition[0]) == 1) && ((current_y - otherChessPosition[1]) == 1)) {
					if ((position_x < current_x) && ((position_y < current_y))) {
						return;
					}
				}
				if (((otherChessPosition[0] - current_x) == 1) && (current_y - otherChessPosition[1] == 1)) {
					if ((position_y < current_y) && (position_x > current_x)) {
						return;
					}
				}
				if (((otherChessPosition[1] - current_y) == 1) && (current_x - otherChessPosition[0] == 1)) {
					if ((position_y > current_y) && (position_x < current_x)) {
						return;
					}
				}
				if (((otherChessPosition[0] - current_x) == 1) && (otherChessPosition[1] - current_y == 1)) {
					if ((position_y > current_y) && (position_x > current_x)) {
						return;
					}
				}

			}
		} else {
			return;
		}
		if (current_y < 4 && position_y > 4) {
			return;
		}
		// if (current_y > 4) {
		// if (position_y < 5) {
		// return;
		// }
		// }
		super.moveTo(position_x, position_y);
	}
}