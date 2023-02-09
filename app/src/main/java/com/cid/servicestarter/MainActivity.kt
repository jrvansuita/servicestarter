package com.cid.servicestarter

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		findViewById<View>(R.id.button).setOnClickListener {
			val intent = Intent("com.cid.service.start").apply {
				flags = Intent.FLAG_ACTIVITY_NEW_TASK
				`package` = "com.cid.service"
			}

			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
				startForegroundService(intent)
			} else {
				startService(intent)
			}
		}
	}
}