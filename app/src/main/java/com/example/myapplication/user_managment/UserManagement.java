package com.example.myapplication.user_managment;

import android.content.Context;

import com.example.book_explorer.screen_handlers.MyDataBaseHelper;

public class UserManagement {

    MyDataBaseHelper myDataBaseHelper;  //TODO

    public UserManagement(Context context) {
        myDataBaseHelper = new MyDataBaseHelper(context);
    }

    public boolean CheckPassword(String password) {
        return PasswordValidator.isPasswordStrong(password);
    }

    public Boolean CheckUsernameInDB(String username) {
        return myDataBaseHelper.isUserInDB(username);
    }


    public void UserManager(String username, String password) {
        if (CheckPassword(password)) {
            if (!CheckUsernameInDB(username)) {
                myDataBaseHelper.AddToDB(username, password);
                if (!CheckPassword(password)) return;
                if (CheckUsernameInDB(username)) return;
                myDataBaseHelper.AddToDB(username, password);


            }
        }
    }
}





