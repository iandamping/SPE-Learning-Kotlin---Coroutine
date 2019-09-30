package com.ian.junemon.spe_learning_mvvm.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.ian.app.helper.util.fullScreenAnimation
import com.ian.app.helper.util.gone
import com.ian.app.helper.util.visible
import com.ian.junemon.spe_learning_mvvm.R
import com.ian.junemon.spe_learning_mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fullScreenAnimation()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        initBottomNav(binding)
    }

    private fun initBottomNav(binding: ActivityMainBinding) {
        binding.apply {
            with(Navigation.findNavController(this@MainActivity, R.id.learnNavHostFragment)) {
                bottomNav.setupWithNavController(this@with)
                addOnDestinationChangedListener { _, destination, _ ->
                    when (destination.id) {
                        R.id.movie_navigation -> bottomNav.visible()
                        R.id.tv_navigation -> bottomNav.visible()
                        R.id.profileFragment -> bottomNav.visible()
                        else -> bottomNav.gone()
                    }
                }
            }
        }
    }

}
