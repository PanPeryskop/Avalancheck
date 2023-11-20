package com.example.avalancheck

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.example.avalancheck.databinding.ActivityMainBinding
import java.lang.Exception
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private var sdepthval: Int = 0
    private var newsnow: Int = 0
    private var oldSurface: Int = 0
    private var windspeed: Int = 0
    private var windexposure: Int = 0
    private var temperature: Int = 0
    private var number: Int = 0
    private var summary: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //głębokość śniegu waga
        val SnowBox1 = findViewById<CheckBox>(R.id.SnowBox1)
        val SnowBox2 = findViewById<CheckBox>(R.id.SnowBox2)
        val SnowBox3 = findViewById<CheckBox>(R.id.SnowBox3)

        SnowBox1.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                sdepthval = 0
                SnowBox2.isChecked=false
                SnowBox3.isChecked=false
            }
        }

        SnowBox2.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                sdepthval = 2
                SnowBox1.isChecked=false
                SnowBox3.isChecked=false
            }
        }

        SnowBox3.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                sdepthval = 4
                SnowBox1.isChecked=false
                SnowBox2.isChecked=false
            }
        }


        //powierzchnia staregp sniegu

        val FirnBoX = findViewById<CheckBox>(R.id.Firn_Box)
        val WetBox = findViewById<CheckBox>(R.id.WetBox)
        val SettledBox = findViewById<CheckBox>(R.id.SettledBox)
        val Formationbox = findViewById<CheckBox>(R.id.Formationbox)
        FirnBoX.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                oldSurface = 1
                WetBox.isChecked=false
                Formationbox.isChecked=false
                SettledBox.isChecked=false
            }
        }

        WetBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                oldSurface = 3
                SettledBox.isChecked=false
                Formationbox.isChecked=false
                FirnBoX.isChecked=false

            }
        }

        SettledBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                oldSurface = 4
                WetBox.isChecked=false
                Formationbox.isChecked=false
                FirnBoX.isChecked=false

            }
        }
        Formationbox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                oldSurface = 5
                SettledBox.isChecked=false
                FirnBoX.isChecked=false
                WetBox.isChecked=false
            }
        }

        //prędkość wiatru
        val windbox1 = findViewById<CheckBox>(R.id.windbox1)
        val windbox2 = findViewById<CheckBox>(R.id.windbox2)
        val windbox3 = findViewById<CheckBox>(R.id.windbox3)
        windbox1.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                windspeed = 0
                windbox2.isChecked=false
                windbox3.isChecked=false
            }
        }

        windbox2.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                windspeed = 5
                windbox1.isChecked=false
                windbox3.isChecked=false
            }
        }

        windbox3.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                windspeed = 8
                windbox2.isChecked=false
                windbox1.isChecked=false
            }
        }

        //nastawienie na wiatr
        val windward = findViewById<CheckBox>(R.id.W2box)
        val leeward = findViewById<CheckBox>(R.id.W4box)
        windward.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                windexposure = 0
                leeward.isChecked=false
            }
        }
        leeward.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                windexposure = 10
                windward.isChecked=false
            }
        }


        //temperatura
        val tmp1 = findViewById<CheckBox>(R.id.Tmp1_Box)
        val tmp2 = findViewById<CheckBox>(R.id.Tmp3_Box)
        val tmp3 = findViewById<CheckBox>(R.id.Tmp5_Box)
        val tmp4 = findViewById<CheckBox>(R.id.Tmp7_Box)
        tmp1.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                temperature = 2
                tmp2.isChecked=false
                tmp3.isChecked=false
                tmp4.isChecked=false

            }
        }
        tmp2.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                temperature = 3
                tmp1.isChecked=false
                tmp3.isChecked=false
                tmp4.isChecked=false
            }
        }
        tmp3.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                temperature = 4
                tmp1.isChecked=false
                tmp2.isChecked=false
                tmp4.isChecked=false
            }
        }
        tmp4.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                temperature = 5
                tmp1.isChecked=false
                tmp2.isChecked=false
                tmp3.isChecked=false
            }
        }

        val editTextNumber = findViewById<EditText>(R.id.More)
        editTextNumber.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                try {
                    val input = s.toString()
                    if (input.isNotEmpty()) {
                        number = input.toInt()
                    }
                } catch (e: Exception) {
                }
            }
        })
        val result = findViewById<RelativeLayout>(R.id.result)
        val resultsumm = findViewById<TextView>(R.id.resultsumm)
        //confirm button
        val confirm_button = findViewById<Button>(R.id.confirm_button)
        confirm_button.setOnClickListener {

            if (number != 0) {
                newsnow = number
            }
            number = 0
            summary = windexposure + windspeed + newsnow + oldSurface + sdepthval + temperature

            when {
                summary < 20 -> {
                    result.setBackgroundColor(android.graphics.Color.parseColor("#23f729"))
                    if (summary < 10) {
                        resultsumm.text = "Pierwszy stopień zagrożenia lawinowego\nDolna połowa stopnia"
                    } else {
                        resultsumm.text = "Pierwszy stopień zagrożenia lawinowego\nGórna połowa stopnia"
                    }
                }

                summary < 40 -> {
                    result.setBackgroundColor(android.graphics.Color.parseColor("#fcfa00"))
                    if (summary < 30) {
                        resultsumm.text = "Drugi stopień zagrożenia lawinowego\nDolna połowa stopnia"
                    } else {
                        resultsumm.text = "Drugi stopień zagrożenia lawinowego\nGórna połowa stopnia"
                    }
                }

                summary < 60 -> {
                    result.setBackgroundColor(android.graphics.Color.parseColor("#fcc100"))
                    if (summary < 50) {
                        resultsumm.text = "Trzeci stopień zagrożenia lawinowego\nDolna połowa stopnia"
                    } else {
                        resultsumm.text = "Trzeci stopień zagrożenia lawinowego\nGórna połowa stopnia"
                    }

                }

                summary < 80 -> {
                    result.setBackgroundColor(android.graphics.Color.parseColor("#fc3900"))
                    if (summary < 70) {
                        resultsumm.text = "Czwarty stopień zagrożenia lawinowego\nDolna połowa stopnia"
                    } else {
                        resultsumm.text = "Czwarty stopień zagrożenia lawinowego\nGórna połowa stopnia"
                    }
                }

                else -> {
                    result.setBackgroundColor(android.graphics.Color.parseColor("#c70000"))
                    resultsumm.text = "Piąty stopień zagrożenia lawinowego"
                }
            }

        }

        val resetButton = findViewById<Button>(R.id.reset)
        resetButton.setOnClickListener {
            temperature = 0
            summary = 0
            windexposure = 0
            windspeed = 0
            newsnow = 0
            oldSurface = 0
            sdepthval = 0
            editTextNumber.text.clear()
            SnowBox1.isChecked = false
            SnowBox2.isChecked = false
            SnowBox3.isChecked = false
            FirnBoX.isChecked = false
            SettledBox.isChecked = false
            WetBox.isChecked = false
            Formationbox.isChecked = false
            windbox1.isChecked = false
            windbox2.isChecked = false
            windbox3.isChecked = false
            tmp1.isChecked = false
            tmp2.isChecked = false
            tmp3.isChecked = false
            tmp4.isChecked = false
            windward.isChecked = false
            leeward.isChecked = false
            resultsumm.text = ""
            result.setBackgroundColor(android.graphics.Color.parseColor("#00FFFFFF"))
        }
    }
}