package com.achdanepiloksa.belajar_layouting.form

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.achdanepiloksa.belajar_layouting.R
import com.achdanepiloksa.belajar_layouting.home.view.MainActivity
import kotlinx.android.synthetic.main.activity_form.*
import kotlinx.android.synthetic.main.activity_main.*

class FormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        btn_submit.setOnClickListener{
            val name = et_name.text.toString()
            val imageURL = et_image.text.toString()

            val intent = Intent()
            intent.putExtra("name",name)
            intent.putExtra("url", imageURL)
            setResult(MainActivity.LAUNCH_FORM_ACTIVITY,intent)
            finish()
        }
    }
}