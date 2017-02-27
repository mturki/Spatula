Spatula
============

A small android library to bind fonts to common android Views via annotations processing like (relatively speaking) butterknife.

* Eliminates 'Typeface.createFromAsset' and 'view.setTypeface' by using by using @BindTypeface on fields.
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

```groovy
dependencies {
  compile 'TODO'
}
```

Configuration
-------

Copy your fonts to the 'assets/fonts/' folder

Create a new class that implements 'FontMapper'

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
                TypefaceHelper.with(new MyFonts());
    }

}

```

Or Add a `meta-data` element to the `AndroidManifest.xml` `application` element :
```xml
<application android:label="@string/app_name" ...>
    ...
        <meta-data
            android:name="com.mika_tk.android.spatula.FontMapper"
            android:value="your.custom.font.mapper.class" />
    ...
</application>
```

Usage
-------


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

