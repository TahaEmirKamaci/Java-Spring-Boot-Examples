package com.loose.coupling;

public class WebSerciveDataProivder implements UserDataProvider {

    @Override
    public String getUserDetails() {
        return "Fetching Data From WebService";
    }
}
