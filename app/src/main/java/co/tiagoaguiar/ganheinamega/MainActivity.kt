package co.tiagoaguiar.ganheinamega

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText:EditText = findViewById(R.id.txtPersonName)
        val txtresult:TextView = findViewById(R.id.txtResult)
        val btnGenerate:Button = findViewById(R.id.btnGenerate)

        txtresult.text = "Q te sapa???"

//        btnGenerate.setOnClickListener(btnClickListener)

        btnGenerate.setOnClickListener { Log.i("Test", "btn clickeado!!") }
    }

//    val btnClickListener = object : View.OnClickListener{
//        override fun onClick(p0: View?) {
//            Log.i("Test", "btn clickeado!!")
//        }
//    }

//    fun btnClicked(view: View){
//        Log.i("Test", "btn clickeado!!")
//    }

}