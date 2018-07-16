package com.example.android9ed.robotinkotlin

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var color: Int = 0xFFFFFFFF.toInt()
    var imageChanged: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myListener = myL()

        if (savedInstanceState != null) {
            color = savedInstanceState.getInt("Color", color)
            imageChanged = savedInstanceState.getBoolean("imgChanged", false)
            if (imageChanged)imageView.setImageResource(R.mipmap.ic_launcher_round)
            textView.setBackgroundColor(color)
        }

        buttonRed.setOnClickListener(myListener)
        imageView.setOnClickListener(myListener)
    }


    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putInt("color", color)
        outState?.putBoolean("imgChanged", imageChanged)
    }

    private inner class myL: View.OnClickListener
    {
        override fun onClick(v: View?){
            when (v){
                buttonRed -> {
                    if (editText.text.toString().matches("0x[a-fA-F0-9]{8}".toRegex())) {
                        var longcolor: Long = editText.text.substring(2).toLong(16)
                        color = longcolor.toInt()
                    } else color = Color.RED
                }
                imageView -> {
                    if (radioButtonBlue.isChecked)
                        color = (Color.BLUE)
                    else if (radioButtonGreen.isChecked)
                        color = Color.GREEN

                    imageView.setImageResource(R.mipmap.ic_launcher_round)
                }
            }

            textView.setBackgroundColor(color)
        }
    }
}
