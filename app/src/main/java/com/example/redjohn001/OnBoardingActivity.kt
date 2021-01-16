package com.example.redjohn001

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.button.MaterialButton
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class OnBoardingActivity : AppCompatActivity() {
    private val titleList =
        mutableListOf<String>("Set Schedules", "Add Your Kids", "Invite", "Share Duties")
    private val descriptionList = mutableListOf<String>(
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit Lorem lorem ipsum dolor sit amet, consectetur adipiscing elit Lorem",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit Lorem lorem ipsum dolor sit amet, consectetur adipiscing elit Lorem",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit Lorem lorem ipsum dolor sit amet, consectetur adipiscing elit Lorem",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit Lorem lorem ipsum dolor sit amet, consectetur adipiscing elit Lorem",
        "Share Duties"
    )
    private val imageList = mutableListOf<Int>(
        R.drawable.on_boarding_img_one,
        R.drawable.on_boarding_img_two,
        R.drawable.on_boarding_img_three,
        R.drawable.on_boarding_img_four
    )
    lateinit var nextBtn: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)

        val onBoardingViewPager: ViewPager2 = findViewById(R.id.on_boarding_view_pager)

        val tabIndicator: TabLayout = findViewById(R.id.tab_indicator)

        val skip: TextView = findViewById(R.id.skip_txt)

        skip.setOnClickListener {
            startActivity(Intent(applicationContext, WelcomeActivity::class.java))
            finish()
        }

        nextBtn = findViewById(R.id.next_get_started_button)

        onBoardingViewPager.adapter =
            OnBoardingViewPagerAdapter(imageList, titleList, descriptionList)
        onBoardingViewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        TabLayoutMediator(tabIndicator, onBoardingViewPager) { _, _ ->
        }.attach()


        onBoardingViewPager.registerOnPageChangeCallback(ViewPager2PageChangeCallback { onBoardingViewPager.currentItem })

        nextBtn.setOnClickListener {
            if (onBoardingViewPager.currentItem == 3) {
                startActivity(Intent(applicationContext, WelcomeActivity::class.java))
                finish()
            }
            onBoardingViewPager.currentItem = onBoardingViewPager.currentItem + 1
        }
    }

    inner class ViewPager2PageChangeCallback(private val listener: (Int) -> Unit) :
        ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            if (position == 3) {
                nextBtn.text = "Get Started"
            } else {
                nextBtn.text = "Next"
            }
        }
    }
}