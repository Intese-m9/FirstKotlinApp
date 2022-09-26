package com.example.newsapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.newsapplication.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private var _binging: ActivityMainBinding? = null
    private val mBinding get() = _binging!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_splash)
        //Handler(Looper.myLooper()!!).postDelayed({
           // setContentView(mBinding.root)
         //   bottom_nav_menu.setupWithNavController(
       //         navController = nav_host_fragment.findNavController()
     //       )
   //     }, 5000)
        CoroutineScope(Dispatchers.Main).launch {
            delay(5000)
            _binging = ActivityMainBinding.inflate(layoutInflater)
            setContentView(mBinding.root)
            bottom_nav_menu.setupWithNavController(
                         navController = nav_host_fragment.findNavController()
                       )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binging = null
    }
}