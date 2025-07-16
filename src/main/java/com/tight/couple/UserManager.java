package com.tight.couple;

public class UserManager {
    private UserDatabase userDatabase= new UserDatabase();

    public String getUserInfo(){
        return UserDatabase.getUserDetails();
    }
}
