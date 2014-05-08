package com.lgh.chess.chess;

import android.content.Context;

import com.lgh.chess.ui.ChessView;

public class Jiang extends ChessView {

	public Jiang(Context context) {
		super(context);
	}

	@Override
	public void moveTo(int position_x, int position_y) {
		int[] currentPos = getPosition();
		int currentX = currentPos[0];
		int currentY = currentPos[1];
		// 当是上方的帅的时候 士的X移动范围在3到5，Y的移动范围在0到2
		// 当是下方的将的时候 士的X移动范围在3到5，Y的移动范围在7到9
		if (3 <= position_x && 5 >= position_x) {
			if (!(Math.abs(position_x - currentX) + Math.abs(position_y - currentY) == 1)) {
				return;
			}

			// 上方将
			if (currentY <= 2 && position_y <= 2) {

			} else if (currentY >= 7 && position_y >= 7) {// 下方将

			} else {
				return;
			}
		} else {
			return;
		}

		super.moveTo(position_x, position_y);
	}
}
