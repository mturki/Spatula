Spatula
============
[ ![Download](https://api.bintray.com/packages/mturki/android/spatula/images/download.svg) ](https://bintray.com/mturki/android/spatula/_latestVersion)

A small/modest android library to bind fonts to common android text Views via annotations processing like (lowly) [butterknife][1]. You can easely apply Typefaces on Views that extends `TextView` like `android.widget.Button` or `android.widget.ToggleButton` or that extends android support design `TextInputLayout`.


* Eliminates `Typeface.createFromAsset` and `view.setTypeface` by using by using `@BindTypeface` on fields.
* Work fine with butterknife fields binding.
* TypeFace Caching.

```java
class ExampleActivity extends Activity {

@BindView(R.id.label)
@BindTypeface(Font.bold)
EditText label;

@BindView(R.id.user)
@BindTypeface //bind default font
EditText username;

@BindView(R.id.pass)
@BindTypeface(Font.myCustomTypeFace)
EditText password;

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.simple_activity);
    ButterKnife.bind(this);
    Spatulla.bindTypefaces(this);
    // TODO Use fields...
  }
}
```
Download
--------

Add to your project scope `build.gradle` file (jcenter repository is comming)
```groovy
maven {
        url  "http://dl.bintray.com/mturki/android" 
    }
```

Add to your application scope `build.gradle` file
```groovy
dependencies {
  compile 'com.mika_tk.android.spatula:spatula:1.0.0-alpha3'
}
```

Configuration
-------

Copy your fonts to the `assets/fonts/` folder

Create a new class that implements `FontMapper`
You have to return the file name for each font if. Do not forget to fill in the file extension!

```java
public class MyFonts implements FontMapper {
 int myCustomTypeFace = 1

@Override
    @NonNull
    public String getFontName(int fontIndex) {
        switch (fontIndex) {
            case bold:
                return "HelvNeue75_W1G.ttf";
            (...)
            case myCustomFont:
                return "HelvNeue35_W1G.ttf";

            default:
            case regular:
                return "HelvNeue55_W1G.ttf";
        }
```

In your custom Application class, init the Spatula library :
```java
public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
                Spatula.with(new MyFonts());
    }

}

```

Or Add a `meta-data` element to the `AndroidManifest.xml` `application` element :
```xml
<application android:label="@string/app_name" ...>
    ...
        <meta-data
            android:name="com.mika_tk.android.spatula.Mapper"
            android:value="your.custom.font.mapper.class" />
    ...
</application>
```

Usage
-------
You can anotate your View fields with the '@BindTypeface' annotation.

```java
//without font index, the binder use the default font 'FontMapper.regular'.
@BindTypeface
TextView textView01;

// The binder use the given font.
@BindTypeface(FontMapper.bold) //or '@BindTypeface(MyMapper.bold)'
TextView textView02;

// The binder use your custom font name returned by your font mapper implementation. Remember to not use negative values for your custom fields.
@BindTypeface(MyMapper.myCustomTypeFace)
TextView textView03;
```

Call `Spatula.(objectToBind)` after any `.findViewById(...)` or `ButterKnife.bind(this)`.

Bonux
-------
You can use some bonus functions to manually apply fonts to your text views:

```java
// apply font to a TextView
Spatula.apply(MyMapper.bold, myTextView);

// apply default font to a TextView
Spatula.apply(myTextView);

// apply font to several views
Spatula.apply(MyMapper.bold, myTextView01, myTextView02);

// apply default font to several views
Spatula.apply(myTextView01, myTextView02);
```

License
-------

    Copyright 2017 Mikhael Turki

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

 [1]: http://jakewharton.github.com/butterknife/

