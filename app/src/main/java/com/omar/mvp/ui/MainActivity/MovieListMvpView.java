package com.omar.mvp.ui.MainActivity;

import com.omar.mvp.data.model.Movie;
import com.omar.mvp.ui.Base.BaseMvpView;

import java.util.ArrayList;

public interface MovieListMvpView extends BaseMvpView{

   void onMoviesLoaded(ArrayList<Movie>movies);
}
