package com.tight.couple;


// a -mysql postgreSql
// B -web service, mongodb

public class TightCouplingExample {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        System.out.println(userManager.getUserInfo());
    }
}
