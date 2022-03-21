package mx.edu.ittepic.adacova.copitos_de_nieve

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.view.View
import kotlinx.coroutines.*
import kotlin.coroutines.EmptyCoroutineContext

class Lienzo(main:MainActivity): View(main) {
//    copitos
    var copitos = Array<Copos>(500,{Copos (this)})
    var uno = 20
    var dos = 200
    var contador = 0 //para el ciclo

//    con job
    val jobscope = CoroutineScope(Job() + Dispatchers.Main)

    val coposcayendo= jobscope.launch(EmptyCoroutineContext, CoroutineStart.LAZY){
        while(true){
            (0..copitos.size-1).forEach{
                copitos[it].caer()
            }
            contador++
//            moodificamos grafico
            main.runOnUiThread{
//                repintamos
                invalidate()
            }
            delay(40L)
        }
    }
    //    ondraw para dibujar
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        var paint = Paint()

//        colorcito azul para fondo
        canvas.drawColor(Color.rgb (36,84,138))
        paint.color = Color.rgb(13,89,38)
        canvas.drawLine(-100f,400f,500f,1000f,paint)

//        piso
        paint.color=Color.GREEN
        canvas.drawRect(-100f,800f,1600f,1600f,paint)

        //arbol
        paint.color = Color.rgb(180,114,20)
        paint.style=Paint.Style.FILL
        canvas.drawRect(500f,700f,550f,800f,paint)
        paint.color = Color.GREEN
        canvas.drawOval(450f,630f,600f,720f, paint)
        canvas.drawOval(450f,560f,600f,650f,paint)


//        luna
        paint.color = Color.WHITE
        canvas.drawCircle(190f,150f,80f,paint)
        paint.color = Color.BLUE
     //   canvas.drawCircle(185f+incrementoLuna,180f,50f,p)

        coposcayendo.start()
        dibujar(canvas)

    }

//    dibujaos copitos e incrementamos la nevada
    fun dibujar(canvas:Canvas){
        if(contador>=0&&contador<1000){
            (0..uno).forEach{
                copitos[it].caer()
                copitos[it].dibujarCopo(canvas)
            }
        }

        if(contador==1000){
            contador=1
        }
    }
}