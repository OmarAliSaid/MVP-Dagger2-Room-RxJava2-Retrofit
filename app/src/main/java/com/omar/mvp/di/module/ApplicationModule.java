package com.omar.mvp.di.module;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.omar.mvp.data.AppDataManager;
import com.omar.mvp.data.DataManager;
import com.omar.mvp.data.local.db.AppDatabase;
import com.omar.mvp.data.local.db.AppDbHelper;
import com.omar.mvp.data.local.db.DbHelper;
import com.omar.mvp.data.local.prefs.PreferenceHelper;
import com.omar.mvp.data.local.prefs.SharedPreferenceUtils;
import com.omar.mvp.utils.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module(includes = ApiServiceModule.class)
public class ApplicationModule {

    @Provides
    @Singleton
    AppDatabase provideAppDatabase(Application context) {
        return Room.databaseBuilder(context, AppDatabase.class, AppConstants.DB_NAME).build();
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


    @Provides
    @Singleton
    DbHelper provideDatabaseHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }


    @Provides
    @Singleton
    CompositeDisposable provideDisposable(){
        return new CompositeDisposable();
    }
}
