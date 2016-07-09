package com.herokuapp.angebagui.androidmvp.ui.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.herokuapp.angebagui.androidmvp.R;
import com.herokuapp.angebagui.androidmvp.model.User;
import com.herokuapp.angebagui.androidmvp.ui.main.MainActivity;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private LoginPresenter presenter;

    private EditText userNameEditText;
    private EditText passwordEditText;

    private ProgressDialog progressDialog;
    private FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new LoginPresenter(this);

        setContentView(R.layout.activity_login);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        userNameEditText = (EditText)findViewById(R.id.userName_editText);
        passwordEditText = (EditText)findViewById(R.id.password_editText);


       fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(TextUtils.isEmpty(userNameEditText.getText())){
                    userNameEditText.setError("Username Obligatoire");
                    return;
                }

                if(TextUtils.isEmpty(passwordEditText.getText())){
                    passwordEditText.setError("Password Obligatoire");
                    return;
                }

                progressDialog = new ProgressDialog(LoginActivity.this);
                progressDialog.setIndeterminate(true);
                progressDialog.setMessage("Connexion en cours...");

                // Afficher le Notre progress bar
                progressDialog.show();

                // Tenter l'authentification avec le [LoginPresenter]
                presenter.attemptLogin(userNameEditText.getText().toString().trim(),passwordEditText.getText().toString().trim());

            }
        });
    }


    @Override
    public void navigateToMainActivity(User user) {
        progressDialog.dismiss();

        startActivity(new Intent(this, MainActivity.class).putExtra(MainActivity.EXTRA_USER,user));


    }

    @Override
    public void loginFailed(Throwable throwable) {
        progressDialog.dismiss();

        if(throwable == null)
            return;

        Snackbar.make(fab, throwable.getMessage(), Snackbar.LENGTH_LONG).show();
    }
}
