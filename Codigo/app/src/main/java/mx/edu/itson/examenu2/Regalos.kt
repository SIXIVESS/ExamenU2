package mx.edu.itson.examenu2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class Regalos : AppCompatActivity() {
    var catalogo: ArrayList<Detalles> = ArrayList<Detalles>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regalos)

        var option: String? = intent.getStringExtra("selection")
        agregarProductos(option)

        var listView: GridView = findViewById(R.id.catalogo_detalles) as GridView

        var adaptador: DetalleAdapter = DetalleAdapter(this, catalogo)
        listView.adapter = adaptador

    }

    private fun agregarProductos(option: String?) {
        when(option){
            "Detalles" ->{
                catalogo.add(Detalles(R.drawable.cumplebotanas,"Cumple botanas", "250"))
                catalogo.add(Detalles(R.drawable.cumplecheve,"Cumple cheve", "250"))
                catalogo.add(Detalles(R.drawable.cumpleescolar,"Cumple escolar", "250"))
                catalogo.add(Detalles(R.drawable.cumplepaletas,"Cumple paletas", "250"))
                catalogo.add(Detalles(R.drawable.cumplesnack,"Cumple snack", "250"))
                catalogo.add(Detalles(R.drawable.cumplevinos,"Cumple vinos", "250"))
            }
            "Globos" ->{
                catalogo.add(Detalles(R.drawable.globoamor,"Globo amor", "300"))
                catalogo.add(Detalles(R.drawable.globocumple,"Globo cumple", "300"))
                catalogo.add(Detalles(R.drawable.globofestejo,"Globo festejo", "300"))
                catalogo.add(Detalles(R.drawable.globonum,"Globo num", "300"))
                catalogo.add(Detalles(R.drawable.globos,"Globo regalo", "300"))
                catalogo.add(Detalles(R.drawable.globos,"Globos", "300"))
            }
            "Peluches" ->{
                catalogo.add(Detalles(R.drawable.peluchemario,"Peluche Mario", "200"))
                catalogo.add(Detalles(R.drawable.pelucheminecraft,"Peluche minecraft", "200"))
                catalogo.add(Detalles(R.drawable.peluchepeppa,"Peluche Peppa", "200"))
                catalogo.add(Detalles(R.drawable.peluches,"Peluches", "200"))
                catalogo.add(Detalles(R.drawable.peluchesony,"Peluche Sonic", "200"))
                catalogo.add(Detalles(R.drawable.peluchevarios,"Peluche Stitch", "200"))
            }
            "Regalos" ->{
                catalogo.add(Detalles(R.drawable.regaloazul,"Regalo azul", "150"))
                catalogo.add(Detalles(R.drawable.regalobebe,"Regalo bebé", "150"))
                catalogo.add(Detalles(R.drawable.regalocajas,"Regalo cajas", "150"))
                catalogo.add(Detalles(R.drawable.regalocolores,"Regalo colores", "150"))
                catalogo.add(Detalles(R.drawable.regalos,"Regalos", "150"))
                catalogo.add(Detalles(R.drawable.regalovarios,"Regalo varios", "150"))
            }
            "Tazas" ->{
                catalogo.add(Detalles(R.drawable.tazaabuela,"Taza Abuela", "200"))
                catalogo.add(Detalles(R.drawable.tazalove,"Taza Love", "200"))
                catalogo.add(Detalles(R.drawable.tazaquiero,"Taza Quiero", "200"))
                catalogo.add(Detalles(R.drawable.tazas,"Tazas", "200"))
            }
        }
    }

    class DetalleAdapter: BaseAdapter{
        var context: Context? = null
        var detalles = ArrayList<Detalles>()

        constructor(context: Context, detalles: ArrayList<Detalles>){
            this.context = context
            this.detalles = detalles
        }
        override fun getCount(): Int {
            return detalles.size
        }

        override fun getItem(p0: Int): Any {
            return detalles[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }
        override fun getView(position: Int, coverView: View?, parent: ViewGroup?): View {
            var detalles = detalles[position]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var vista = inflator.inflate(R.layout.activity_detalle_regalos, null)

            var image: ImageView = vista.findViewById(R.id.iv_regalo_imagen)
            var titulo: TextView = vista.findViewById(R.id.tv_regalo_nombre)
            var precio: TextView = vista.findViewById(R.id.tv_regalo_precio)


            image.setImageResource(detalles.image)
            titulo.setText(detalles.titulo)
            precio.setText("$${detalles.precio}")

            image.setOnClickListener{
                var intento = Intent(context, DetalleRegalos::class.java)

                intento.putExtra("image", detalles.image)
                intento.putExtra("titulo", detalles.titulo)
                intento.putExtra("precio", "$${detalles.precio}")
                context!!.startActivity(intento)
            }
            return vista
        }
    }
}
