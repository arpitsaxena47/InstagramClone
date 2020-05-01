package com.arpit.instagram;

import android.app.Application;

import com.parse.Parse;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("NfgpWcW3OSYmp1L1VAVvSXa9nxy2S1PF6PkuDUyO")
                // if defined
                .clientKey("NkwX4WyUZa9HMyfM4x3JX7YPOXP3qunaiXT5ZvJ1")
                .server("https://parseapi.back4app.com/")
                .build()
        );
    }
}
