package com.omar.mvp.data;


import com.omar.mvp.data.local.db.DbHelper;
import com.omar.mvp.data.model.Movie;
import com.omar.mvp.data.remote.ApiService;
import com.omar.mvp.data.local.prefs.SharedPreferenceUtils;
import com.omar.mvp.data.remote.api.MoviesResponse;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 *
 * this class built to provide single point of access to application data sources ( shared Pref - Api Service )
 *
 */
@Singleton
public class AppDataManager implements DataManager {

    ApiService mApiService;
    DbHelper mDbHelper;
    SharedPreferenceUtils mSharedPreferenceUtils;

    @Inject
    public AppDataManager(ApiService mApiService,DbHelper mDbHelper , SharedPreferenceUtils mSharedPreferenceUtils) {
        this.mApiService = mApiService;
        this.mSharedPreferenceUtils = mSharedPreferenceUtils;
        this.mDbHelper = mDbHelper;
    }


    /****************************   API METHODS  **************************************/


    /**
     * fetch movies from server by selected sort by value ( popular - top rated - .... )
     *
     * @param api_key
     * @param sorted_by
     * @return
     */
    @Override
    public Observable<MoviesResponse> fetchMoviesSortedBy(String api_key, String sorted_by) {
        return mApiService.fetchMoviesSortedBy(api_key , sorted_by);
    }



    /******************************   DATABASE METHODS  *************************************/


    /**
     * insert all movies in database
     *
     * @param movies
     * @return
     */
    @Override
    public Observable<Boolean> saveMovies(List<Movie> movies) {
        return mDbHelper.saveMovies(movies);
    }


    /**
     * select all movies from database
     *
     * @return
     */
    @Override
    public Observable<List<Movie>> loadAllMovies() {
        return mDbHelper.loadAllMovies();
    }


}
