package com.arpit.instagram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.shashank.sony.fancytoastlib.FancyToast;

public class login extends AppCompatActivity implements View.OnClickListener {

    private EditText edtLoginEmail,edtLoginPassword;
    private Button btnSignup,btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        setTitle("Login");

        edtLoginEmail=findViewById(R.id.edtLoginEmail);
        edtLoginPassword=findViewById(R.id.edtLoginPassword);

        btnLogin=findViewById(R.id.btnlogin2);
        btnSignup=findViewById(R.id.btnsignup2);

        btnLogin.setOnClickListener(login.this);
        btnSignup.setOnClickListener(login.this);

        if(ParseUser.getCurrentUser()!=null)
        {
            ParseUser.getCurrentUser().logOut();
        }

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnlogin2:
                if (edtLoginEmail.getText().toString().equals("") ||  edtLoginPassword.getText().toString().equals("")) {
                    FancyToast.makeText(login.this, "Email,Username, and Password is required",
                            Toast.LENGTH_SHORT, FancyToast.INFO, true).show();

                }
                else {
                    ParseUser.logInInBackground(edtLoginEmail.getText().toString(), edtLoginPassword.getText().toString(),
                            new LogInCallback() {
                        @Override
                        public void done(ParseUser user, ParseException e) {
                            if (user != null && e == null) {
                                FancyToast.makeText(login.this, user.getUsername() + " is Logged in successfully ",
                                        Toast.LENGTH_SHORT, FancyToast.SUCCESS, true).show();
                            } else {
                                FancyToast.makeText(login.this, "Login Failed " + e.getMessage(),
                                        Toast.LENGTH_SHORT, FancyToast.ERROR, true).show();
                            }
                        }
                    });
                }

                break;

            case R.id.btnsignup2:


                break;
        }
    }
    public void rootLayoutTapped(View view) {

        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
