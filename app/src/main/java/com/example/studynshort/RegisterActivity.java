package com.example.studynshort;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    private TextView txtview;
    private EditText edittxtname, edittxtemail, edittxtpass;
    private ProgressDialog proDialog;
    private static final String TAG = "RegisterActivity";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        proDialog = new ProgressDialog(RegisterActivity.this);
        proDialog.setTitle("Register");
        proDialog.setMessage("Please verify your Email ! Check your inbox !");

        Toast.makeText(RegisterActivity.this, "You can register now", Toast.LENGTH_SHORT).show();

        edittxtname = findViewById(R.id.signup_name);
        edittxtemail = findViewById(R.id.signup_email);
        edittxtpass = findViewById(R.id.signup_password);

        Button registerbtn = findViewById(R.id.signupbtn);
        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtain the entered text
                String txtname = edittxtname.getText().toString();
                String txtemail = edittxtemail.getText().toString();
                String txtpass = edittxtpass.getText().toString();

                if (TextUtils.isEmpty(txtname)) {
                    edittxtname.setError("Please Enter Your Name !");
                    edittxtname.requestFocus();
                } else if (TextUtils.isEmpty(txtemail)) {
                    edittxtemail.setError("Please Enter Your Email !");
                    edittxtemail.requestFocus();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(txtemail).matches()) {
                    edittxtemail.setError("Please Enter Valid Email !");
                    edittxtemail.requestFocus();
                } else if (TextUtils.isEmpty(txtpass)) {
                    edittxtpass.setError("Please Enter Your Password !");
                    edittxtpass.requestFocus();
                } else if (txtpass.length() < 8) {
                    edittxtpass.setError("Password should be at least 8 digits !");
                    edittxtpass.requestFocus();
                } else {
                    proDialog.show();
                    registerUser(txtname, txtemail, txtpass);
                }

            }
        });


        txtview = (TextView) findViewById(R.id.signinbtn);
        txtview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });
    }

    private void registerUser(String txtname, String txtemail, String txtpass) {
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        mAuth.createUserWithEmailAndPassword(txtemail, txtpass).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    FirebaseUser firebaseUser = mAuth.getCurrentUser();

                    // Enter User Data into the database
                    User users = new User(txtname, txtemail, txtpass);

                    // Extracting user reference from database
                    DatabaseReference userProfile = FirebaseDatabase.getInstance().getReference("Registered Users");
                    userProfile.child(firebaseUser.getUid()).setValue(users).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                //send verification Email
                                firebaseUser.sendEmailVerification();
                                proDialog.show();
                              //  Toast.makeText(RegisterActivity.this, "Registered Successfully. Please verify your email ! ", Toast.LENGTH_SHORT).show();

                                //open User profile
                                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);

                                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(i);
                                finish();  //to close Register Activity
                            }else {
                                Toast.makeText(RegisterActivity.this, "Registered Unsuccessful. Please try again ! ", Toast.LENGTH_SHORT).show();
                            }
                            proDialog.dismiss();
                        }
                    });
                }else{
                    try{
                        throw task.getException();
                    } catch(FirebaseAuthWeakPasswordException e){
                        edittxtpass.setError("Your password is too weak. Kindy use a mix of alphabets, number and special characters !");
                        edittxtpass.requestFocus();

                    } catch (FirebaseAuthInvalidCredentialsException e){
                        edittxtemail.setError("Your email is Invalid or already in use. Kindly Re-enter !");
                        edittxtemail.requestFocus();

                    } catch (FirebaseAuthUserCollisionException e){
                        edittxtemail.setError("Email is already used. Use another email !");
                        edittxtemail.requestFocus();

                    } catch (Exception e){
                        Log.e(TAG, e.getMessage());
                        Toast.makeText(RegisterActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                    proDialog.dismiss();
                }
            }
        });
    }
}
