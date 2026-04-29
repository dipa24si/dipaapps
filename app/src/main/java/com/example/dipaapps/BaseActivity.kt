package com.example.dipaapps

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.dipaapps.databinding.ActivityBaseBinding
import com.example.dipaapps.home.HomeFragment
import com.example.dipaapps.message.MessageFragment
import com.example.dipaapps.more.MoreFragment

class BaseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            // Sesuaikan systemBars.bottom menjadi 0 sesuai instruksi
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }

        /** FragmentHome sebagai fragment default */
        if (savedInstanceState == null) {
            replaceFragment(HomeFragment())
        }

        binding.bottomNavView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.message -> {
                    replaceFragment(MessageFragment())
                    true
                }
                R.id.more -> {
                    replaceFragment(MoreFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, fragment)
            //.addToBackStack(null) -> dinonaktifkan agar saat back langsung keluar aplikasi
            .commit()
    }
}