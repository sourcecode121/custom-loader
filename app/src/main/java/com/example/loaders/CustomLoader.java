package com.example.loaders;

import android.support.v4.content.AsyncTaskLoader;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anand on 24/10/2016.
 */

public class CustomLoader extends AsyncTaskLoader<List<User>> {
    public CustomLoader(Context context) {
        super(context);
    }

    @Override
    public List<User> loadInBackground() {
        List<User> users = new ArrayList<>();
        users.add(new User("User1FirstName", "User1LastName"));
        users.add(new User("User2FirstName", "User2LastName"));
        return users;
    }
}
