package com.example.b1706555lehongquocvuong

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.b1706555lehongquocvuong.databinding.ActivityBmiBinding

class BmiActivity : AppCompatActivity() {
    lateinit var binding: ActivityBmiBinding
    lateinit var name:String
    lateinit var type_arr:ArrayList<String>
    lateinit var type:String
    var age:Int = 0
    lateinit var gender_arr:ArrayList<String>
    lateinit var gender:String
    var weight:Double = 0.0
    var height:Double = 0.0
    var bmi_result:Double = 0.0
    lateinit var type_result:String
    var visitResult = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBmiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        name = intent.getStringExtra("name").toString()

        type_arr = Constants.TYPE
        gender_arr = Constants.Gender

        type = Constants.TYPE[0].toString()
        gender = Constants.Gender[0].toString()

        val adapterType = MetricAdapter(this,type_arr)
        val adapterGender = MetricAdapter(this,gender_arr)

        binding.spnType.adapter = adapterType
        binding.spnGender.adapter = adapterGender



        binding.btnCal.setOnClickListener {
            type = type_arr[binding.spnType.selectedItemPosition]
            gender = gender_arr[binding.spnGender.selectedItemPosition]
            age = binding.etAge.text.toString().toInt()
            weight = (binding.etWeight.text.toString().toDouble())
            height = (binding.etHeight.text.toString().toDouble())

            if(type.equals(Constants.TYPE[0])){
                bmi_result = weight / ((height/100)*(height/100))
            }else{
                bmi_result = weight * 703 / (height*height)
            }

            binding.tvInfo.text = "$name, $age, $gender"
            binding.tvResult.setText("%.2f".format(bmi_result))
            if(bmi_result <18.5){
                binding.tvResultType.text = "Thin"
            }else if(bmi_result <25 && bmi_result >= 18.5){
                binding.tvResultType.text = "Nomal"
            }else{
                binding.tvResultType.text = "Overweight"
            }

            binding.lnResult.visibility = View.VISIBLE

        }

        binding.btnReset.setOnClickListener {
            binding.lnResult.visibility = View.GONE
            binding.etAge.setText("")
            binding.etWeight.setText("")
            binding.etHeight.setText("")
        }

        binding.btnBack.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}