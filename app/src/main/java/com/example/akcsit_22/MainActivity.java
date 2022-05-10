    package com.example.akcsit_22;

    import androidx.appcompat.app.AppCompatActivity;

    import android.content.Intent;
    import android.os.Bundle;
    import android.os.Handler;

    public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            new Handler().postDelayed(() -> {
                Intent in = new Intent(MainActivity.this,activity_sign_up.class); //new Handler().postDelayed(
                startActivity(in);                                                              // new Runnable(){               //runnable is an inetrface
                MainActivity.this.finish();                                                     // @Override
            },2500);                                                                   // public void run (){
        }                                                                                       // inte......
    }                                                                                           //}
                                                                                                // }
                                                                                                // ,2000
                                                                                                // );