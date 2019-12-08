package com.example.new_serveasy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    //Member Variables
    private EditText UserNameET;
    private EditText EmailET;
    private EditText PasswordET;
    private EditText ConfirmPassET;
    private Button SignupButton;
    private TextView SigninET;

    // Firebase instance variables
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_signup);

        //Binding Views
        UserNameET = findViewById(R.id.uname_edittext);
        EmailET = findViewById(R.id.email_edittext);
        PasswordET = findViewById(R.id.pass_edittext);
        ConfirmPassET = findViewById(R.id.edit_text_cnfpass);
        SignupButton = findViewById(R.id.signup_button);
        SigninET = findViewById(R.id.signin_text);

        // Keyboard sign in action
        ConfirmPassET.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.integer.register_form_finished || id == EditorInfo.IME_NULL) {
                    attemptRegistration();
                    return true;
                }
                return false;
            }
        });

        // TODO: Get hold of an instance of FirebaseAuth
        mAuth = FirebaseAuth.getInstance();
    }

    //executed when signup button is pressed
    public void signUp(View v) {
        attemptRegistration();
    }


    private void attemptRegistration() {
        EmailET.setError(null);
        PasswordET.setError(null);

        String email = EmailET.getText().toString();
        String password = PasswordET.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (TextUtils.isEmpty(password) || !isPasswordValid(password)) {
            PasswordET.setError(getString(R.string.error_invalid_password));
            focusView = PasswordET;
            cancel = true;
        }
        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            EmailET.setError(getString(R.string.error_field_required));
            focusView = EmailET;
            cancel = true;
        } else if (!isEmailValid(email)) {
            EmailET.setError(getString(R.string.error_invalid_email));
            focusView = EmailET;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // TODO: Call create FirebaseUser() here
                createFirebaseUser();
        }
    }

    private boolean isEmailValid(String email) {
        // You can add more checking logic here.
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Add own logic to check for a valid password (minimum 6 characters)
        String confirmPassword = ConfirmPassET.getText().toString();
        return confirmPassword.equals(password) && confirmPassword.length() > 4;

    }

    // TODO: Create a Firebase user
    private void createFirebaseUser() {

        String email = EmailET.getText().toString();
        String password = EmailET.getText().toString();
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                Log.d("Serveasy", "Create User OnComplete:" + task.isSuccessful());
                if (!task.isSuccessful()) {
                    Log.d("Serveasy", "User Not Created");
                    showErrorDialog("User Registration Failed");

                } else
                    showPositiveDialog("Registration Successful "+UserNameET.getText());

            }
        });


    }


    // TODO: Save the display name to Shared Preferences


    // TODO: Create an alert dialog to show in case registration failed
    private void showErrorDialog(String message) {
        new AlertDialog.Builder(this)
                .setTitle("OOPS")
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();


    }

    private void showPositiveDialog(String message) {
        new AlertDialog.Builder(this)
                .setTitle("Congratulations")
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, null)
                .setIcon(android.R.drawable.ic_dialog_info)
                .show();
    }


}


