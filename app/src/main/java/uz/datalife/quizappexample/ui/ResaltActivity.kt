package uz.datalife.quizappexample.ui

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.datalife.quizappexample.R
import uz.datalife.quizappexample.data.Constants
import uz.datalife.quizappexample.databinding.ActivityResaltBinding

class ResaltActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResaltBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResaltBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferences = getSharedPreferences(Constants.PREFS_NAME, Context.MODE_PRIVATE)

        val result: Int = intent.getIntExtra("result", -1)
        val count = intent.getIntExtra("questions_count", -1)

        val name: String = sharedPreferences.getString("username", "") ?: "Unknown"

        binding.tvResult?.text = getString(R.string.result_text, name, count, result)

        binding.btnReset?.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}