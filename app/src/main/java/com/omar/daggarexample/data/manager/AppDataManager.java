package com.omar.daggarexample.data.manager;

import android.database.Observable;

import com.omar.daggarexample.data.network.ApiService;
import com.omar.daggarexample.data.prefs.PreferenceKeys;
import com.omar.daggarexample.data.prefs.SharedPreferenceUtils;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 *
 * this class built to provide single point of access to application data sources ( shared Pref - Api Service )
 *
 */
@Singleton
public class AppDataManager implements DataManager {

    ApiService mApiService;
    SharedPreferenceUtils mSharedPreferenceUtils;

    @Inject
    public AppDataManager(ApiService mApiService, SharedPreferenceUtils mSharedPreferenceUtils) {
        this.mApiService = mApiService;
        this.mSharedPreferenceUtils = mSharedPreferenceUtils;
    }

    @Override
    public Observable<Object> getUsers() {
        return mApiService.getUsers();
    }

    @Override
    public void setCurrentUserID(int userID) {
        mSharedPreferenceUtils.setValue(PreferenceKeys.KEY_USER_ID , userID);
    }

    @Override
    public void setUserAsLoggedOut() {
        mSharedPreferenceUtils.setUserAsLoggedOut();
    }

    @Override
    public int getUserID() {
        return mSharedPreferenceUtils.getUserID();
    }
}
