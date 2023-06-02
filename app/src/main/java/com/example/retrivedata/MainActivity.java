package com.example.retrivedata;

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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {


    Button save,show;
    EditText name,ages;
    DatabaseReference databaseUsers;
    long maxid=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        save=findViewById(R.id.save);
        show=findViewById(R.id.show);
        name=findViewById(R.id.editTextTextPersonName);
        ages=findViewById(R.id.editTextNumberDecimal);
        databaseUsers= FirebaseDatabase.getInstance().getReference();
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InsertData();
            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Userlist.class));
            }
        });
    }

    private void InsertData() {

        String username =name.getText().toString().trim();
        float age =Float.parseFloat(ages.getText().toString().trim());
String id = databaseUsers.push().getKey();
        user usr=new user(username,age);
        databaseUsers.child("users").child(id).setValue(usr).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(MainActivity.this,"User Detais",Toast.LENGTH_SHORT);
                }
            }
        });
    }
}