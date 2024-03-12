package mx.itson.edu.examenu2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button: Button = findViewById(R.id.btn_visitar)

        button.setOnClickListener{
            var intento = Intent(this, Principal::class.java)
            this.startActivity(intento)
        }
    }
}