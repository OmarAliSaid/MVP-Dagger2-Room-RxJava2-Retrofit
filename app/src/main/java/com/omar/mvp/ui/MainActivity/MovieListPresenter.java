package com.omar.mvp.ui.MainActivity;

import android.util.Log;

import com.omar.mvp.data.DataManager;
import com.omar.mvp.data.model.Movie;
import com.omar.mvp.ui.Base.BaseMvpView;
import com.omar.mvp.ui.Base.BasePresenter;
import com.omar.mvp.utils.AppConstants;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class MovieListPresenter<V extends BaseMvpView> extends BasePresenter<V> implements MovieListMvpPresenter<V> {

    private static final String TAG = MovieListPresenter.class.getSimpleName();

    @Inject
    public MovieListPresenter(DataManager mDataManager, CompositeDisposable mCompositeDisposable) {
        super(mDataManager, mCompositeDisposable);
    }


    /**
     * fetch movies from server OR local database based on sort type
     *
     * if internet available then load movies from server and update database
     * else fetch movies from database
     *
     * @param sort_type
     */
    @Override
    public void fetchMoviesSortedBy(String sort_type) {
        if(getMvpView().isNetworkConnected())
            fetchMoviesFromServer(sort_type);
        else
            fetchMoviesFromDB(sort_type);
    }


    /**
     * fetch movies from local database
     *
     * @param sort_by
     */
    private void fetchMoviesFromDB(String sort_by){
        getCompositeDisposable().add(getDataManager().loadAllMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(moviesList->{
                    // notify view about the loaded data
                    ((MovieListMvpView)getMvpView()).onMoviesLoaded(new ArrayList<>(moviesList));
                } , throwable -> {
                    // notify view about the error msg
                    getMvpView().onError(throwable.getMessage());
                }));
    }



    /**
     * fetch movies from remote server
     *
     * @param sort_by
     */
    private void fetchMoviesFromServer(String sort_by){
        // show loading
        getMvpView().showLoading();

        getCompositeDisposable().add(getDataManager().fetchMoviesSortedBy(AppConstants.API_KEY , sort_by)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response->{
                    // hide loading dialog
                    getMvpView().hideLoading();

                    // update movies in db
                    insertMovies(response.getResult());

                    // notify view about the new loaded data
                    ((MovieListMvpView)getMvpView()).onMoviesLoaded(new ArrayList<>(response.getResult()));

                } , throwable -> {
                    // hide loading dialog
                   getMvpView().hideLoading();

                    // notify subscribers about the error msg
                    getMvpView().onError(throwable.getMessage());
                }));
    }


    /**
     * insert movies in database
     *
     * @param movies
     */
    private void insertMovies(List<Movie> movies){
        getCompositeDisposable().add(getDataManager().saveMovies(movies)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response->{
                    Log.d(TAG , movies.size()+" movies inserted in db");
                } , throwable -> {
                    Log.d(TAG , "error inserting movies : " +throwable.getMessage());
                }));
    }
}
