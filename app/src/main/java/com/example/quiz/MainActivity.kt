package com.example.quiz

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(R.layout.top)

        // adapter作成
        val array = arrayOf("A", "B", "C", "D")
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, array)
        spinner.adapter = arrayAdapter

        // 選択されたアイテムの変更を検知する
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, pos: Int, id: Long) {
                Log.e("onItemSelected", "parent: $parent, view: $view, pos: $pos, id: $id")
                if (pos == 0) {
                    buttonSetting.isEnabled = false
                    textSelected.text = "Nulling："
                } else {
                    buttonSetting.isEnabled = true
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                Log.e("onNothingSelected", "parent: $parent")
            }
        }
        // 選択されたアイテムを取得
        buttonSetting.setOnClickListener {
            val item = spinner.selectedItem.toString()
            textSelected.text = "Nulling： $item"
        }

        // 選択をリセット
        buttonReset.setOnClickListener {
            spinner.setSelection(0)
        }
    }
}