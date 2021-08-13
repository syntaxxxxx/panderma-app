package com.example.panderma

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.panderma.account.AccountFragment
import com.example.panderma.homepage.HomepageFragment
import com.example.panderma.post.PostFragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homepageFragment=HomepageFragment()
        val postFragment=PostFragment()
        val accountFragment=AccountFragment()

        setCurrentFragment(homepageFragment)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.homepage->setCurrentFragment(homepageFragment)
                R.id.post->setCurrentFragment(postFragment)
                R.id.account->setCurrentFragment(accountFragment)

            }
            true
        }

    }

    private fun setCurrentFragment(fragment:Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,fragment)
            commit()
        }

}