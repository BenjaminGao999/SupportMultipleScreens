package com.gaos.supportmultiplescreens;

import android.graphics.Point;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTextSize();
        setViewWidth();
        getDpi();
        compareDrawableWithTextScaleFactor();
    }

    private void setTextSize() {
        TextView textView = (TextView) findViewById(R.id.tv);
        float density = getResources().getDisplayMetrics().density;
        float textSize = 18 * density;
        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
    }

    private void setViewWidth() {
        View viewMy = findViewById(R.id.view_my);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewMy.getLayoutParams();
        layoutParams.width = (int) (getResources().getDisplayMetrics().widthPixels/2.0f);
//        layoutParams.width = 540;
        viewMy.setLayoutParams(layoutParams);
    }

    private void getDpi() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        Log.i(TAG, "setTextSize: width = " + displayMetrics.widthPixels + "px");
        Log.i(TAG, "setTextSize: height = " + displayMetrics.heightPixels + "px");
        Log.i(TAG, "setTextSize: densitydpi = " + displayMetrics.densityDpi);
        Log.i(TAG, "setTextSize: density = " + displayMetrics.density);
        Log.i(TAG, "setTextSize: xdpi = " + displayMetrics.xdpi);
        Log.i(TAG, "setTextSize: ydpi = " + displayMetrics.ydpi);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            Point outSize = new Point();
            getWindowManager().getDefaultDisplay().getRealSize(outSize);
            Log.i(TAG, "getDpi: outSizeX = " + outSize.x + "; outsizeY = " + outSize.y);
            DisplayMetrics outMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getRealMetrics(outMetrics);
            Log.i(TAG, "getDpi: realDensity = " + outMetrics.densityDpi);
            Log.i(TAG, "getDpi: realXdpi = " + outMetrics.xdpi);
            Log.i(TAG, "getDpi: realYdpi = " + outMetrics.ydpi);
            Log.i(TAG, "getDpi: realXpx= " + outMetrics.widthPixels);
            Log.i(TAG, "getDpi: realYpx = " + outMetrics.heightPixels);
        }
    }

    private void compareDrawableWithTextScaleFactor() {
        ImageView ivSophie = (ImageView) findViewById(R.id.iv_sophie);
        TextView tvSophie = (TextView) findViewById(R.id.tv_sophie);
        ivSophie.measure(0, 0);
        Log.i(TAG, "compareDrawableWithTextScaleFactor: imageview weidth = " + ivSophie.getMeasuredWidth());
        Log.i(TAG, "compareDrawableWithTextScaleFactor: imageview height = " + ivSophie.getMeasuredHeight());
        float textSize = tvSophie.getTextSize();
        Log.i(TAG, "compareDrawableWithTextScaleFactor: textsize = " + textSize);
        tvSophie.measure(0, 0);
        Log.i(TAG, "compareDrawableWithTextScaleFactor: textviewHeight = " + tvSophie.getMeasuredHeight());
    }
}
