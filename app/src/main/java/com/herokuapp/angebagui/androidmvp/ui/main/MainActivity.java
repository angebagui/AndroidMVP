package com.herokuapp.angebagui.androidmvp.ui.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.herokuapp.angebagui.androidmvp.R;
import com.herokuapp.angebagui.androidmvp.model.User;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_USER = "MainActivity.EXTRA_USER";

    private User mUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mUser = getIntent().getParcelableExtra(EXTRA_USER);


        TextView textView = (TextView)findViewById(R.id.username_textView);
        textView.setText("Welcome "+mUser.name);


    }

}
