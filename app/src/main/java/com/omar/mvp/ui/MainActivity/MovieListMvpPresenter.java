package com.omar.mvp.ui.MainActivity;

import com.omar.mvp.ui.Base.BaseMvpPresenter;
import com.omar.mvp.ui.Base.BaseMvpView;

public interface MovieListMvpPresenter<V extends BaseMvpView> extends BaseMvpPresenter<V>{

  void fetchMoviesSortedBy(String sort_type);
}
