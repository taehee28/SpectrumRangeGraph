package com.thk.spectrumrangegraph;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

/**
 *
 * @author taehee28
 * @since 2020-11-29
 */

public class SpectrumRangeGraph extends View {

    // attributes from xml
    private int totalMinValue;
    private int totalMaxValue;
    private float rangeMinValue;
    private float rangeMaxValue;
    private float rangeAvgValue;
    private int graphHeight;
    private int textSize;
    private int textColor;
    private String warningText;
    private boolean showWarningText;

    // defaults
    private final int DEFAULT_MIN_VALUE = 0;
    private final int DEFAULT_MAX_VALUE = 100;
    private final int DEFAULT_GRAPH_HEIGHT = dpToPx(16);
    private final int DEFAULT_TEXT_SIZE = dpToPx(10);
    private final int DEFAULT_TEXT_COLOR = Color.BLACK;
    private final String DEFAULT_WARNING_TEXT = "No Data.";
    private final boolean DEFAULT_SHOW_WARNING_TEXT = false;

    private Drawable d_spectrum;
    private Drawable d_rangeBox;
    private Drawable d_avgPointer;
    private Rect rect_spectrum;
    private Rect rect_rangeBox;
    private Paint paint_text;
    
    {
        rect_spectrum = new Rect();
        rect_rangeBox = new Rect();

        paint_text = new Paint(Paint.ANTI_ALIAS_FLAG);

        d_spectrum = ResourcesCompat.getDrawable(getResources(), R.drawable.srg_bg_spectrum, null);
        d_rangeBox = ResourcesCompat.getDrawable(getResources(), R.drawable.svg_range_box, null);
        d_avgPointer = ResourcesCompat.getDrawable(getResources(), R.drawable.srg_avg_pointer, null);
    }

    public SpectrumRangeGraph(Context context) {
        this(context, null);
    }

    public SpectrumRangeGraph(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SpectrumRangeGraph(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray attributes = context.getTheme().obtainStyledAttributes(attrs, R.styleable.SpectrumRangeGraph, defStyleAttr, 0);

        totalMinValue = attributes.getInt(R.styleable.SpectrumRangeGraph_srg_totalMinValue, DEFAULT_MIN_VALUE);
        totalMaxValue = attributes.getInt(R.styleable.SpectrumRangeGraph_srg_totalMaxValue, DEFAULT_MAX_VALUE);
        rangeMinValue = attributes.getFloat(R.styleable.SpectrumRangeGraph_srg_rangeMinValue, DEFAULT_MIN_VALUE);
        rangeMaxValue = attributes.getFloat(R.styleable.SpectrumRangeGraph_srg_rangeMaxValue, DEFAULT_MAX_VALUE);
        rangeAvgValue = attributes.getFloat(R.styleable.SpectrumRangeGraph_srg_rangeAvgValue,
                (rangeMinValue + rangeMaxValue)/2 + rangeMinValue);

        graphHeight = attributes.getDimensionPixelSize(R.styleable.SpectrumRangeGraph_srg_graphHeight, DEFAULT_GRAPH_HEIGHT);
        textSize = attributes.getDimensionPixelSize(R.styleable.SpectrumRangeGraph_srg_textSize, DEFAULT_TEXT_SIZE);
        textColor = attributes.getDimensionPixelSize(R.styleable.SpectrumRangeGraph_srg_textColor, DEFAULT_TEXT_COLOR);

        // todo : String 얻는 법 찾기
        showWarningText = attributes.getBoolean(R.styleable.SpectrumRangeGraph_srg_showWarningText, DEFAULT_SHOW_WARNING_TEXT);


        paint_text.setTextSize(textSize);
        paint_text.setColor(textColor);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    private int dpToPx(float dp) {
        return Util.dpToPx(getResources(), dp);
    }

    private int pxToDp(float px) {
        return Util.pxToDp(getResources(), px);
    }
}
