package com.omar.daggarexample.data.network;

import android.database.Observable;

import retrofit2.http.GET;

public interface ApiService {

    @GET("")
    Observable<Object> getUsers();

}
