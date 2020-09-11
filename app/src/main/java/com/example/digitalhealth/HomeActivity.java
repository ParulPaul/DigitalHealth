package com.example.digitalhealth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeActivity extends AppCompatActivity {

    Button mlogin;
    TextView mSignup, mForgotPassword;
    EditText mEmailLogin;
    EditText mPasswordLogin;
    private  String email, password;


    @Override
    protected
    void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mlogin = findViewById(R.id.btn_login);
        mSignup = findViewById(R.id.et_for_signUp);
        mEmailLogin = findViewById(R.id.et_mail);
        mPasswordLogin = findViewById(R.id.et_password);
        mForgotPassword = findViewById(R.id.et_forgottenPassword);

    }

       public void SignUp(View view){
        startActivity(new Intent(HomeActivity.this,SignUpActivity.class));
       }



       public void btnLoginClick(View view){
        email = mEmailLogin.getText().toString().trim();
        password = mPasswordLogin.getText().toString().trim();

        if(email.equals(""))
        {
            mEmailLogin.setError("Enter Email");

        }else if(password.equals(""))
        {
            mPasswordLogin.setError("Enter Password");
        }else{
            FirebaseAuth mAuth = FirebaseAuth.getInstance();
            mAuth.signInWithEmailAndPassword(email,password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public
                        void onComplete(@NonNull Task<AuthResult> task) {
                         if (task.isSuccessful()){

                             startActivity(new Intent(HomeActivity.this,DashBoardActivity.class));

                         }
                            else
                                {
                                    Toast.makeText(HomeActivity.this,"Login Failed :" + task.getException(), Toast.LENGTH_SHORT).show();
                                }
                        }
                    });
        }


       }

       public void Forgetpassword (View view){

        email = mEmailLogin.getText().toString().trim();
        if(email.equals("")){
            mEmailLogin.setError("Enter Email");
        }
        else{
             FirebaseAuth mAuth = FirebaseAuth.getInstance();

             mAuth.sendPasswordResetEmail(email)
                     .addOnCompleteListener(new OnCompleteListener<Void>() {
                         @Override
                         public
                         void onComplete(@NonNull Task<Void> task) {

                             if (task.isSuccessful()){
                                 Toast.makeText(HomeActivity.this,"Email Sent to:" + email, Toast.LENGTH_SHORT).show();
                             }else{
                                 Toast.makeText(HomeActivity.this,"Failed to Sent Email:" +
                                         task.getException(), Toast.LENGTH_SHORT).show();
                             }
                         }
                     });
        }
       }

    @Override
    protected
    void onStart() {
        super.onStart();

        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser mUser =  mAuth.getCurrentUser();

        if(mUser!=null)
        {
        }
    }
}