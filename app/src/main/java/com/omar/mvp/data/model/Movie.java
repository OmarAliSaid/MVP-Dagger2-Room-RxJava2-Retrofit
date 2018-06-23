package com.omar.mvp.data.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.gson.annotations.SerializedName;
import com.omar.mvp.BR;
import com.omar.mvp.utils.AppConstants;


@Entity(tableName = "movies")
public class Movie extends BaseObservable{

    @PrimaryKey
    private int id;

    @SerializedName("poster_path")
    private String poster;

    @SerializedName("title")
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPoster(String poster) {
        this.poster = poster;
        notifyPropertyChanged(BR.poster);
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public String getPoster() {
        return AppConstants.BASE_IMAGE_URL + poster;
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    @BindingAdapter({"android:poster"})
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext())
                .load(imageUrl)
                .into(view);
    }
}
