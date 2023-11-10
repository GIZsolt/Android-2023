package com.tasty.recipesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.tasty.recipesapp.databinding.ActivityMainBinding
import com.tasty.recipesapp.repo.RecipeRepository
//import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    companion object{
        val TAG = MainActivity::class.java.simpleName
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate")

//        val dashboardFragment=DashboardFragment()
//        val recipesFragment=RecipesFragment()
//        val profileFragment=ProfileFragment()
//
//        setCurrentFragment(dashboardFragment)
//
//        bottomNavigationView.setOnNavigationItemSelectedListener {
//            when(it.itemId){
//                R.id.DashboardFragment->setCurrentFragment(dashboardFragment)
//                R.id.RecipesFragment ->setCurrentFragment(recipesFragment)
//                R.id.ProfileFragment ->setCurrentFragment(profileFragment)
//
//            }
//            true
//        }

        setContentView(binding.root)

        val recipes = RecipeRepository(this).readRecipes()
        recipes.forEach {
            Log.d(TAG, "recipe: $it")
        }
    }
//    private fun setCurrentFragment(fragment: Fragment)=
//        supportFragmentManager.beginTransaction().apply {
//            replace(R.id.flFragment,fragment)
//            commit()
//        }
}