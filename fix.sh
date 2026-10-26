#!/bin/bash
set -e

mkdir -p app/src/main/res/drawable
mkdir -p app/src/main/res/values
rm -rf app/src/main/res/mipmap*

cat << 'XML' > app/src/main/res/values/strings.xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <string name="app_name">BackdorTheme</string>
</resources>
XML

cat << 'XML' > app/src/main/res/drawable/ic_launcher_foreground.xml
<vector xmlns:android="http://schemas.android.com/apk/res/android"
    android:width="108dp"
    android:height="108dp"
    android:viewportWidth="108"
    android:viewportHeight="108">
    <path
        android:fillColor="#000000"
        android:pathData="M0,0h108v108h-108z"/>
    <path
        android:fillColor="#E50914"
        android:pathData="M34,24h22c8.8,0 16,6.3 16,14c0,5.2 -3.1,9.7 -7.8,12c5.8,2.1 10,7.3 10,13.5c0,8.3 -7.6,15 -17.2,15h-23V24z M45,34v13h10c3.8,0 7,-2.9 7,-6.5c0,-3.6 -3.2,-6.5 -7,-6.5h-10z M45,56v14h11c4.4,0 8,-3.1 8,-7c0,-3.9 -3.6,-7 -8,-7h-11z"/>
</vector>
XML

cat << 'XML' > app/src/main/AndroidManifest.xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android">

    <uses-permission android:name="android.permission.INTERNET" />

    <application
        android:allowBackup="true"
        android:icon="@drawable/ic_launcher_foreground"
        android:roundIcon="@drawable/ic_launcher_foreground"
        android:label="@string/app_name"
        android:supportsRtl="true"
        android:theme="@style/Theme.NetflixTheme">
        <activity
            android:name=".MainActivity"
            android:exported="true"
            android:theme="@style/Theme.NetflixTheme">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>
XML

git add .
git commit -m "fix: Icon converted to drawable vector and pushed"
git push origin master
