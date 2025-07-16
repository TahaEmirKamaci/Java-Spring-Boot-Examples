package com.loose.coupling;

public class UserManager {
    private final UserDataProvider databaseProvider;

    public UserManager(UserDataProvider databaseProvider) {
        this.databaseProvider = databaseProvider;
    }

    public String getUserInfo() {
        return databaseProvider.getUserDetails();
    }
}
