package com.example.akcsit_22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.akcsit_22.databinding.ActivitySignUpBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class activity_sign_up extends AppCompatActivity {
   ActivitySignUpBinding binding; // have to add after binding in gradle file // 2

    TextInputLayout nameLayout , emailLayout , pwdLayout , phoneLayout ; //5
    TextInputEditText nameInput , emailInput , pwdInput , phoneInput ; //5
    TextView optionSignIn  ; //5
    Button btnSignUp ;  //5
    RadioGroup radioGroup ; //5
    String name ,gender ,contact , email , pass ; //5

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater()); // 3

        setContentView(binding.getRoot());   // 4

        nameLayout = binding.layoutNewname ;                                                                      //6
        emailLayout = binding.layoutEmail;
        pwdLayout = binding.layoutPassword ;
        phoneLayout = binding.layoutPno ;
        nameInput = binding.inputUsername ;
        emailInput = binding.inputEmail ;
        pwdInput = binding.inputPassword;
        phoneInput = binding.inputPno ;
        optionSignIn = binding.signOpt;
        btnSignUp = binding.btnSubmit ;
        radioGroup = binding.gender ;
                                                                       //6


        //To get data  from radio button present  under radio group
        radioGroup.setOnCheckedChangeListener(((radioGroup1, i) ->{
            if (radioGroup1.getCheckedRadioButtonId()==binding.genderMale.getId())
                gender = getString(R.string.male);
            else if (radioGroup1.getCheckedRadioButtonId()== binding.genderFemale.getId())
                gender = getString(R.string.female);
            else
                gender = getString(R.string.others);
        } ));


        optionSignIn.setOnClickListener(new View.OnClickListener() {                                                //7
            @Override
            public void onClick(View view) {

                    Intent intent = new Intent (activity_sign_up.this , actiivity_sign_in.class) ;
                    startActivity(intent);
                }

        });                                                                                                                 //7

    btnSignUp.setOnClickListener(view -> {                                                                                 //8
        if (validateFields()){

            Toast.makeText(activity_sign_up.this , "Registration Successful" , Toast.LENGTH_SHORT).show();

        }

    });                                                                                                                    //8





    }

    private boolean validateFields() {                                                                                      //9
        pwdLayout.setError("");
        phoneLayout.setError("");
        nameLayout.setError("");
        emailLayout.setError("");

        boolean flag = false ;

       //save data provided by user
        name = nameInput.getText().toString();
        email = emailInput.getText().toString();
        contact = phoneInput.getText().toString();
        pass = pwdInput.getText().toString();

        //performing validation

        if (gender == null) {
            Toast.makeText(activity_sign_up.this, "choose gender", Toast.LENGTH_SHORT).show();
            flag = true ;
        }
         if(name.isEmpty()) {
             nameLayout.setError("specify the username");
            flag = true ;
         }
         if (email.isEmpty()) {
             emailLayout.setError("specify Email");
             flag = true ;
         }
         if (contact.length() != 10) {
             phoneLayout.setError("Enter correct phone number");
             flag = true ;
         }
            if (pass.isEmpty()) {
                pwdLayout.setError("specify pass  word");
                flag = true ;
            }

     return !flag;
    }
}                                                                                           //9