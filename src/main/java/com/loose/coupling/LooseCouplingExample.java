package com.loose.coupling;

import java.sql.SQLOutput;

public class LooseCouplingExample {
    public static void main(String[] args) {
        UserDataProvider databaseProvider = new UserDatabaseProvider();
        UserManager userManagerWithDb = new UserManager(databaseProvider);
        System.out.println(userManagerWithDb.getUserInfo());

        UserDataProvider WebServiceProvider = new WebSerciveDataProivder();
        UserManager userManagerWithWS = new UserManager(WebServiceProvider);
        System.out.println(userManagerWithWS.getUserInfo());

        UserDataProvider newDatabaseProvider = new NewDatabaseProvider();
        UserManager userManagerWithNewDB = new UserManager(newDatabaseProvider);
        System.out.println(userManagerWithNewDB.getUserInfo());
    }
}
