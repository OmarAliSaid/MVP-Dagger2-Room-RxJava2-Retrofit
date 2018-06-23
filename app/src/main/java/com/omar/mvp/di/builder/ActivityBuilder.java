package com.omar.mvp.di.builder;

import com.omar.mvp.ui.MainActivity.MovieListActivity;
import com.omar.mvp.ui.MainActivity.MovieListModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = MovieListModule.class)
    abstract MovieListActivity bindMovieListActivity();
}

