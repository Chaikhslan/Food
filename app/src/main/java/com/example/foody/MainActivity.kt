package com.example.foody

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavMenu()
    }

    private fun bottomNavMenu() {
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.resipesFragment_menu -> {
                    loadFragment(RecipesFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.favoriteRecipesFragment_menu -> {
                    loadFragment(FavoriteRecipesFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.foodJokeFragment_menu -> {
                    loadFragment(FoodJokeFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                else -> {
                    return@setOnNavigationItemSelectedListener false
                }
            }
        }
    }

    private fun loadFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().also { fragmentTransaction ->
            fragmentTransaction.replace(R.id.fragment, fragment)
            fragmentTransaction.commit()
        }
    }
}