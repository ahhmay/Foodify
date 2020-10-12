package com.example.noone;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    TextView displayUsername,displayPassword;

    public ProfileFragment(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View v=  inflater.inflate(R.layout.fragment_profile,container,false);
//        displayUsername=v.findViewById(R.id.loggedInUserName);
//        displayPassword=v.findViewById(R.id.loggedInUserEmail);
//        Bundle bundle=getArguments();
//        String name=bundle.getString("username");
//        String password=bundle.getString("password");
//        displayUsername.setText(name);
//        displayPassword.setText(password);
        return v;
    }
}
