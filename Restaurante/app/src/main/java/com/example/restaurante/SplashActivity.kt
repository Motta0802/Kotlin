package com.example.restaurante

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

	// ele retarda a aparição do conteúdo
        Handler(Looper.getMainLooper()).postDelayed({
	    val i = intent

	    // "j" recebe "Intent", que faz ligação com o arquivo PedidoActivity
            val j = Intent(this,PedidoActivity::class.java)
	    j.putExtras(i)
            startActivity(j)
        },2000)

    }
}