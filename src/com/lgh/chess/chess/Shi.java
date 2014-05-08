package com.lgh.chess.chess;

import android.content.Context;

import com.lgh.chess.ui.ChessView;

public class Shi extends ChessView {

	public Shi(Context context) {
		super(context);
	}

	@Override
	public void moveTo(int position_x, int position_y) {
		int[] currentPos = getPosition();
		int currentX = currentPos[0];
		int currentY = currentPos[1];

		// 当是上方的士的时候 士的X移动范围在3到5，Y的移动范围在0到2
		// 当是下方的士的时候 士的X移动范围在3到5，Y的移动范围在7到9
		if (!(3 <= position_x && 5 >= position_x && (Math.abs(position_x - currentX) == 1 && Math.abs(position_y - currentY) == 1)&&((0 <= currentY && currentY <= 2)||(7 <= currentY && currentY <= 9))&&((position_y<=2||7<=position_y&&position_y<=9)))) {
			return;
		}

		super.moveTo(position_x, position_y);
	}
}
