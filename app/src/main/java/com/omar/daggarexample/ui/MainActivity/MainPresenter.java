package com.omar.daggarexample.ui.MainActivity;

import com.omar.daggarexample.data.manager.DataManager;
import com.omar.daggarexample.ui.base.BaseMvpView;
import com.omar.daggarexample.ui.base.BasePresenter;
import javax.inject.Inject;
import io.reactivex.disposables.CompositeDisposable;

public class MainPresenter<V extends BaseMvpView> extends BasePresenter<V> implements MainMvpPresenter<V> {

    @Inject
    public MainPresenter(DataManager mDataManager, CompositeDisposable mCompositeDisposable) {
        super(mDataManager, mCompositeDisposable);
    }

    @Override
    public void saveUserID(int userID) {
        getDataManager().setCurrentUserID(userID);
        ((MainMvpView)getMvpView()).onUserSaved();
    }

    @Override
    public void getUserID() {
        ((MainMvpView)getMvpView()).onUserLoaded(getDataManager().getUserID());
    }
}
