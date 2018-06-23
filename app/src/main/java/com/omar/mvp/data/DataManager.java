package com.omar.mvp.data;

import com.omar.mvp.data.local.db.DbHelper;
import com.omar.mvp.data.remote.ApiService;
import com.omar.mvp.data.local.prefs.PreferenceHelper;

public interface DataManager extends ApiService , PreferenceHelper , DbHelper {

}
