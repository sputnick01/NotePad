package com.example.kotlincourse


import android.os.Bundle
import android.widget.PopupMenu
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.kotlincourse.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpNavigationComponent()

    }

    private fun setUpNavigationComponent() {
    val navHostFragment:NavHostFragment= supportFragmentManager.findFragmentById(R.id.navHost) as NavHostFragment
        val navController=navHostFragment.navController

        val appBarConfiguration=
            AppBarConfiguration(setOf(R.layout.fragment_home,R.layout.fragment_home),binding.drawerlayout)

        binding.navView.setupWithNavController(navController)


        val popupMenu=PopupMenu(this,null)
        popupMenu.inflate(R.menu.menu_bottom)
        val menu=popupMenu.menu
        binding.bottomBar.setupWithNavController(menu,navController)
    }
}