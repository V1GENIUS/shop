package com.example.shop;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class login_user<onActivityResult> extends AppCompatActivity {
    GoogleSignInOptions gso ;
    GoogleSignInClient gsc ;
    Button g_sign ;

    Button cont;
   // @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);

        cont = findViewById(R.id._continue);
         g_sign = findViewById(R.id.google);

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this,gso);
        g_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signInIntent = gsc.getSignInIntent();
                startActivityForResult(signInIntent,1000);
            }
        });

//    @Override
//        protected void onActivityResult(,int requestCode ; int resultCode, Intent data) {
//            super.onActivityResult(requestCode, resultCode, data);
//
//            if (requestCode == 1000 && resultCode == RESULT_OK) {
//                Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
//
//                try {
//                    GoogleSignInAccount account = task.getResult(ApiException.class);
//
//                    // Use account information as needed
//                    if (account != null) {
//                        String displayName = account.getDisplayName();
//                        String email = account.getEmail();
//                        // Add more properties as needed
//                    }
//                } catch (ApiException e) {
//                    e.printStackTrace();
//                }
//            }
//        }

//        onActivityResult(int code , int  resultCode ,Intent data ) {
//            super.onActivityResult(code, resultCode, data);
//            if(resultCode == 1000) {
//                Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
//            }
//        };

//        @Override
//        public void onActivityResult(int requestCode, int resultCode, Intent data) {
//            super.onActivityResult(requestCode, resultCode, data);
//
//        }




        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inext;
                inext = new Intent(login_user.this,MainActivity.class );
                startActivity(inext);
            }
        });
    }


}