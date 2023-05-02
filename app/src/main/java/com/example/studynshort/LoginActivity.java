package com.example.studynshort;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private EditText edittxtemail, edittxtpass;
    private ProgressDialog proDialog;
    private FirebaseAuth mAuth;
    private TextView txtview;
    Boolean isVisible = false;
    private static final String TAG = "LoginActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        TextView txtforgotpwd = findViewById(R.id.forgot_password);
        txtforgotpwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "You can reset your password now !", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this, ForgotPwdActivity.class));
            }
        });

        proDialog = new ProgressDialog(LoginActivity.this);
        proDialog.setTitle("Login");
        proDialog.setMessage("Please wait !");
        edittxtemail = findViewById(R.id.signin_email);
        edittxtpass = findViewById(R.id.signin_password);
        mAuth = FirebaseAuth.getInstance();

      /*  ImageView hideshoweye = findViewById(R.id.hideeye);
        hideshoweye.setImageResource(R.drawable.hideeye);
        hideshoweye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isVisible) {
                    isVisible = false;
                    edittxtpass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    hideshoweye.setImageResource(R.drawable.hideeye);
                } else {
                    isVisible = true;
                    edittxtpass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    hideshoweye.setImageResource(R.drawable.showeye);
                }
            }
        }); */


        Button btn = findViewById(R.id.signinbtn);
    btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String txtemail = edittxtemail.getText().toString();
        String txtpass = edittxtpass.getText().toString();

        if (TextUtils.isEmpty(txtemail)) {
            edittxtemail.setError("Please Enter Your Email !");
            edittxtemail.requestFocus();
        } else if (!Patterns.EMAIL_ADDRESS.matcher(txtemail).matches()) {
            edittxtemail.setError("Please Enter Valid Email !");
            edittxtemail.requestFocus();
        } else if (TextUtils.isEmpty(txtpass)) {
            edittxtpass.setError("Please Enter Your Password !");
            edittxtpass.requestFocus();
        } else {
            proDialog.show();
            loginuser(txtemail, txtpass);
        }
    }
});

        txtview = (TextView) findViewById(R.id.signupbtn);
        txtview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            Window window = this.getWindow();
            window.setStatusBarColor(this.getResources().getColor(R.color.light_blue));
        }
    }

    private void loginuser(String txtemail, String txtpass) {
        mAuth.signInWithEmailAndPassword(txtemail, txtpass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    FirebaseUser firebaseUser = mAuth.getCurrentUser();

                    if(firebaseUser.isEmailVerified()){
                        Toast.makeText(LoginActivity.this, "You are logged in app !", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(i);
                        finish();  //to close Register Activity

                    }else {
                        firebaseUser.sendEmailVerification();
                        mAuth.signOut();;
                        showAlertDialog();
                    }

                }else {
                    try{
                        throw task.getException();
                    } catch (FirebaseAuthInvalidUserException e){
                        edittxtemail.setError("Email does not exists or is no longer valid. Please register again !");
                        edittxtemail.requestFocus();
                    } catch (FirebaseAuthInvalidCredentialsException e){
                        edittxtpass.setError("Wrong password. Kindly, check and re-enter !!");
                        edittxtpass.requestFocus();
                    }catch (Exception e){
                        Log.e(TAG, e.getMessage());
                        Toast.makeText(LoginActivity.this, "Something went wrong !", Toast.LENGTH_SHORT).show();
                    }
                }
                proDialog.dismiss();
            }
        });
    }

    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
        builder.setTitle("Email is not Verified !");
        builder.setMessage("Please verify your email now. You can not login without email verification !");

        builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_APP_EMAIL);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        // create the AlertDialog
        AlertDialog alertDialog = builder.create();
        //show the AlertDialog
        alertDialog.show();
    }

 @Override
    protected void onStart() {
        super.onStart();
        if (mAuth.getCurrentUser() != null){
            Toast.makeText(LoginActivity.this, "Already logged In", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            finish();
        }else {
            Toast.makeText(LoginActivity.this, "You can logged now", Toast.LENGTH_SHORT).show();

        }

    }
}