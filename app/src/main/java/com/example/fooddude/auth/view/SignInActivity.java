package com.example.fooddude.auth.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fooddude.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;

public class SignInActivity extends AppCompatActivity
{
    private EditText emailInput, passwordInput;
    private Button btnSignIn, btnGoogleSignIn, btnGuest;
    private TextView registerLink;
    private ProgressBar progressBar;
    private FirebaseAuth auth;
    private GoogleSignInClient googleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin_screen);

        emailInput = findViewById(R.id.signInEmail);
        passwordInput = findViewById(R.id.signInPassword);
        btnSignIn = findViewById(R.id.signInButton);
        btnGoogleSignIn = findViewById(R.id.googleSignInButton);
        btnGuest = findViewById(R.id.guestButton);
        registerLink = findViewById(R.id.registerPromptText);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);

        auth = FirebaseAuth.getInstance();

        // Configure Google Sign-In
        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id)) // Obtain from Firebase Console
                .requestEmail()
                .build();
        googleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions);

        // Google Sign-In Button click listener
        btnGoogleSignIn.setOnClickListener(v -> signInWithGoogle());

        btnSignIn.setOnClickListener(v -> {
            String email = emailInput.getText().toString().trim();
            String password = passwordInput.getText().toString();

            if (email.isEmpty())
            {
                emailInput.setError("Email is required");
                return;
            }
            if (password.isEmpty())
            {
                passwordInput.setError("Password is required");
                return;
            }

            progressBar.setVisibility(View.VISIBLE);
            btnSignIn.setEnabled(false);

            auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(task -> {
                        progressBar.setVisibility(View.GONE);
                        btnSignIn.setEnabled(true);

                        if (task.isSuccessful())
                        {
                            // Navigate to MainActivity
                            Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(SignInActivity.this, MainActivity.class));
                            finish();
                        }
                        else
                        {
                            // Show error
                            Toast.makeText(this, "Login failed: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
        });

        registerLink.setOnClickListener(v -> startActivity(new Intent(SignInActivity.this, RegisterActivity.class)));

        btnGuest.setOnClickListener(v -> {
            // Set guest mode flag
            SharedPreferences prefs = getSharedPreferences("FoodDudePrefs", MODE_PRIVATE);
            prefs.edit().putBoolean("isGuest", true).apply();

            // Navigate to MainActivity
            startActivity(new Intent(SignInActivity.this, MainActivity.class));
        });
    }

    private void signInWithGoogle()
    {
        Intent signInIntent = googleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, 101);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 101) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleGoogleSignInResult(task);
        }
    }

    private void handleGoogleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            firebaseAuthWithGoogle(account);
        } catch (ApiException e) {
            Toast.makeText(this, "Google Sign-In failed: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount acct)
    {
        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        auth.signInWithCredential(credential)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful())
                    {
                        // Navigate to MainActivity
                        Toast.makeText(this, "Google Sign-In successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SignInActivity.this, MainActivity.class));
                        finish();
                    }
                    else
                    {
                        // Show error
                        Toast.makeText(this, "Authentication failed: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        // if user is already signed in, go directly to MainActivity
        if (FirebaseAuth.getInstance().getCurrentUser() != null)
        {
            startActivity(new Intent(SignInActivity.this, MainActivity.class));
            finish();
        }
    }
}