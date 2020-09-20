package com.example.calculatorkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_zero.setOnClickListener{ setTextFields("0")}
        btn_one.setOnClickListener{ setTextFields("1")}
        btn_two.setOnClickListener{ setTextFields("2")}
        btn_three.setOnClickListener{ setTextFields("3")}
        btn_four.setOnClickListener{ setTextFields("4")}
        btn_five.setOnClickListener{ setTextFields("5")}
        btn_six.setOnClickListener{ setTextFields("6")}
        btn_seven.setOnClickListener{ setTextFields("7")}
        btn_eight.setOnClickListener{ setTextFields("8")}
        btn_nine.setOnClickListener{ setTextFields("9")}
        btn_minus.setOnClickListener{ setTextFields("-")}
        btn_plus.setOnClickListener{ setTextFields("+")}
        btn_mult.setOnClickListener{ setTextFields("*")}
        btn_division.setOnClickListener { setTextFields("/")}
        btn_right_bkt.setOnClickListener{ setTextFields(")")}
        btn_left_bkt.setOnClickListener { setTextFields("(")}

        btn_ac.setOnClickListener {
            math_operation.text = ""
            result_text.text = ""
        }

        btn_back.setOnClickListener {
            val str = math_operation.text.toString()
            if(str.isNotEmpty()){
                math_operation.text = str.substring(0, str.length-1)
            }
            result_text.text = ""
        }


        btn_equal.setOnClickListener {
            try {
                val ex = ExpressionBuilder(math_operation.text.toString()).build()
                val result = ex.evaluate()

                val longRes = result.toLong()
                if(result == longRes.toDouble())
                    result_text.text = longRes.toString()
                else
                    result_text.text = result.toString()
            } catch (e:Exception) {
                Log.d("Error", "Message: ${e.message}")
            }
        }
        

    }

    fun setTextFields(str: String) {
        if(result_text.text != "") {
            math_operation.text = result_text.text
            result_text.text = ""
        }

        math_operation.append(str)
    }
}