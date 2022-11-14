package com.example.b1706555lehongquocvuong

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class MetricAdapter (private val context: Activity,
     private val arrayList: ArrayList<String>):ArrayAdapter<String>(context,R.layout.row_metric,arrayList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflayer: LayoutInflater = LayoutInflater.from(context)
        val view:View = inflayer.inflate(R.layout.row_metric,null)

        val metric:TextView = view.findViewById(R.id.tv_metric)
        metric.text = arrayList[position].toString()

        return view
    }
}