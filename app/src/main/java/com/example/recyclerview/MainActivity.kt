package com.example.recyclerview

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.SimpleData.countryList
import com.example.networkService.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val mainScope = CoroutineScope(Dispatchers.Main)



        mainScope.launch {
            try {
                val posts = withContext(Dispatchers.IO) {
                    // test if network access is working
                    try {
                       val p = RetrofitClient.retrofit.getCountryList()

                        p.forEachIndexed { index, item ->
                            countryList.add(CountryModel(item.name, item.region, item.code, item.capital))
                        }
                    } catch (e: Exception) {
                        Log.d("error", e.message.toString())
                    }

                    // test if empty data
                    if (countryList.isEmpty()) {
                        countryList.add(CountryModel("No data", "", "", ""))
                    }

                }
                // Update UI with posts data
            } catch (e: Exception) {
                // Handle error
                Log.d("Error",e.message.toString())
            }
        }

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener{
            val intent = Intent(this, RecycleActivity::class.java)
            startActivity(intent)
        }


    }
}