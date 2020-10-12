package com.example.noone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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

public class LoginActivity extends AppCompatActivity {

    EditText mEmail, mPassword;
    TextView mRegisterText;
    Button loginBtn;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail=findViewById(R.id.emailid);
        mPassword=findViewById(R.id.password_id);
        mRegisterText=findViewById(R.id.register_textview);
        loginBtn=findViewById(R.id.loginButton);
        fAuth=FirebaseAuth.getInstance();


        if (fAuth.getCurrentUser() != null) {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }



        fAuth=FirebaseAuth.getInstance();
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString().trim();
                final String password = mPassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Invalid email address.");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    mPassword.setError("Password cannot be empty.");
                    return;
                }

                if(password.length()<8){
                    mPassword.setError("Invalid password.");
                    return;
                }


                //authenticate user
                fAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
//                                progressBar.setVisibility(View.GONE);

                                String emailID=mEmail.getText().toString();
                                String passwordID=mPassword.getText().toString();

                                if (!task.isSuccessful()) {
                                    // there was an error
                                    if (password.length() < 8) {
                                        mPassword.setError("Password Incorrect");
                                    } else {
                                        Toast.makeText(LoginActivity.this, "Email or Password Incorrect.", Toast.LENGTH_LONG).show();
                                    }
                                } else {
                                    //my code

//                                    FragmentManager manager=getSupportFragmentManager();
//                                    FragmentTransaction t=manager.beginTransaction();
//                                    final ProfileFragment pf=new ProfileFragment();
//                                    Bundle bundle=new Bundle();
//                                    bundle.putString("username", emailID);
//                                    bundle.putString("password", passwordID);
//                                    pf.setArguments(bundle);
//                                    t.add(R.id.displayScreen,pf);
//                                    t.commit();

                                    //my code ends
                                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                    startActivity(intent);
                                    Toast.makeText(LoginActivity.this,"Login successful.",Toast.LENGTH_SHORT).show();
                                    finish();
                                }
                            }
                        });
            }
        });

        mRegisterText.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(getApplicationContext(),RegisterActivity.class));
            }
        });
    }
}