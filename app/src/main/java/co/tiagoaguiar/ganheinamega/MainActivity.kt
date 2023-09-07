package co.tiagoaguiar.ganheinamega

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.Random

class MainActivity : AppCompatActivity() {

    private lateinit var prefs: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val editText: EditText = findViewById(R.id.txtPersonName)
        val txtresult: TextView = findViewById(R.id.txtResult)
        val btnGenerate: Button = findViewById(R.id.btnGenerate)

//banco de dados de preferencias
        prefs = getSharedPreferences("db", Context.MODE_PRIVATE)
        val result = prefs.getString("result", null)
        if(result != null){
            txtresult.text = "ultima aposta $result"
        }
//        btnGenerate.setOnClickListener(btnClickListener)

        btnGenerate.setOnClickListener {

            val text = editText.text.toString()
            numberGenerator(text, txtresult)
        }
    }

    fun numberGenerator(text: String, txtresult: TextView) {
        if (text.isEmpty()) {
            Toast.makeText(
                this,
                "Text cant be empty. Range number between 6 and 15 only",
                Toast.LENGTH_LONG
            ).show()
            return
        }
        if (text.toInt() < 6 || text.toInt() > 15) {
            Toast.makeText(
                this,
                "Text cant be empty. Range number between 6 and 15 only",
                Toast.LENGTH_LONG
            ).show()
            return
        }
        val random = Random()
        val numbers = mutableSetOf<Int>()
        while (true) {
            val number = random.nextInt(60)
            numbers.add(number + 1)
            if (numbers.size == text.toInt()) {
                break
            }
            txtresult.text = numbers.joinToString(" - ")
        val editor = prefs.edit()
            editor.putString("result", txtresult.text.toString())
            val saved = editor.apply()
            Log.i("Teste", "foi salvo $saved")
        //editor.commit() // sincrona - bloquear a interface
        }//apply nao bloqueia e e asincrono
    }
//diferents ways to call event
//    val btnClickListener = object : View.OnClickListener{
//        override fun onClick(p0: View?) {
//            Log.i("Test", "btn clickeado!!")
//        }
//    }

//    fun btnClicked(view: View){
//        Log.i("Test", "btn clickeado!!")
//    }

}