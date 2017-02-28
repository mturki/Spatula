

-keepattributes InnerClasses
-keepattributes EnclosingMethod

# typeface annotations
-keep class com.mika_tk.android.spatula.** { *; }

 # keeps all fields and Constructors with @BindTypeface
 -keepclassmembers,allowobfuscation class * {
    @com.mika_tk.android.spatula.BindTypeface <fields>;
    @com.mika_tk.android.spatula.BindTypeface <init>(...);
 }

#Pour supprimer les logs lors de la compilation
-assumenosideeffects class android.util.Log {
    public static int v(...);
    public static int d(...);
    #public static int i(...);
    #public static int w(...);
    #public static int e(...);
    public static int wtf(...);
}

