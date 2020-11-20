package br.com.arquiteturamvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import br.com.arquiteturamvvm.ui.main.MainFragment
import br.com.arquiteturamvvm.ui.main.MainViewModel
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.textWelCome.observe(this, Observer {
            textWelcome.text = it
        })

        viewModel.login.observe(this,Observer {
            if (!it) {
                Toast.makeText(applicationContext , "Informe um login válido", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(applicationContext , " login válido", Toast.LENGTH_SHORT).show()
            }
        })
        btnLogin.setOnClickListener {
            val nome = editName.text.toString()
            viewModel.login(nome)
        }

    }
}