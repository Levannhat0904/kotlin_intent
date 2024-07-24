package com.nhatle.learnintent.Activity_tuong_minh

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.nhatle.learnintent.R

class InfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_info)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //nhan du lieu ve
        fillData()
    }
    private fun fillData() {
        val tv_name = findViewById<TextView>(R.id.tv_name)
        val tv_age = findViewById<TextView>(R.id.tv_age)
        val tv_sj = findViewById<TextView>(R.id.tv_sj)

        val fullName = intent.getStringExtra(EXTRA_NAME)
        val age = intent.getIntExtra(EXTRA_AGE, 0)
        val exNames = intent.getStringArrayExtra(EXTRA_SJ)
        // hiển thị lên màn hình
        val exName = StringBuilder()
        exNames?.let {
            for (ex in exNames) {
                exName.append(ex).append(", ")
            }
        }
        tv_name.setText(fullName)
        tv_age.setText("$age")
        tv_sj.setText(exName)
    }
    companion object{
        const val EXTRA_NAME ="package com.nhatle.learnintent.Activity_tuong_minh.EXTRA_NAME"
        const val EXTRA_AGE ="package com.nhatle.learnintent.Activity_tuong_minh.EXTRA_AGE"
        const val EXTRA_SJ ="package com.nhatle.learnintent.Activity_tuong_minh.EXTRA_SJ"
    }
}