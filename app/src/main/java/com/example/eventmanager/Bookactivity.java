package com.example.eventmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import android.widget.ImageView;
import android.view.View;

import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class Bookactivity extends AppCompatActivity {

    // private BroadcastReceiver MyReceiver = null;

    TextView center_name, event_name, stime, date, tac;
    private static ImageView more;
    /*private int current_image;
    int[] images = {R.drawable.ic_keyboard_arrow_up_black_24dp,R.drawable.ic_keyboard_arrow_down_black_24dp};
    *///LinearLayout tac;

    //    TextView tv, tv1;
    private ProgressBar progressBar;
    DatabaseReference databaseReference;
    ImageView imageView, image;
    String center_name1, event_name1, stime1, date1, image_view, price1;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookactivity);

        //toolbar = findViewById(R.id.toolbar);

       /* setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
*/
        progressBar = findViewById(R.id.progressbar);
        event_name = findViewById(R.id.event_name);
        center_name = findViewById(R.id.center_name);
        stime = findViewById(R.id.stime);
        date = findViewById(R.id.date);
        more = findViewById(R.id.more);
        tac = findViewById(R.id.tac);
        imageView = findViewById(R.id.imageView);
        tac.setVisibility(View.INVISIBLE);
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int status = tac.getVisibility();
                if (status == View.VISIBLE) {
                    tac.setVisibility(View.INVISIBLE);
                    more.setImageResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                   /* current_image++;
                    current_image=current_image & images.length;
                    more.setImageResource(images[current_image]);*/
                } else {
                    tac.setVisibility(View.VISIBLE);
                    more.setImageResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
                   /* current_image--;
                    current_image=current_image & images.length;
                    more.setImageResource(images[current_image]);*/
                }
            }
        });

        event_name1 = getIntent().getExtras().getString("event_name");
        event_name.setText(event_name1);
       /* center_name1 = getIntent().getExtras().getString("center_name");
        center_name.setText(center_name1);*/
        date1 = getIntent().getExtras().getString("date");
        date.setText(date1);
        stime1 = getIntent().getExtras().getString("stime");
        stime.setText(stime1);
        price1 = getIntent().getExtras().getString("price");
        /*String center_name1 = getIntent().getExtras().getString("center_name");
        String img =  getIntent().getExtras().getString("imageView");
        Picasso.get().load(img).into(imageView);*/

        //center_name.setText(center_name1);

        databaseReference = FirebaseDatabase.getInstance().getReference("event");
        /*Query query= databaseReference.child(event_name)*/


        databaseReference.child(event_name1).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                image_view = dataSnapshot.child("imageView").getValue(String.class);
                Picasso.get().load(image_view).placeholder(R.drawable.home).into(imageView);
                String center_name1 = dataSnapshot.child("center_name").getValue(String.class);
                center_name.setText(center_name1);
                progressBar.isIndeterminate();
                progressBar.setVisibility(View.INVISIBLE);
                //Picasso.get().load(model.getImageView()).into(holder.imageView);
               /*String center_name1 = dataSnapshot.child("center_name").getValue().toString();
               center_name.setText(center_name1);
              */  /* image = dataSnapshot.getValue(String.class);
                Picasso.get().load(image).into(imageView);*/
                //Dashboard_item_model model = dataSnapshot.getValue(Dashboard_item_model.class);
                /*String center_name1 = dataSnapshot.getValue(String.class);
                center_name.setText(center_name1);*/
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), "Error....!!", Toast.LENGTH_SHORT).show();
                progressBar.isIndeterminate();
                progressBar.setVisibility(View.INVISIBLE);
            }
        });
    }

        




      /* // FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
       // String current_uid = user.getUid(); // user.getUid() will return null if you are not log in
        DatabaseReference db = FirebaseDatabase.getInstance().getReference();

        Query query = db.child("Leads").child("Generated").orderByChild("userid").equalTo(id);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                // do something

            }
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });*/

        /*MyReceiver = new MyReceiver();

        broadcastIntent();
*/



    /*public void broadcastIntent() {
        registerReceiver(MyReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(MyReceiver);
    }
*/
/*

    @Override
    protected void onStart() {
        super.onStart();
        databaseReference.orderByChild("event_name").equalTo(event_name1).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //image = dataSnapshot.child("imageView").getValue().toString();
                // Picasso.get().load(image).into(imageView);
                //Picasso.get().load(model.getImageView()).into(holder.imageView);
               *//*String center_name1 = dataSnapshot.child("center_name").getValue().toString();
               center_name.setText(center_name1);
              *//*  *//* image = dataSnapshot.getValue(String.class);
                Picasso.get().load(image).into(imageView);*//*
                //Dashboard_item_model model = dataSnapshot.getValue(Dashboard_item_model.class);
                *//*String center_name1 = dataSnapshot.getValue(String.class);
                center_name.setText(center_name1);*//*
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), "Error....!!", Toast.LENGTH_SHORT).show();
            }
        });
    }*/

}
