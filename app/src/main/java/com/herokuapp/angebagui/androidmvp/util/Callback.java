package com.herokuapp.angebagui.androidmvp.util;

/**
 * Created by angebagui on 06/07/2016.
 */
public interface Callback <T> {
    void onSuccess(T t);
    void onFailure(Throwable throwable);
}
