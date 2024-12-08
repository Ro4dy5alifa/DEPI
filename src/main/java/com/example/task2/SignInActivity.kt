package com.example.task2
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.task2.R

class SignInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val usernameEditText = findViewById<EditText>(R.id.usernameEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val signInButton = findViewById<Button>(R.id.signInButton)

        signInButton.setOnClickListener {
            val username = usernameEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Fields cannot be empty", Toast.LENGTH_SHORT).show()
            } else if (password.length < 8 || !password.contains(Regex(".*\\d.*")) || !password.contains(Regex(".*[a-zA-Z].*"))) {
                Toast.makeText(this, "Invalid password", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, MovieListActivity::class.java)
                intent.putExtra("username", username)
                startActivity(intent)
                finish()
            }
        }
    }

    override fun onBackPressed() {
        finishAffinity() // Exit the app
    }
}