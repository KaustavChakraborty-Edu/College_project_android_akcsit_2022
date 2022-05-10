package com.example.akcsit_22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.akcsit_22.databinding.ActivitySignInBinding;
import com.google.android.material.textfield.TextInputLayout;

public class actiivity_sign_in extends AppCompatActivity {

    ActivitySignInBinding binding ;

    TextInputLayout email_layout , pass_layout ;
    EditText email_et , pass_et ;
    Button btn_sign_in ;
    TextView option_signUp ;


    String email , pwd  ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actiivity_sign_in);
        binding = ActivitySignInBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        email_layout = binding.layoutSignInEmail;
        pass_layout = binding.layoutSignInPwd;
        email_et = binding.signInEmail;
        pass_et = binding.signInPwd;
        btn_sign_in = binding.btnSignIn ;
        option_signUp = binding.signUpOpt ;

        option_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(actiivity_sign_in.this , activity_sign_up.class);
                startActivity(intent);
            }
        });

        btn_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if (validateFieldsSignIn()){
                   Toast.makeText(actiivity_sign_in.this ,"Sign in successful", Toast.LENGTH_SHORT).show();
               }
            }
        });





    }

    private boolean validateFieldsSignIn() {



            pass_layout.setError("");
            email_layout.setError("");

            boolean flag = false ;

            email = email_et.getText().toString();
            pwd = pass_et.getText().toString();

            if (email.isEmpty()){
                email_layout.setError("Enter valid email adress");
                flag = true ;
            }
            if (pwd.isEmpty()){
                pass_layout.setError("Enter valid password");
                flag = true ;
            }

            return !flag ;




    }
}