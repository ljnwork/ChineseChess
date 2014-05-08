package com.lgh.chess.ui;

import com.lgh.chess.GloableValues;
import com.lgh.chess.domain.Chess;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class ChessView extends View {

	// private Chess chess;
	private String color;
	private String name;
	private int[] position;
	private boolean isLive = true;
	private boolean isTouch = false;

	public boolean isTouch() {
		return isTouch;
	}

	public void setTouch(boolean isTouch) {
		this.isTouch = isTouch;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int[] getPosition() {
		return position;
	}

	public void setPosition(int[] position) {
		this.position = position;
	}

	public boolean isLive() {
		return isLive;
	}

	public void setLive(boolean isLive) {
		this.isLive = isLive;
	}

	public ChessView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	public ChessView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub

	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		setMeasuredDimension(30, 30);
	}

	@Override
	protected void onDraw(Canvas canvas) {

		Paint paint = new Paint();
		paint.setAntiAlias(true);
		paint.setColor(Color.GRAY);
		RectF oval_out = new RectF(0, 0, 30, 30);
		canvas.drawOval(oval_out, paint);
		paint.setColor(Color.WHITE);
		RectF oval_in = new RectF(2, 2, 28, 28);
		canvas.drawOval(oval_in, paint);
		if ("red".equals(getColor())) {
			paint.setColor(Color.RED);
		} else {
			paint.setColor(Color.BLACK);
		}
		paint.setTextSize(20);
		canvas.drawText(getName(), 5, 22, paint);
		super.onDraw(canvas);
	}

	public void moveTo(int position_x, int position_y) {
		// 当移动的目标位置没有同种颜色的棋子 则可以移动

		int[] position = { position_x, position_y };

		for (int i = 0; i < GloableValues.blackChessList.size(); i++) {
			int[] chessPosition = GloableValues.blackChessList.get(i).getPosition();
			if (position[0] == chessPosition[0] && position[1] == chessPosition[1]) {
				if ("black".equals(getColor())) {
					return;
				}else{
					GloableValues.blackChessList.remove(i);
				}
			}
		}

		for (int i = 0; i < GloableValues.redChessList.size(); i++) {
			int[] chessPosition = GloableValues.redChessList.get(i).getPosition();
			if (position[0] == chessPosition[0] && position[1] == chessPosition[1]) {
				if ("red".equals(getColor())) {
					return;
				}else{
					GloableValues.redChessList.remove(i);
				}
			}
		}

		setPosition(position);
	}

}
