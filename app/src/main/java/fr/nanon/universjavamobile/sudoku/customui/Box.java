package fr.nanon.universjavamobile.sudoku.customui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.widget.AppCompatEditText;

import fr.nanon.universjavamobile.sudoku.R;

/**
 * TODO: document your custom view class.
 */
public class Box extends AppCompatEditText {

    public int value;
    public int position_X;
    public int position_Y;
    public boolean hidden;

    public Box(Context context) {
        super(context);
        init(null, 0);
    }

    public Box(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public Box(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        this.setGravity(Gravity.CENTER);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
