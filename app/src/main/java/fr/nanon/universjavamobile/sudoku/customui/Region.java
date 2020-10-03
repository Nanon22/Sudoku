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

    public Region(Context context) {
        super(context);
        init(null, 0);
    }

    public Region(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    private void init(AttributeSet attrs, int defStyle) {

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
