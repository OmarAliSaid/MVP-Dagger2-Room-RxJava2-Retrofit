package com.omar.daggarexample.ui.base;

/**
 * Created by Omar on 3/29/2018.
 */

public interface BaseMvpView {

    void onError(String error);

    void showLoading();

    void hideLoading();

    boolean isNetworkConnected();

}
