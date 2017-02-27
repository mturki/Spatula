package com.mika_tk.android.spatula;

import android.support.annotation.NonNull;

/**
 * Created by mturki on 27/02/2017.
 */

/**
 * Implements this interface to map the ttf file name to the FontMapper default field names.
 * for now, you have to add the file extension. For example, you have to return "HelvNeue75_W1G.ttf" if you want to use the HelvNeue75_W1G font file located in your assets/fonts/ folder
 */
@SuppressWarnings("unused")
public interface FontMapper {
    int thin = 1;
    int light = 2;
    int regular = 3;
    int semi_bold = 4;
    int bold = 5;
    int italic = 6;

    /**
     * get the font file name for the given font index.
     */
    @NonNull
    String getFontName(int fontIndex);
}
