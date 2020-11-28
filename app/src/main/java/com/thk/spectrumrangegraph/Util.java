package com.thk.spectrumrangegraph;

import android.content.res.Resources;

public class Util {
    public static int dpToPx(Resources resources, float dp) {
        float density = resources.getDisplayMetrics().density;

        return (int)(dp * density + 0.5);
    }

    public static int pxToDp(Resources resources, float px) {
        float dentsity = resources.getDisplayMetrics().density;

        return (int)(px / dentsity + 0.5);
    }
}
