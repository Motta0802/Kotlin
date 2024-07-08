package gcc.holywater.jogodavelha

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.jogodavelha.R
import com.example.jogodavelha.databinding.ActivityMainBinding

class principal : AppCompatActivity() {
        private lateinit var binding: ActivityMainBinding

        //matriz que representa o jogo
        val tabuleiro = arrayOf(
            arrayOf("A", "B", "C"),
            arrayOf("D", "E", "F"),
            arrayOf("G", "H", "I")
        )

        //declar o primero jogador
        var jogadoratual = "o"

        //função que roda o código
        override fun onCreate(savedInstanceState: Bundle?) {
            binding = ActivityMainBinding.inflate(layoutInflater)
            super.onCreate(savedInstanceState)
            setContentView(binding.root)
        }

        //função do jogador atual
        fun buttonClick(view: View) {

            //representação do jogador
            val buttonSelecionado = view as Button

            //declaração da vez de cada jogador
            buttonSelecionado.text = jogadoratual

            //usa o id do botão selecionado para declarar a vez do jogador
            when (buttonSelecionado.id) {
                binding.buttonum.id -> tabuleiro[0][0] = jogadoratual
                binding.buttondois.id -> tabuleiro[0][1] = jogadoratual
                binding.buttontres.id -> tabuleiro[0][2] = jogadoratual
                binding.buttonquatro.id -> tabuleiro[1][0] = jogadoratual
                binding.buttoncinco.id -> tabuleiro[1][1] = jogadoratual
                binding.buttonseis.id -> tabuleiro[1][2] = jogadoratual
                binding.buttonsete.id -> tabuleiro[2][0] = jogadoratual
                binding.buttonoito.id -> tabuleiro[1][1] = jogadoratual
                binding.buttonnove.id -> tabuleiro[2][2] = jogadoratual
            }

            var vencedor = verificaVencedor(tabuleiro)

            if (!vencedor.isNullOrBlank()) {
                Toast.makeText(this, "Vencedor: " + vencedor, Toast.LENGTH_SHORT).show()
                val intent = Intent(this, principal::class.java)
            }
            //o jogador a jogar
            if (jogadoratual.equals("X")) {
                //se o primeiro jogador for "X" então o jogador é definido como "O"
                buttonSelecionado.setBackgroundResource(R.drawable.asuka2)
                jogadoratual = "O"
            } else {
                //senao o jogador "O" sera definido como "X"
                buttonSelecionado.setBackgroundResource(R.drawable.rei2)
                jogadoratual = "X"
            }
            buttonSelecionado.isEnabled = false
        }
        //funçao para declaracao do vencedor
        fun verificaVencedor(tabuleiro: Array<Array<String>>): String? {
            //verificacao das linhas e colunas
            for (i in 0 until 3) {
                //verifica os itens iguais das linhas
                if (tabuleiro[i][0] == tabuleiro[i][1] && tabuleiro[i][1] == tabuleiro[i][2]) {
                    return tabuleiro[i][0]
                }
                //verifica os itens iguais das colunas
                if (tabuleiro[0][i] == tabuleiro[1][i] && tabuleiro[1][i] == tabuleiro[2][i]) {
                    return tabuleiro[0][i]
                }
            }
            return null
        }
    }

