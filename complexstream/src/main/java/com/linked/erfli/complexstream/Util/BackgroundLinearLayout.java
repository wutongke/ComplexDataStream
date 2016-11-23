package com.linked.erfli.complexstream.Util;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class BackgroundLinearLayout extends LinearLayout {
    private static final String TAG = "TouchTracking";

    private OnPress mListener;

    public BackgroundLinearLayout(Context context) {
        super(context);
    }

    public BackgroundLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BackgroundLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setOnPressListener(OnPress listener) {
        mListener = listener;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_UP) {
            if (mListener != null) {
                mListener.onStatePress(false);
            }
        } else if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            if (mListener != null) {
                mListener.onStatePress(true);
            }
        } else if (ev.getAction() == MotionEvent.ACTION_CANCEL) {
            if (mListener != null) {
                mListener.onStatePress(false);
            }
        }
        super.dispatchTouchEvent(ev);
        return true;
    }

    public interface OnPress {
        public void onStatePress(boolean pressed);
    }
}