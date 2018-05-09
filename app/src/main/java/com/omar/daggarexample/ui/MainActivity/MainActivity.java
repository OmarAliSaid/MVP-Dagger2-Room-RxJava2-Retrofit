package com.omar.daggarexample.ui.MainActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.omar.daggarexample.R;
import com.omar.daggarexample.ui.base.BaseActivity;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainMvpView{

    @Inject
    MainMvpPresenter<MainMvpView>mainMvpPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);

        mainMvpPresenter.onAttach(this);

        mainMvpPresenter.saveUserID(10);

        mainMvpPresenter.getUserID();
    }

    @Override
    protected void setUp() {

    }

    @Override
    public void onUserSaved() {
        Log.d("LOG : ","user saved");
    }

    @Override
    public void onUserLoaded(int userID) { Log.d("LOG : ","user loaded : "+userID); }
}
