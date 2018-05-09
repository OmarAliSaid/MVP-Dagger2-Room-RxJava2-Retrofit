package com.omar.daggarexample.ui.MainActivity;

import com.omar.daggarexample.ui.base.BaseMvpPresenter;
import com.omar.daggarexample.ui.base.BaseMvpView;

public interface MainMvpPresenter <V extends BaseMvpView> extends BaseMvpPresenter<V>{

    void saveUserID(int userID);

    void getUserID();
}
