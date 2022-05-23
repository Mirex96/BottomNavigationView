package com.example.buttonnavigationviewbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.buttonnavigationviewbar.IdGenerator.generatorId
import com.example.buttonnavigationviewbar.fragments.ChatsFragment
import com.example.buttonnavigationviewbar.fragments.ContactsFragment
import com.example.buttonnavigationviewbar.fragments.SettingFragment
import com.google.android.material.bottomnavigation.BottomNavigationView



class MainActivity : AppCompatActivity() {
    lateinit var buttonNavigation: BottomNavigationView
    private val contactsFragment = ContactsFragment()
    private val chatsFragment = ChatsFragment()
    private val settingFragment = SettingFragment()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonNavigation = findViewById(R.id.buttonNavigationView)
        buttonNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.contacts -> replaceFragment(contactsFragment)
                R.id.chats -> replaceFragment(chatsFragment)
                R.id.setting -> replaceFragment(settingFragment)
            }
            true
        }

        buttonNavigation.selectedItemId = R.id.chats


    }

    private fun replaceFragment(fragment: Fragment) {
        if (fragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainer, fragment)
            transaction.commit()
        }
    }
}