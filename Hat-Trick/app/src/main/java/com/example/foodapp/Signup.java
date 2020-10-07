package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity {
    TextInputLayout regName,regUserName,regEmail,regPhone,regPass;
    Button regbtn,regLogin;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    User newUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        regName=findViewById(R.id.name);
        regUserName=findViewById(R.id.user_name);
        regEmail=findViewById(R.id.email);
        regPhone=findViewById(R.id.phone_number);
        regPass=findViewById(R.id.password);
        regbtn=findViewById(R.id.confirm);
        regLogin=findViewById(R.id.login);
        rootNode=FirebaseDatabase.getInstance();
        reference=rootNode.getReference().child("User");


        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name=regName.getEditText().getText().toString();
                String username=regUserName.getEditText().getText().toString();
                String email=regEmail.getEditText().getText().toString();
                String phone=regPhone.getEditText().getText().toString();
                String password=regPass.getEditText().getText().toString();

                newUser=new User(name,username,email,password);
                reference.child(phone).setValue(newUser);

            }
        });
    }
    private Boolean validateName(){
        String val=regName.getEditText().getText().toString();

        if(val.isEmpty()){
            regName.setError("Field can not be empty");
            return false;
        }else{
            regName.setError(null);
            return true;
        }
    }
    private Boolean validateUserName(){
        String val=regUserName.getEditText().getText().toString();

        if(val.isEmpty()){
            regUserName.setError("Field can not be empty");
            return false;
        }else if(val.length()>=15){
            regUserName.setError("Field can not be empty");
            return false;
        }else{
            regUserName.setError(null);
            regUserName.setErrorEnabled(false);
            return true;
        }
    }
    private Boolean validateEmail(){
        String val=regEmail
                .getEditText().getText().toString();

        if(val.isEmpty()){
            regEmail.setError("Field can not be empty");
            return false;
        }else{
            regEmail.setError(null);
            return true;
        }
    }
    private Boolean validatePhone()
    {
        String val=regPhone.getEditText().getText().toString();

        if(val.isEmpty()){
            regPhone.setError("Field can not be empty");
            return false;
        }else{
            regPhone.setError(null);
            return true;
        }
    }
    private Boolean validatePassword(){
        String val=regPass.getEditText().getText().toString();

        if(val.isEmpty()){
            regPass.setError("Field can not be empty");
            return false;
        }else{
            regPass.setError(null);
            return true;
        }
    }

}
