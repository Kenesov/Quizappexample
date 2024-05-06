package uz.datalife.quizappexample.ui

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.datalife.quizappexample.R
import uz.datalife.quizappexample.databinding.ActivityResaltBinding

class ResaltActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResaltBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResaltBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val correctAnswersCount = intent.getIntExtra("score", 0)
        intent.getStringExtra("name")?.let {
            binding.tvName.text = it
        }

        binding.btnReset.setOnClickListener {
            val intent = Intent(this@ResaltActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.tvResult.text = getString(R.string.score_text, correctAnswersCount)
    }
}