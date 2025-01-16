package com.example.mobileapplication32

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mobileapplication32.onBoarding.SignUpFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.placeHolder, SignUpFragment.newInstance())
            .commit()
    }
}