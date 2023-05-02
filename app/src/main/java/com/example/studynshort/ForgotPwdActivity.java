package com.example.studynshort;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class ForgotPwdActivity extends AppCompatActivity {
    private Button btnPwdReset;
    private EditText edittxtpwdreset;
    private FirebaseAuth mAuth;
    private ProgressDialog proDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pwd);

        proDialog = new ProgressDialog(ForgotPwdActivity.this);
        proDialog.setTitle("Send Email");
        proDialog.setMessage("Please wait...\nSending link to reset password !");

        edittxtpwdreset = findViewById(R.id.pwd_email);
        btnPwdReset = findViewById(R.id.forgotpwdreset);

        btnPwdReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edittxtpwdreset.getText().toString();

                if (TextUtils.isEmpty(email)){
                    edittxtpwdreset.setError("Please enter your registered email !");
                    edittxtpwdreset.requestFocus();
                }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    edittxtpwdreset.setError("Enter valid email !");
                    edittxtpwdreset.requestFocus();
                }else{
                    proDialog.show();
                    resetpassword(email);
                }
            }
        });
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            Window window = this.getWindow();
            window.setStatusBarColor(this.getResources().getColor(R.color.light_blue));
        }
    }

    private void resetpassword(String email) {
        mAuth = FirebaseAuth.getInstance();
        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(ForgotPwdActivity.this, "Please check your inbox for password reset link !", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(ForgotPwdActivity.this, LoginActivity.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(i);
                    finish();
                }
                proDialog.dismiss();
            }
        });
    }
}