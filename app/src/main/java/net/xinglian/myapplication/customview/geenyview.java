package net.xinglian.myapplication.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import net.xinglian.myapplication.R;

/**
 * Created by Administrator on 2018/2/13.
 */

public class geenyview extends View {

    private String titleText;
    private int titleColor;
    private int titleSize;

    private Rect bound;
    private Paint paint;

    public geenyview(Context context) {
        super(context);
    }

    public geenyview(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.geenyview,0,0);

        int count = typedArray.getIndexCount();

        for (int i = 0; i < count; i++){
            int attr = typedArray.getIndex(i);
            switch (attr){
                case R.styleable.geenyview_Geeny_title :
                    this.titleText = typedArray.getString(attr);
                    break;
                case R.styleable.geenyview_Geeny_titleTextColor :
                    this.titleColor = typedArray.getColor(attr, Color.BLACK);
                    break;
                case R.styleable.geenyview_Geeny_titleTextSize :
                    this.titleSize = typedArray.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(
                            TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));
                    break;
            }
        }
        typedArray.recycle();

        this.paint = new Paint();

        paint.setTextSize(this.titleSize);

        this.bound = new Rect();
        paint.getTextBounds(this.titleText, 0, this.titleText.length(), this.bound);


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        this.paint.setColor(Color.YELLOW);
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), this.paint);

        this.paint.setColor(this.titleColor);
        canvas.drawText(this.titleText, getWidth() / 2 - this.bound.width() / 2
                , getHeight() / 2 + this.bound.height() / 2, this.paint);

        Paint paint1 = new Paint();
        paint1.setColor(Color.BLACK);

        RectF rectF = new RectF(12, 323, 323,33);
        canvas.drawOval(rectF,paint1);
    }
}
