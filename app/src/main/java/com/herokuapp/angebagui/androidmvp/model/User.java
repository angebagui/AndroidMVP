package com.herokuapp.angebagui.androidmvp.model;

import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;

import com.herokuapp.angebagui.androidmvp.util.Callback;


/**
 * Created by angebagui on 06/07/2016.
 */
public class User implements Parcelable {

    public String login;
    public String password;
    public String name;

    public User(String login, String password, String name) {
        this.login = login;
        this.password = password;
        this.name = name;
    }


    public static void loginInBackground(final String login, final String password, final Callback<User> callback){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if ((login.length() > 3) && (password.length() > 3)) {
                   callback.onSuccess(new User(login,password, "Laurent B."));
                } else {
                    callback.onFailure(new Throwable("Sorry something happened"));
                }
            }
        },2000);

    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.login);
        dest.writeString(this.password);
        dest.writeString(this.name);
    }

    protected User(Parcel in) {
        this.login = in.readString();
        this.password = in.readString();
        this.name = in.readString();
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}


