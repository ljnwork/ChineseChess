package com.lgh.chess.chess;

import android.content.Context;

import com.lgh.chess.ui.ChessView;

public class Bing extends ChessView {

	public Bing(Context context) {
		super(context);
	}

	@Override
	public void moveTo(int position_x, int position_y) {
		int[] currentPos = getPosition();
		int currentX = currentPos[0];
		int currentY = currentPos[1];

		String currentColor = getColor();
		if ("red".equals(currentColor)) {
			if (currentY <= 4) {// 未过河的红兵
				if (position_y - currentY != 1) {
					return;
				}
			} else {
				// 过了河的红兵
				if (!(Math.abs(position_x - currentX) + (position_y - currentY) == 1)) {
					return;
				}
			}

		} else if ("black".equals(currentColor)) {
			if (currentY >= 5) {// 未过河的黑卒
				if (currentY - position_y != 1) {
					return;
				}
			} else {
				// 过了河的黑卒
				if (!(Math.abs(position_x - currentX) + (currentY - position_y) == 1)) {
					return;
				}
			}
		}
		//放置兵走斜线
		if (Math.abs(position_x - currentX) + Math.abs(currentY - position_y) > 1) {
			return;
		}

		super.moveTo(position_x, position_y);
	}
}
