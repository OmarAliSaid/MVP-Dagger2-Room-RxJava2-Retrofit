package com.omar.mvp.ui.Base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import com.omar.mvp.utils.NetworkUtils;
import butterknife.Unbinder;
import dagger.android.AndroidInjection;


/**
 * Created by Omar on 3/29/2018.
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseMvpView{

    private ProgressDialog mProgressDialog;


    // using Unbinder to unbind views on activity destroy to free memory
    private Unbinder mUnBinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);
    }


    @Override
    public void onError(String error) {
        if(mProgressDialog!=null)
            mProgressDialog.hide();
        showSnackBar(error);
    }


    @Override
    public void showLoading() {
        if(mProgressDialog == null){
            mProgressDialog = new ProgressDialog(this);
        }
        mProgressDialog.show();
    }


    @Override
    public void hideLoading() {
        if(mProgressDialog!=null)
            mProgressDialog.dismiss();
    }


    @Override
    public boolean isNetworkConnected() {
        return NetworkUtils.isNetworkConnected(getApplicationContext());
    }


    public void showSnackBar(String message) {
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content),
                message, Snackbar.LENGTH_SHORT);
        View sbView = snackbar.getView();
        TextView textView = sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(ContextCompat.getColor(this, android.R.color.white));
        snackbar.show();
    }


    public void setUnBinder(Unbinder unBinder) {
        mUnBinder = unBinder;
    }

    @Override
    protected void onDestroy() {

        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
        super.onDestroy();
    }

}
