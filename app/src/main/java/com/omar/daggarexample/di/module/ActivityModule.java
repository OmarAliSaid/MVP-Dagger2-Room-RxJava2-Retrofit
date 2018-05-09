package com.omar.daggarexample.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.omar.daggarexample.di.ActivityContext;
import com.omar.daggarexample.ui.MainActivity.MainMvpPresenter;
import com.omar.daggarexample.ui.MainActivity.MainMvpView;
import com.omar.daggarexample.ui.MainActivity.MainPresenter;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class ActivityModule {


    AppCompatActivity context;


    public ActivityModule(AppCompatActivity context) {
        this.context = context;
    }


    @ActivityContext
    @Provides
    public Context getContext(){
        return context;
    }


    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }


    @Provides
    MainMvpPresenter<MainMvpView> provideMainPresenter(
            MainPresenter<MainMvpView> presenter) {
        return presenter;
    }

}
