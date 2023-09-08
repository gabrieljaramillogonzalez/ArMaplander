# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /Users/inmovimapa/Documents/Desarrollo/android-sdk-macosx/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

## LIBRARY: OkHttp
-keep class com.squareup.okhttp.** { *; }
-keep interface com.squareup.okhttp.** { *; }
-dontwarn com.squareup.okhttp.**
-dontwarn okio.**

## LIBRARY: GSON
-keep class com.google.gson.** { *; }
-keep class com.google.inject.** { *; }
-dontwarn com.google.gson.**

## ButterKnife
-dontwarn butterknife.internal.**
-keep class **$$ViewInjector { *; }
-keepnames class * { @butterknife.InjectView *;}

#-keep class com.google.android.gms.maps.GoogleMap { *; }
-keep class com.itextpdf.awt.PdfGraphics2D { *; }
-keep class org.spongycastle.** { *; }
-dontwarn org.spongycastle.**
-keep class com.itextpdf.awt.PolylineShape { *; }
#-keep class com.itextpdf.awt.PolylineShapeIterator { *; }

-keep class net.rehacktive.waspdb.** { *; }
-keep class com.esotericsoftware.kryo.** { *; }
-dontwarn org.apache.commons.**
-keep class org.apache.http.** { *; }
-dontwarn org.apache.http.**
-keepattributes LineNumberTable,SourceFile