package uz.datalife.quizappexample.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import uz.datalife.quizappexample.R
import uz.datalife.quizappexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.apply {
            etName.addTextChangedListener {
                tilName.isErrorEnabled = false
            }

            btnStart.setOnClickListener {
                val name = etName.text.toString()
                if (name.isEmpty()) {
                    tilName.error = getString(R.string.name_error)
                } else {
                    val intent = Intent(this@MainActivity, GameActivity::class.java)
                    intent.putExtra("name", name)
                    startActivity(intent)
                    finish()
                }
            }
        }
    }
}