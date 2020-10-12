package com.example.noone;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BigCardFragment extends Fragment {
//  MY CODE
    MyAdapterRestaurant adapter;
    RecyclerView recyclerView;
//  MY CODE ENDS

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;
    String rname, raddress, remail, rphone, rtime, rtype;


    public BigCardFragment() {}

    public BigCardFragment(String rname, String raddress, String remail, String rphone, String rtime, String rtype) {
        this.rname=rname;
        this.raddress=raddress;
        this.remail=remail;
        this.rphone=rphone;
        this.rtime=rtime;
        this.rtype=rtype;
    }

    public static BigCardFragment newInstance(String param1, String param2) {
        BigCardFragment fragment = new BigCardFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        View view= inflater.inflate(R.layout.fragment_big_card, container, false);

        //MY CODE
//        recyclerView=view.findViewById(R.id.recyclerview);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//
//        FirebaseRecyclerOptions<DataModel> options=
//                new FirebaseRecyclerOptions.Builder<DataModel>()
//                        .setQuery(FirebaseDatabase.getInstance().getReference().child("foodItem"), DataModel.class)
//                        .build();
//
//        adapter=new MyAdapterRestaurant(options);
//        recyclerView.setAdapter(adapter);
//      MY code ends here

        TextView name_holder, address_holder, email_holder;

        name_holder=view.findViewById(R.id.name_holder);
        address_holder=view.findViewById(R.id.address_holder);
        email_holder=view.findViewById(R.id.email_holder);

        name_holder.setText(rname);
        address_holder.setText(raddress);
        email_holder.setText(remail);

        return view;
    }


    // on pressing back button, BigCardFragment will replace itself with RestaurantCardViewFragment(i.e, HomeFragment).
    public void onBackPressed(){
        AppCompatActivity activity=(AppCompatActivity)getContext();
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.main_container, new HomeFragment()).addToBackStack(null).commit();
    }
}