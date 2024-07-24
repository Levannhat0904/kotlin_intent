package com.nhatle.learnintent.Activity_tuong_minh

import android.content.Intent
import android.icu.text.IDNA.Info
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.nhatle.learnintent.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btn_start:Button = findViewById(R.id.btn_start_activity_info)
        val btn_ngam_dinh:Button = findViewById(R.id.btn_ngam_dinh)
        val btn_tuong_minh_co_du_lieu = findViewById<Button>(R.id.btn_tuong_minh_co_du_lieu)
        btn_start.setOnClickListener {
            //================start activi tuonng minh========================
            Intent(this, InfoActivity::class.java).apply {
                startActivity(this)
            }
//            hoac
//             val intent = Intent(this, InfoActivity::class.java)
//            startActivity(intent)
        }
        btn_ngam_dinh.setOnClickListener {
            // ================start ngam dinh=================
//              de mo activity trong ung dung hien tai thi can chinh sua them trong file manifest
//            nhu sau
//            <activity
//            android:name=".InformationActivity"
//            android:parentActivityName=".MainActivity"
//            android:exported="true">
//            <intent-filter>
//            <action android:name="android.intent.action.VIEW"/>
//            <category android:name="android.intent.category.DEFAULT"/>
//            </intent-filter>
//            </activity>
//            va de start thi ta lam nhu ben duoi
            Intent().apply {
                action = Intent.ACTION_VIEW
                addCategory(Intent.CATEGORY_DEFAULT)
                startActivity(this)
            }
        }
        btn_tuong_minh_co_du_lieu.setOnClickListener {
            Intent(this, InfoActivity::class.java).apply {
                val name = "Le Van Nhat"
                val age = 20
                val sj = arrayOf("cho", "meo", "lon")
                putExtra(InfoActivity.EXTRA_NAME,name)
                putExtra(InfoActivity.EXTRA_AGE, age)
                putExtra(InfoActivity.EXTRA_SJ,sj)
                startActivity(this)
            }
        }
    }
}