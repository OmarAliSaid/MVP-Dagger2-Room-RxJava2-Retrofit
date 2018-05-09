package com.omar.daggarexample.di.module;

import android.content.Context;

import com.omar.daggarexample.data.manager.AppDataManager;
import com.omar.daggarexample.data.manager.DataManager;
import com.omar.daggarexample.data.network.ApiService;
import com.omar.daggarexample.data.prefs.PreferenceHelper;
import com.omar.daggarexample.data.prefs.SharedPreferenceUtils;
import com.omar.daggarexample.di.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    Context context;

    public ApplicationModule(Context context) {
        this.context = context;
    }


    @ApplicationContext
    @Provides
    public Context getContext(){
        return context.getApplicationContext();
    }


    @Provides
    @Singleton
    PreferenceHelper providePreferencesHelper(SharedPreferenceUtils appPreferencesHelper) {
        return appPreferencesHelper;
    }


    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

}
