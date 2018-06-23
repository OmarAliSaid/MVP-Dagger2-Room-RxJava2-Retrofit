package com.omar.mvp;

import android.app.Activity;
import android.app.Application;

import com.omar.mvp.data.DataManager;
import com.omar.mvp.data.remote.ApiService;
import com.omar.mvp.di.component.ApplicationComponent;
import com.omar.mvp.di.component.DaggerApplicationComponent;
import com.omar.mvp.di.module.ApplicationModule;
import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class MvpExampleApp extends Application implements HasActivityInjector{

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }


    @Override
    public void onCreate() {
        super.onCreate();

        DaggerApplicationComponent.builder()
                .application(this)
                .build()
                .inject(this);
    }
}
