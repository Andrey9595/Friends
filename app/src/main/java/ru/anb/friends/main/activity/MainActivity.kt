package ru.anb.friends.main.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.anb.friends.R
import ru.anb.friends.main.fragments.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.container, MainFragment.newInstance()).
                commit()
        }
    }
}