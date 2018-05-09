package com.omar.daggarexample.di.component;

import android.app.Application;
import android.content.Context;

import com.omar.daggarexample.DaggerExampleApp;
import com.omar.daggarexample.data.manager.DataManager;
import com.omar.daggarexample.di.ApplicationContext;
import com.omar.daggarexample.di.module.ApiServiceModule;
import com.omar.daggarexample.di.module.PicassoModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApiServiceModule.class , PicassoModule.class})
public interface ApplicationComponent {

    void inject(DaggerExampleApp daggerExampleApp);

    @ApplicationContext
    Context context();


    DataManager getDataManager();
}
