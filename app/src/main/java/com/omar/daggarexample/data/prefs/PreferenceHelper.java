package com.omar.daggarexample.data.prefs;

public interface PreferenceHelper {

    void setCurrentUserID(int userID);

    void setUserAsLoggedOut();

    int getUserID();
}
