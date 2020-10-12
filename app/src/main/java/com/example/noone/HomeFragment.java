package com.example.noone;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class HomeFragment extends Fragment {

    MyAdapterRestaurant adapterRestaurant;
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
          View view= inflater.inflate(R.layout.fragment_home,container,false);


          //MY CODE
          recyclerView=view.findViewById(R.id.recyclerview);
          recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

          FirebaseRecyclerOptions<DataModel> options=
                  new FirebaseRecyclerOptions.Builder<DataModel>()
                  .setQuery(FirebaseDatabase.getInstance().getReference().child("restaurant"), DataModel.class)
                  .build();

          adapterRestaurant =new MyAdapterRestaurant(options);
          recyclerView.setAdapter(adapterRestaurant);

//        MY code ends here

          return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        adapterRestaurant.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapterRestaurant.stopListening();
    }
}
