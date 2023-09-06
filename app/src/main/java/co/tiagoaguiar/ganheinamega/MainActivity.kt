package co.tiagoaguiar.ganheinamega

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText: EditText = findViewById(R.id.txtPersonName)
        val txtresult: TextView = findViewById(R.id.txtResult)
        val btnGenerate: Button = findViewById(R.id.btnGenerate)

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
            var number = random.nextInt(60)
            numbers.add(number + 1)
            if (numbers.size == text.toInt()) {
                break
            }
            txtresult.text = numbers.joinToString(" - ")
        }
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