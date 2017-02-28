/*
 * Copyright  2017. Mikhaël Turki
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.mika_tk.android.spatula;

import android.support.annotation.NonNull;

/**
 * Created by mturki on 27/02/2017.
 */

/**
 * Implements this interface to map the .ttf file name to the {@link TypefaceMapper} default field names.
 * for now, you have to add the file extension. For example, you have to return "HelvNeue75_W1G.ttf" if you want to use the HelvNeue75_W1G font file located in your assets/fonts/ folder.
 */
@SuppressWarnings("unused")
public interface TypefaceMapper {
    int thin = 1;
    int light = 2;
    int regular = 3;
    int semi_bold = 4;
    int bold = 5;
    int italic = 6;

    /**
     * have to return the font file name for the given .
     *
     * @param typefaceIndex font index of {@link #thin}, {@link #light}, {@link #regular}, {@link #semi_bold}, {@link #bold}, {@link #italic} or a custom one
     * @return have to return the font file name located in your assets/fonts/. ex. : "HelvNeue75_W1G.ttf"
     */
    @NonNull
    String getTypefaceName(int typefaceIndex);
}
