package uz.datalife.quizappexample.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import uz.datalife.quizappexample.R
import uz.datalife.quizappexample.data.Constants
import uz.datalife.quizappexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferences = getSharedPreferences(Constants.PREFS_NAME, Context.MODE_PRIVATE)

        binding.apply {
            etName.addTextChangedListener {
                tilName.isErrorEnabled = false
            }

            btnStart.setOnClickListener {
                val name = etName.text.toString()

                if (name.isEmpty() || name.isBlank()) {
                    tilName.error = getString(R.string.name_error)
                } else {
                    sharedPreferences.edit().putString("name", name).apply()
                    val intent = Intent(this@MainActivity, GameActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }
    }

    private fun getName(): String {
        return binding.etName.text.toString()
    }
}