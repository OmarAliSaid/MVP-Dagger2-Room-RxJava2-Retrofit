package com.omar.mvp.di.component;

import android.app.Application;

import com.omar.mvp.MvpExampleApp;
import com.omar.mvp.di.builder.ActivityBuilder;
import com.omar.mvp.di.module.ApiServiceModule;
import com.omar.mvp.di.module.ApplicationModule;
import com.omar.mvp.di.module.OkHttpClientModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {ApplicationModule.class , ActivityBuilder.class , AndroidInjectionModule.class})
public interface ApplicationComponent {

    void inject(MvpExampleApp daggerExampleApp);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        Builder AppModule(ApplicationModule module);

        Builder ApiService(ApiServiceModule module);

        Builder httpModule(OkHttpClientModule module);

        ApplicationComponent build();
    }
}
