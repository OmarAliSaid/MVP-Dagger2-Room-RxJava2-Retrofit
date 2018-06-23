package com.omar.mvp.data.local.db;


import com.omar.mvp.data.model.Movie;

import java.util.List;

import io.reactivex.Observable;

public interface DbHelper {

    Observable<Boolean> saveMovies(List<Movie> movies);

    Observable<List<Movie>> loadAllMovies();

}
