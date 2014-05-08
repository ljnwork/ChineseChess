package com.lgh.chess.ui;

import com.lgh.chess.R;
import com.lgh.chess.util.DensityUtil;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class ChessBgView extends View {

	public ChessBgView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public ChessBgView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public ChessBgView(Context context) {
		super(context);
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		setMeasuredDimension(300, 350);
	}

	@Override
	protected void onDraw(Canvas canvas) {
//		Paint paint = new Paint();
//		Bitmap chessBg = BitmapFactory.decodeResource(getResources(), R.drawable.qipan);
//		Matrix matrix = new Matrix();
//		matrix.setScale(1.5f, 1.5f); 
//		
//		canvas.drawBitmap(chessBg, matrix, paint);

		super.onDraw(canvas);
	}

}
