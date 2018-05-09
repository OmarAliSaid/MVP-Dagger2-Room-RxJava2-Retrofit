package com.omar.daggarexample.di.component;

import com.omar.daggarexample.di.PerActivity;
import com.omar.daggarexample.di.module.ActivityModule;
import com.omar.daggarexample.ui.MainActivity.MainActivity;

import dagger.Component;

@PerActivity
@Component(modules = ActivityModule.class , dependencies = ApplicationComponent.class)
public interface ActivityComponent {

    void inject(MainActivity activity);

}
