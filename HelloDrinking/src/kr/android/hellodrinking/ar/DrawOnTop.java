package kr.android.hellodrinking.ar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class DrawOnTop extends View {
	public DrawOnTop(Context context) {
		super(context);
	}
	
	public DrawOnTop(Context context, AttributeSet attributes){
		super(context, attributes);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		Paint paint = new Paint();
		paint.setStyle(Paint.Style.FILL);
		paint.setColor(Color.RED); // ?�색
		paint.setStrokeWidth(10); // ?�기 10
		canvas.drawText("Test Text", 10, 10, paint); // ?�스???�시
		canvas.drawLine(50, 50, 200, 200, paint); // ?�인그리�?
		super.onDraw(canvas);
	}
}