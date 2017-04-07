package com.gaos.supportmultiplescreens;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTextSize();
        getImageSize();
    }


    private void setTextSize() {
//        TextView textView = (TextView) findViewById(R.id.tv);
//        float textSize = getResources().getDisplayMetrics().widthPixels * 0.05f;
//        Log.i(TAG, "setTextSize: textsize = " + textSize);
//        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
        Log.i(TAG, "setTextSize: 18sp = " + getResources().getDimension(R.dimen.textsize) + "px");

        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        Log.i(TAG, "setTextSize: width = " + displayMetrics.widthPixels + "px");
        Log.i(TAG, "setTextSize: height = " + displayMetrics.heightPixels + "px");
        Log.i(TAG, "setTextSize: densitydpi = " + displayMetrics.densityDpi);
        Log.i(TAG, "setTextSize: density = " + displayMetrics.density);
        Log.i(TAG, "setTextSize: real density dpi = " + Math.sqrt(Math.pow(displayMetrics.heightPixels, 2) + Math.pow(displayMetrics.heightPixels, 2)) / 7.0f);
    }

    /**
     * ①1080*1920 420dpi
     * 04-07 08:55:16.083 7144-7144/com.gaos.supportmultiplescreens I/MainActivity: getImageSize: height = 257
     * 04-07 08:55:16.083 7144-7144/com.gaos.supportmultiplescreens I/MainActivity: getImageSize: width = 168
     * <p>
     * ②768*1280 xhdpi
     * 04-07 08:59:59.580 2721-2721/? I/MainActivity: getImageSize: height = 171
     * 04-07 08:59:59.580 2721-2721/? I/MainActivity: getImageSize: width = 112
     * <p>
     * ③ 原始位图尺寸 height = 171 , weight = 112
     */
    private void getImageSize() {
        ImageView imageView = (ImageView) findViewById(R.id.img_sophie);
        imageView.measure(0, 0);
        int height = imageView.getMeasuredHeight();
        int width = imageView.getMeasuredWidth();
        Log.i(TAG, "getImageSize: height = " + height);
        Log.i(TAG, "getImageSize: width = " + width);
    }
}
