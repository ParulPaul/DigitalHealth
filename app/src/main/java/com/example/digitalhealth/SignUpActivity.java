package com.example.digitalhealth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public
class SignUpActivity extends AppCompatActivity {

    private EditText mMail;
    private EditText mPassWord;
    private EditText mConfirmedPassword;
    private EditText mMobileNum;

    private  String email, password, confirmPassword, mobileNo;

    Button mSignUp;

    @Override
    protected
    void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mMail = findViewById(R.id.et_Smail);
        mPassWord = findViewById(R.id.et_Spassword);
        mConfirmedPassword = findViewById(R.id.et_confrim_Password);
        mMobileNum = findViewById(R.id.et_Mobile);

        mSignUp = findViewById(R.id.btn_SignUp);

    }

    public  void btnSignUpClick(View view){

       email = mMail.getText().toString().trim();
       password = mPassWord.getText().toString().trim();
       confirmPassword = mConfirmedPassword.getText().toString().trim();
       mobileNo = mMobileNum.getText().toString().trim();

       if (email.equals("")){
           mMail.setError("Enter Email");
       }else if(password.equals("")){
          mPassWord.setError("Enter Password");
        }else if(confirmPassword.equals("")){
           mConfirmedPassword.setError("Confirm Password");
       }else if(!confirmPassword.equals(password)){
           mConfirmedPassword.setError("Right Password");
       }else{
           FirebaseAuth mAuth = FirebaseAuth.getInstance();
           mAuth.createUserWithEmailAndPassword(email,password)
                   .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                       @Override
                       public
                       void onComplete(@NonNull Task<AuthResult> task){
                           if(task.isSuccessful())
                       {

                           Toast.makeText(SignUpActivity.this,"Registered Successfully ", Toast.LENGTH_SHORT).show();
                           startActivity(new Intent(SignUpActivity.this, HomeActivity.class));
                           finish();
                       }
                           else
                               {
                                   Toast.makeText(SignUpActivity.this,"Registration Failed :" + task.getException()
                                           , Toast.LENGTH_SHORT).show();
                           }
                       }


                   });

       }
    }
}