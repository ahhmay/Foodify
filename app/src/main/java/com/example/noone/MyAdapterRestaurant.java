package com.example.noone;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class MyAdapterRestaurant extends FirebaseRecyclerAdapter<DataModel, MyAdapterRestaurant.MyViewHolderRestaurant> {

    public MyAdapterRestaurant(@NonNull FirebaseRecyclerOptions<DataModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull MyViewHolderRestaurant holder, int position, @NonNull final DataModel dataModel) {
        holder.name.setText(dataModel.getRname());
        holder.address.setText(dataModel.getRaddress());
        holder.email.setText(dataModel.getRemail());


        //Below code helps to Click on image of "restaurant_cardview" and helps us open "fragment_big_card".
        holder.img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity=(AppCompatActivity)view.getContext();
                activity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_container, new BigCardFragment(dataModel.getRname(), dataModel.getRaddress(),dataModel.getRemail(),dataModel.getRphone(),dataModel.getRtime(),dataModel.getRtype())).addToBackStack(null).commit();
            }
        });
    }

    @NonNull
    @Override
    public MyViewHolderRestaurant onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_design, parent, false);
        return new MyViewHolderRestaurant(view);
    }

    public class MyViewHolderRestaurant extends RecyclerView.ViewHolder{

        //MY CODE (RESTAURANT BASIC DETAILS)
        TextView name, address, email;
        ImageView img1;
        //MY CODE ENDS

        //MY CODE (FOOD-ITEM DETAILS)
//        TextView foodName, foodCategory, foodPrice;

        public MyViewHolderRestaurant(@NonNull View itemView) {
            super(itemView);

            //MY CODE(HOOKS FOR RESTAURANT BASIC DETAILS)
            name=itemView.findViewById(R.id.name);
            address=itemView.findViewById(R.id.address);
            email=itemView.findViewById(R.id.email);
            img1=itemView.findViewById(R.id.img1);
            //MY CODE ENDS

            //MY CODE(HOOKS FOR FOOD-ITEM DETAILS)
//            foodName=itemView.findViewById(R.id.foodName);
//            foodCategory=itemView.findViewById(R.id.foodCategory);
//            foodPrice=itemView.findViewById(R.id.foodPrice);
            //MY CODE ENDS
        }
    }
}
