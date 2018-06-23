package com.omar.mvp.data.remote;

import com.omar.mvp.data.remote.api.MoviesResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("3/discover/movie")
    io.reactivex.Observable<MoviesResponse> fetchMoviesSortedBy(
            @Query("api_key")String api_key
            , @Query("sorted_by")String sorted_by);
}
