package com.example.fooddude.meal.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fooddude.R;
import com.example.fooddude.auth.util.SessionManager;
import com.example.fooddude.auth.view.SignInActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity
{
    @Override protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_screen);

        TextView tvEmail = findViewById(R.id.tvEmail);
        Button btnLogout = findViewById(R.id.btnLogout);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            tvEmail.setText(user.getEmail());
        } else {
            tvEmail.setText("Guest User");
        }

        btnLogout.setOnClickListener(v ->
        {
            FirebaseAuth.getInstance().signOut();
            new SessionManager(this).clearSession();
            startActivity(new Intent(this, SignInActivity.class));
            finishAffinity();
        });
    }

}