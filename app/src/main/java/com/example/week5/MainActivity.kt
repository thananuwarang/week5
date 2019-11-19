package com.example.week5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    public final var TAG_DRINK = "DRINK"

    val titleArr = arrayOf("COCOA",
        "ICE TEA",
        "BLACK TEA",
        "GREEN TEA",
        "HERBAL TEA",
        "MILK",
        "COCKTAIL",
        "WHISKEY",
        "WINE",
        "BEER")

    val priceArr = arrayOf("40 Baht",
        "40 Baht",
        "50 Baht",
        "40 Baht",
        "50 Baht",
        "30 Baht",
        "120 Baht",
        "250 Baht",
        "180 Baht",
        "65 Baht")

    val context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setTitle("เครื่องดื่ม")

        val mAdp = ArrayAdapter(
            context, android.R.layout.simple_list_item_1,
            titleArr
        )
        lv_result.adapter = mAdp

        lv_result.setOnItemClickListener { parent, view, position, id ->

            var name = priceArr[position];

            senderFun(name)
            /*

            Toast.makeText(context,
                " เลขที่จ๊าบ  ${titleArr[position]} เลขที่ยอด ${priceArr[position]}"
                ,Toast.LENGTH_LONG).show()*/
        }
    }
        fun senderFun(str1 : String){
            //กำหนดค่าเริ่มต้น (ตัวมันเอง,class ปลายทาง)
            var goPageSecond = Intent(this,secActivity ::class.java)

            //กำหนดข้อมูลและส่งข้อมูล (ชื่อของข้อมูล,ข้อมูล)
            goPageSecond.putExtra(TAG_DRINK,str1)


            //เริ่มต้นเข้าสู่ activity second
            startActivity(goPageSecond)
    }
}
