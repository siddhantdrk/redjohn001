package com.example.redjohn001

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container_main, SchedulesFragment()).commit()
//        val layout =
//            (tabLayout.getChildAt(0) as LinearLayout).getChildAt(YOUR_TAB_NUMBER) as LinearLayout
//        val layoutParams =
//            layout.layoutParams as LinearLayout.LayoutParams
//        layoutParams.weight = YOUR_WEIGHT // e.g. 0.5f
//
//        layout.layoutParams = layoutParams

    }
}