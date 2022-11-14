package com.example.b1706555lehongquocvuong

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.b1706555lehongquocvuong.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            if(binding.etName.text?.isEmpty() == true){
                Toast.makeText(this,"Please enter your name!",Toast.LENGTH_LONG).show()
            }else{
                val intent = Intent(this,BmiActivity::class.java)
                intent.putExtra("name",binding.etName.text.toString())
                startActivity(intent)
            }
        }
    }
}