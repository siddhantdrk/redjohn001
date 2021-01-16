package com.example.redjohn001

import android.content.Context
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment


class MainRegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_regestration_activty)
        val frameLayout: FrameLayout = findViewById(R.id.fragment_container)

        val frag: String = intent.getStringExtra("welcomeActivity")!!

        inflateFragment(frag)

        val activityRootView: View = findViewById(R.id.rootView)
        activityRootView.viewTreeObserver
            .addOnGlobalLayoutListener {
                val heightDiff: Int =
                    activityRootView.rootView.height - activityRootView.height
                if (heightDiff > dpToPx(
                        applicationContext,
                        200
                    )
                ) { // if more than 200 dp, it's probably a keyboard...
                    // ... do something here

                    val param = frameLayout.layoutParams as ViewGroup.MarginLayoutParams
                    param.setMargins(0, 120, 0, 0)
                    frameLayout.layoutParams = param
                } else {
                    val param = frameLayout.layoutParams as ViewGroup.MarginLayoutParams
                    param.setMargins(0, 736, 0, 0)
                    frameLayout.layoutParams = param
                }
            }
    }

    private fun dpToPx(context: Context, valueInDp: Int): Float {
        val metrics = context.resources.displayMetrics
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, valueInDp.toFloat(), metrics)
    }

    private fun inflateFragment(frag: String) {
        var fragment: Fragment = Fragment()
        when (frag) {
            "SignIn" -> fragment = SignInFragment()
            "Register" -> fragment = NewAccountFragment()
            "enterViaCode" -> fragment = EnterInviteCodeFragment()
        }
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
            .commit()
    }
}