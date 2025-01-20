package com.example.learncoroutines.bottom_navigation_view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.replace
import com.example.learncoroutines.R
import com.example.learncoroutines.databinding.ActivityMyBinding

class MyActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMyBinding

    private val reactionFragment by lazy { ReactionFragment() }
    private val alarmFragment by lazy { AlarmFragment() }
    private val contactFragment by lazy { ContactFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        loadFragment(ReactionFragment())
        binding.apply {
            bottomNavigation.setOnItemSelectedListener  {
                when(it.itemId){
                    R.id.menuReaction -> {loadFragment(ReactionFragment())}
                    R.id.menuAlarm -> {loadFragment(AlarmFragment())}
                    R.id.menuContact -> {loadFragment(ContactFragment())}
                }
                true
            }
            bottomNavigation.getOrCreateBadge(R.id.menuAlarm).apply {
                number = 4
                isVisible = true
            }
        }
    }

    private fun loadFragment(fragment : Fragment){

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainerViewTag,fragment).commit()
        }
    }
}