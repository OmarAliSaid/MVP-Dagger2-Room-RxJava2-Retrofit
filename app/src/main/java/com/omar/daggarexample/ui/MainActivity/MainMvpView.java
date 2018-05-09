package com.omar.daggarexample.ui.MainActivity;

import com.omar.daggarexample.ui.base.BaseMvpView;

public interface MainMvpView extends BaseMvpView{

    void onUserSaved();

    void onUserLoaded(int userID);
}
