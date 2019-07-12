package com.alin.grafuri;

import android.content.Context;
import android.widget.Toast;

public abstract class Utils {

    public static final String chapterExtra = "ExtraChapter";
    public static final String lessonExtra = "LessonNumber";

    public static final String theorem = "Theorem";
    public static final String sentence = "Sentence";

    public static void showMessage(Context context, String message, boolean isLong) {
        Toast.makeText(context, message, (isLong ? Toast.LENGTH_SHORT : Toast.LENGTH_SHORT)).show();
    }

}
