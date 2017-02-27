package com.mika_tk.android.spatula;

/**
 * Created by mturki on 12/12/2016.
 */

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by mturki on 04/01/16.
 */
@Retention(RUNTIME) @Target(FIELD)
public @interface BindTypeface {
    int value() default FontMapper.regular;
}
