package mx.edu.ittepic.adacova.copitos_de_nieve

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        vamos a poner de vista lienzo
        setContentView(Lienzo(this))
    }
}