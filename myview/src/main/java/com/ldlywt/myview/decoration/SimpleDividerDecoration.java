package com.ldlywt.myview.decoration;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * @author: lex
 * @Email: ldlywt@gmail.com
 * @Time: 2017/12/8 15:18
 * @Description: 超简单的recycleview分割线，学习所用
 * http://www.jianshu.com/p/b46a4ff7c10a
 */

public class SimpleDividerDecoration extends RecyclerView.ItemDecoration {

    private int dividerHeight;
    private Paint dividerPaint;

    @SuppressLint("ResourceAsColor")
    public SimpleDividerDecoration(Context context, @ColorRes int color, @DimenRes int dividerHeight) {
        dividerPaint = new Paint();
        dividerPaint.setColor(ContextCompat.getColor(context, color));
        dividerHeight = context.getResources().getDimensionPixelSize(dividerHeight);
    }


    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.bottom = dividerHeight;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int childCount = parent.getChildCount();
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();

        for (int i = 0; i < childCount - 1; i++) {
            View view = parent.getChildAt(i);
            float top = view.getBottom();
            float bottom = view.getBottom() + dividerHeight;
            c.drawRect(left, top, right, bottom, dividerPaint);
        }
    }
}
