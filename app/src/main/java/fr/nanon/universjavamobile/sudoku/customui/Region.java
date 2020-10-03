package fr.nanon.universjavamobile.sudoku.customui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TableLayout;
import android.widget.TableRow;

/**
 * TODO: document your custom view class.
 */
public class Region extends TableLayout {
    private String mExampleString; // TODO: use a default from R.string...
    private int mExampleColor = Color.RED; // TODO: use a default from R.color...
    private float mExampleDimension = 0; // TODO: use a default from R.dimen...
    private Drawable mExampleDrawable;

    private TextPaint mTextPaint;
    private float mTextWidth;
    private float mTextHeight;

    TableRow row1;
    Box row1Box1;
    Box row1Box2;
    Box row1Box3;

    TableRow row2;
    Box row2Box1;
    Box row2Box2;
    Box row2Box3;

    TableRow row3;
    Box row3Box1;
    Box row3Box2;
    Box row3Box3;

    public Region(Context context) {
        super(context);
        init(null, 0);
    }

    public Region(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    private void init(AttributeSet attrs, int defStyle) {
        row1 = new TableRow(getContext());
        row1Box1 = new Box(getContext());
        row1Box2 = new Box(getContext());
        row1Box3 = new Box(getContext());

        row1.addView(row1Box1);
        row1.addView(row1Box2);
        row1.addView(row1Box3);

        //---------------------------------
        row2 = new TableRow(getContext());
        row2Box1 = new Box(getContext());
        row2Box2 = new Box(getContext());
        row2Box3 = new Box(getContext());

        row2.addView(row2Box1);
        row2.addView(row2Box2);
        row2.addView(row2Box3);

        //---------------------------------
        row3 = new TableRow(getContext());
        row3Box1 = new Box(getContext());
        row3Box2 = new Box(getContext());
        row3Box3 = new Box(getContext());

        row3.addView(row3Box1);
        row3.addView(row3Box2);
        row3.addView(row3Box3);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        row1.setMinimumHeight(50);
        row2.setMinimumHeight(50);
        row3.setMinimumHeight(50);


    }
}
