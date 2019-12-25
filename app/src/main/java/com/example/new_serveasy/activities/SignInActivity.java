package com.example.new_serveasy.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.new_serveasy.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class SignInActivity extends AppCompatActivity {

    // TODO: Add member variables here:
    private FirebaseAuth mAuth;

    // UI references.
    private EditText mEmail;
    private EditText mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        mEmail = findViewById(R.id.email_et);
        mPassword = findViewById(R.id.password_et);

        mPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.integer.login || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        // TODO: Grab an instance of FirebaseAuth
        mAuth = FirebaseAuth.getInstance();

    }

    // Executed when Sign in button pressed
    public void signInExistingUser(View v) {
        // TODO: Call attemptLogin() here
        attemptLogin();

    }

    // Executed when Register button pressed
    public void signup(View v) {
        Intent intent = new Intent(this, SignUpActivity.class);
        finish();
        startActivity(intent);
    }

    // TODO: Complete the attemptLogin() method
    private void attemptLogin() {
        String email, password;

        email = mEmail.getText().toString();
        password = mPassword.getText().toString();

        if (email.equals("") || password.equals("")) {

            return;

        } else
            Toast.makeText(getApplicationContext(), "Login in Progress.....", Toast.LENGTH_LONG).show();

        // TODO: Use FirebaseAuth to sign in with email & password
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Log.d("Serveasy", "signInWithEmail() onComplete: " + task.isSuccessful());


                if (!task.isSuccessful()) {
                    Log.d("Serveasy", "Problem Signing In: " + task.getException());
                    showErrorDialog("There was a problem Signing In");

                } else {
                    FirebaseUser user = mAuth.getCurrentUser();
                    Log.d("Serveasy", "User Is: " + user);
                    Intent intent = new Intent(SignInActivity.this, DashboardActivity.class);
                    finish();
                    startActivity(intent);
                }


            }
        });


    }

    // TODO: Show error on screen with an alert dialog
    private void showErrorDialog(String message) {
        new AlertDialog.Builder(this)
                .setTitle("Oops")
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }


}