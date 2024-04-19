package com.example.finalproject


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()

        val signInButton = findViewById<Button>(R.id.signInButton)
        val signUpButton = findViewById<Button>(R.id.signUpButton)
        val signOutButton = findViewById<Button>(R.id.signOutButton)
        val emailEditText = findViewById<EditText>(R.id.email)
        val passwordEditText = findViewById<EditText>(R.id.password)

        signInButton.setOnClickListener {
            signIn(emailEditText.text.toString(), passwordEditText.text.toString())
        }

        signUpButton.setOnClickListener {
            createAccount(emailEditText.text.toString(), passwordEditText.text.toString())
        }

        signOutButton.setOnClickListener {
            signOut()
        }
    }

    private fun createAccount(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun signIn(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun signOut() {
        auth.signOut()
        Toast.makeText(baseContext, "You have been signed out.",
            Toast.LENGTH_SHORT).show()
    }
}

