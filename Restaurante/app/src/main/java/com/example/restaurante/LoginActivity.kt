package com.example.restaurante

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurante.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
//Criação da variável binding que servirá para manipular a tela.

    private lateinit var binding:ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //a variável binding interliga o layout ao código
        binding = ActivityLoginBinding.inflate(layoutInflater)
        //mostra o layout
        setContentView(binding.root)

        //cria um evento que entrará em vigor quando o usuário clicar no botão de entrar
        binding.buttonEntrar.setOnClickListener {
            //cria dois valore que vão receber os dados que o cliente digitar (nome e senha)
            val username = binding.editUsername.text.toString().trim()
            val password = binding.editPassword.text.toString().trim()

            //login
            if (username.equals("abc") && password.equals("123")) {
                val i = Intent(this, MainActivity::class.java)
                i.putExtra("username", username)
                //chama função "startActivity" passando o valor da variavel "i"
                startActivity(i)
                finish()
            } else {
                //Mensagem de erro
                Toast.makeText(applicationContext, "Errou", Toast.LENGTH_LONG).show()
            }
        }

    }
}