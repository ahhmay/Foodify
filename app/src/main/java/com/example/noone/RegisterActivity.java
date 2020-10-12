package com.example.noone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    EditText mFullName,mEmail, mPassword, mPhone;
    Button mRegisterBtn;
    TextView mLoginBtn;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFullName=findViewById(R.id.fullname);
        mEmail=findViewById(R.id.emailid);
        mPassword=findViewById(R.id.password_id);
        mPhone=findViewById(R.id.phone);
        mLoginBtn=findViewById(R.id.register_textview);
        mRegisterBtn=findViewById(R.id.registerBtn);
        fAuth=FirebaseAuth.getInstance();
//        progressBar=findViewById(R.id.progressBar);

        //Code Snippet
        //If user is currently logged in then we don't need to show REGISTER or LOGIN ACTIVITY.
        if(fAuth.getCurrentUser()!= null){
            startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            finish();
        }


        mRegisterBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String fullname=mFullName.getText().toString().trim();
                String email=mEmail.getText().toString().trim();
                String password=mPassword.getText().toString().trim();
                final String phoneNo=mPhone.getEditableText().toString();

                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Email is Required.");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    mPassword.setError("Password is Required.");
                    return;
                }

                if(password.length()<8){
                    mPassword.setError("Password must be atleast 8 characters long.");
                    return;
                }

                if(phoneNo.length()!=10){
                    mPhone.setError("Invalid phone number.");
                    return;
                }

                if(TextUtils.isEmpty(fullname)){
                    mFullName.setError("Invalid username.");
                    return;
                }

//                Pattern ps = Pattern.compile("^[a-zA-Z ]+$");
//                Matcher ms = ps.matcher(fullname);
//                boolean bs = ms.matches();
//                if (bs == false) {
//                    mFullName.setError("Invalid username.");
//                }

//                progressBar.setVisibility(View.VISIBLE);


//                String userEnteredFullName=mFullName.getEditableText().toString();
//                String userEnteredEmail=mEmail.getEditableText().toString();
                //register the user in firebase.
                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(RegisterActivity.this,"Registered successfully.",Toast.LENGTH_SHORT).show();
                            //OTP AUTHENTICATION
                            Intent intent=new Intent(getApplicationContext(),OTPAuthenticate.class);
                            intent.putExtra("phoneNumber",phoneNo);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(RegisterActivity.this,"Error occurred!! Email already exists.",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        mLoginBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            }
        });
    }
}