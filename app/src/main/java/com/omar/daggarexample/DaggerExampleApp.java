package com.omar.daggarexample;

import android.app.Application;

import com.omar.daggarexample.data.manager.DataManager;
import com.omar.daggarexample.data.network.ApiService;
import com.omar.daggarexample.di.component.ApplicationComponent;
import com.omar.daggarexample.di.component.DaggerApplicationComponent;
import com.omar.daggarexample.di.module.ApplicationModule;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

public class DaggerExampleApp extends Application {

    @Inject
    Picasso picasso;

    @Inject
    ApiService apiService;

    @Inject
    DataManager mDataManager;

    ApplicationComponent mApplicationComponent;


    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();

        mApplicationComponent.inject(this);
    }


    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}
