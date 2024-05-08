package uz.datalife.quizappexample.ui

import android.content.Intent
import android.content.res.ColorStateList
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import uz.datalife.quizappexample.R
import uz.datalife.quizappexample.data.Constants
import uz.datalife.quizappexample.data.Question
import uz.datalife.quizappexample.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameBinding
    private val questions = Constants.provideQuestions().shuffled()
    private var currentQuestionId = -1
    private var selectedAnswerId = -1
    private var correctAnswers = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        currentQuestionId = 0
        setQuestion()

        binding.apply {

            btn1.setOnClickListener {
                optionSelected(btn1)
                selectedAnswerId = 0
            }

            btn2.setOnClickListener {
                optionSelected(btn2)
                selectedAnswerId = 1
            }

            btn3.setOnClickListener {
                optionSelected(btn3)
                selectedAnswerId = 2
            }

            btn4.setOnClickListener {
                optionSelected(btn4)
                selectedAnswerId = 3
            }

            btnNext.setOnClickListener {
                when (btnNext.text) {
                    getString(R.string.submit) -> checkAnswer()
                    getString(R.string.finish_text) -> {
                        val intent = Intent(this@GameActivity, ResaltActivity::class.java)
                        intent.putExtra("result", correctAnswers)
                        intent.putExtra("questions_count", questions.size)
                        startActivity(intent)
                        finish()
                    }
                    getString(R.string.continue_text) -> {
                        currentQuestionId++
                        setQuestion()
                    }
                    // added comment
                }
            }
        }
    }

    private fun setQuestion() {
        val currentQuestion = questions[currentQuestionId]

        binding.apply {
            countQuestion.text =
                getString(R.string.question_counter, currentQuestionId + 1, questions.size)
            questionText.text = currentQuestion.question
            btn1.text = currentQuestion.answers[0]
            btn2.text = currentQuestion.answers[1]
            btn3.text = currentQuestion.answers[2]
            btn4.text = currentQuestion.answers[3]

            btn1.isEnabled = true
            btn2.isEnabled = true
            btn3.isEnabled = true
            btn4.isEnabled = true

            btn1.backgroundTintList = ColorStateList.valueOf(
                ContextCompat.getColor(this@GameActivity, R.color.tranparent_color)
            )
            btn2.backgroundTintList = ColorStateList.valueOf(
                ContextCompat.getColor(this@GameActivity, R.color.tranparent_color)
            )
            btn3.backgroundTintList = ColorStateList.valueOf(
                ContextCompat.getColor(this@GameActivity, R.color.tranparent_color)
            )
            btn4.backgroundTintList = ColorStateList.valueOf(
                ContextCompat.getColor(this@GameActivity, R.color.tranparent_color)
            )

            btnNext.text = getString(R.string.submit)
        }
    }

    private fun optionSelected(button: Button) {
        binding.apply {
            btn1.backgroundTintList = ColorStateList.valueOf(
                ContextCompat.getColor(this@GameActivity, R.color.tranparent_color)
            )
            btn2.backgroundTintList = ColorStateList.valueOf(
                ContextCompat.getColor(this@GameActivity, R.color.tranparent_color)
            )
            btn3.backgroundTintList = ColorStateList.valueOf(
                ContextCompat.getColor(this@GameActivity, R.color.tranparent_color)
            )
            btn4.backgroundTintList = ColorStateList.valueOf(
                ContextCompat.getColor(this@GameActivity, R.color.tranparent_color)
            )
        }

        button.backgroundTintList = ColorStateList.valueOf(
            ContextCompat.getColor(this, R.color.selected_color)
        )
    }

    private fun checkAnswer() {
        val currentQuestion = questions[currentQuestionId]

        if (selectedAnswerId == -1) {
            Snackbar.make(
                binding.btnNext,
                "Please, select option",
                Snackbar.LENGTH_SHORT
            ).show()
            return
        }

        if (currentQuestion.correctAnswerId == selectedAnswerId) {
            correctAnswers++
        }

        binding.apply {
            when (selectedAnswerId) {
                0 -> {
                    btn1.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this@GameActivity, R.color.wrong_color)
                    )
                }
                1 -> {
                    btn2.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this@GameActivity, R.color.wrong_color)
                    )
                }
                2 -> {
                    btn3.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this@GameActivity, R.color.wrong_color)
                    )
                }
                3 -> {
                    btn4.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this@GameActivity, R.color.wrong_color)
                    )
                }
            }

            when (currentQuestion.correctAnswerId) {
                0 -> {
                    btn1.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this@GameActivity, R.color.correct_color)
                    )
                }
                1 -> {
                    btn2.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this@GameActivity, R.color.correct_color)
                    )
                }
                2 -> {
                    btn3.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this@GameActivity, R.color.correct_color)
                    )
                }
                3 -> {
                    btn4.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this@GameActivity, R.color.correct_color)
                    )
                }
            }

            if (currentQuestionId != questions.lastIndex) {
                btnNext.text = getString(R.string.continue_text)
            } else {
                btnNext.text = getString(R.string.finish_text)
            }

            btn1.isEnabled = false
            btn2.isEnabled = false
            btn3.isEnabled = false
            btn4.isEnabled = false

            selectedAnswerId = -1
        }
    }
}