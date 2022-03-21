package mx.edu.ittepic.adacova.copitos_de_nieve

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Color.WHITE
import android.graphics.Paint

class Copos (este:Lienzo) {
    var posx=0f
    var posy=0f
    var cop = 0f

//    iniciamos variables
    init{
//    con resolucion
        posx= (Math.random()*2100).toFloat()
//    como vamos de arriba a abajo
      posy = ((Math.random()*2500)*-1).toFloat()
      cop=((Math.random()*7)+8).toFloat()
    }

    fun caer(){
        posy+=((Math.random()*5)+5).toFloat()
        if(posy>1000) posy =((Math.random()*1920)*-1).toFloat()
    }

    fun dibujarCopo(canvas: Canvas){
        val paint = Paint()
        paint.color = Color.WHITE
        canvas.drawCircle(posx,posy,cop,paint)
    }
}