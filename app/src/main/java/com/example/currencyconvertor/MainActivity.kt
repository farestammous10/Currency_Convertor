package com.example.currencyconvertor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val number: EditText = findViewById(R.id.number)
        val result1: TextView = findViewById(R.id.number)
        //val view1:TextView = findViewById(R.id.View1)
        //val view2:TextView=findViewById(R.id.View2)
        val button: Button = findViewById(R.id.button)
        val spinner: Spinner = findViewById(R.id.spinner)
        var flag: String = "JD"

        var options = arrayOf("JD to Dollar" ,"JD to EU", "Dollar to Euro", "Dollar to JD", "Euro to Dollar" , "Euro to JD")
        spinner.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options.get(p2)
                /*if(options.get(p2) == "JD"){
                    view1.text=options[1]
                    view2.text=options[2]
                }
                else{
                   view1.text = options[0]
                    view2.text = options[1]
                }
*/
            }


            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }//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
        button.setOnClickListener { view ->
            var x: Int = number.text.toString().toInt()
            if (flag == "JD to Dollar") { 
                result1.text = JOD_to_Dollar(x).toString()

            } else if (flag == "Dollar to Euro") {
                result1.text = Dollar_to_Euro(x).toString()
            } else if (flag == "Euro to JD") {
                result1.text = Euro_to_JOD(x).toString()
            } else if (flag == "JD to Euro"){
                result1.text = JOD_to_Euro(x).toString()
        } else if (flag =="Dollar to JD") {
                result1.text = Dollar_to_JOD(x).toString()
            }else result1.text=Euro_to_Dollar(x).toString()

    }
    }

    public fun Dollar_to_JOD(a: Int): Double {
        return a * 0.71
    }

    public fun JOD_to_Dollar(a: Int): Double {
        return a * 1.41
    }

    public fun JOD_to_Euro(a: Int): Double {
        return a * 1.32
    }

    public fun Euro_to_JOD(a: Int): Double {
        return a * 0.76
    }

    public fun Dollar_to_Euro(a: Int): Double {
        return a * 0.94
    }

    public fun Euro_to_Dollar(a: Int): Double {
        return a * 1.06
    }
}