package ru.anb.friends.main.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKAuthenticationResult
import com.vk.api.sdk.auth.VKScope
import ru.anb.friends.R
import ru.anb.friends.main.fragments.MainFragment

class MainActivity : AppCompatActivity() {
    private val vkInitial = VK.login(this) { result ->
        when (result) {
            is VKAuthenticationResult.Failed -> Toast.makeText(
                this,
                "Что то пошло не так",
                Toast.LENGTH_LONG
            )
            is VKAuthenticationResult.Success -> supportFragmentManager.beginTransaction()
                .add(R.id.container, MainFragment.newInstance()).commit()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vkInitial.launch(arrayListOf(VKScope.GROUPS))

    }
}