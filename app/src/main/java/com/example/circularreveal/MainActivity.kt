package com.example.circularreveal

import android.animation.Animator
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewAnimationUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var isOpen = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab.setOnClickListener { circularReveal() }
    }

    private fun circularReveal() {

        if (!isOpen) {

            val x = layout_reveal.right
            val y = layout_reveal.top

            val startRadius = 0
            val endRadius = Math.hypot(layout_reveal.width.toDouble(), layout_reveal.height.toDouble()).toInt()

            val anim =
                ViewAnimationUtils.createCircularReveal(layout_reveal, x, y, startRadius.toFloat(), endRadius.toFloat())

            layout_reveal.visibility = View.VISIBLE
            anim.start()

            isOpen = true

        } else {

            val x = layout_reveal.right
            val y = layout_reveal.top

            val startRadius = Math.max(layout_reveal.width, layout_reveal.height)
            val endRadius = 0

            val anim =
                ViewAnimationUtils.createCircularReveal(layout_reveal, x, y, startRadius.toFloat(), endRadius.toFloat())
            anim.addListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animator: Animator) {

                }

                override fun onAnimationEnd(animator: Animator) {
                    layout_reveal.visibility = View.GONE
                }

                override fun onAnimationCancel(animator: Animator) {

                }

                override fun onAnimationRepeat(animator: Animator) {

                }
            })

            anim.start()

            isOpen = false
        }
    }
}
