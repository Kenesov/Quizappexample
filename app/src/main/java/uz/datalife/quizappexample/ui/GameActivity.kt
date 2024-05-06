package uz.datalife.quizappexample.ui

import android.content.Intent
import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import uz.datalife.quizappexample.R
import uz.datalife.quizappexample.data.Constants
import uz.datalife.quizappexample.data.Question
import uz.datalife.quizappexample.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameBinding
    private lateinit var questions: MutableList<Question>
    private lateinit var currentQuestion: Question
    private var selectedOptionId = 0
    private var step = 0
    private var correctAnswersCounter = 0
    private lateinit var name: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent.getStringExtra("name")?.let {
            name = it
        }

        questions = Constants.getQuastions().toMutableList()
        questions.shuffle()

        setQuestion(step)


        binding.apply {
            btn1.setOnClickListener {
                setSelectedOption(1)
                selectedOptionId = 1
            }
            btn2.setOnClickListener {
                setSelectedOption(2)
                selectedOptionId = 2
            }
            btn3.setOnClickListener {
                setSelectedOption(3)
                selectedOptionId = 3
            }
            btn4.setOnClickListener {
                setSelectedOption(4)
                selectedOptionId = 4
            }

            toolbarLayout

            btnBack.setOnClickListener {
                val intent = Intent(this@GameActivity, MainActivity::class.java)
                startActivity(intent)

            }

            btnNext.setOnClickListener {
                if (btnNext.text == getString(R.string.submit)) {
                    if (selectedOptionId != 0) {
                        checkAnswer()
                        step++
                        if (step == questions.size) {
                            btnNext.text = getString(R.string.finish_text)
                        }
                    } else {
                        step++
                        if (step == questions.size) {
                            btnNext.text = getString(R.string.finish_text)
                        } else {
                            setQuestion(step)
                        }
                    }
                } else if (btnNext.text == getString(R.string.finish_text)) {
                    Toast.makeText(this@GameActivity, "Game over", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@GameActivity, ResaltActivity::class.java)
                    intent.putExtra("name", name)
                    intent.putExtra("score", correctAnswersCounter)
                    startActivity(intent)
                    finish()
                } else {
                    setQuestion(step)
                    btnNext.text = getString(R.string.submit)
                }
            }
        }
    }

    private fun setQuestion(index: Int) {
        currentQuestion = questions[index]

        binding.apply {
            btn1.backgroundTintList =
                ColorStateList.valueOf(ContextCompat.getColor(this@GameActivity, R.color.white))
            btn2.backgroundTintList =
                ColorStateList.valueOf(resources.getColor(R.color.white))
            btn3.backgroundTintList =
                ColorStateList.valueOf(resources.getColor(R.color.white))
            btn4.backgroundTintList =
                ColorStateList.valueOf(resources.getColor(R.color.white))

            questionText.text = currentQuestion.question
            btn1.text = currentQuestion.options[0]
            btn2.text = currentQuestion.options[1]
            btn3.text = currentQuestion.options[2]
            btn4.text = currentQuestion.options[3]
        }

        changeOptionsBehavior(true)
        selectedOptionId = 0
    }

    private fun setSelectedOption(selectedOptionId: Int) {
        binding.apply {
            btn1.backgroundTintList =
                ColorStateList.valueOf(resources.getColor(R.color.white))
            btn2.backgroundTintList =
                ColorStateList.valueOf(resources.getColor(R.color.white))
            btn3.backgroundTintList =
                ColorStateList.valueOf(resources.getColor(R.color.white))
            btn4.backgroundTintList =
                ColorStateList.valueOf(resources.getColor(R.color.white))

            when (selectedOptionId) {
                1 -> btn1.backgroundTintList =
                    ColorStateList.valueOf(resources.getColor(R.color.selected_color))
                2 -> btn2.backgroundTintList =
                    ColorStateList.valueOf(resources.getColor(R.color.selected_color))
                3 -> btn3.backgroundTintList =
                    ColorStateList.valueOf(resources.getColor(R.color.selected_color))
                4 -> btn4.backgroundTintList =
                    ColorStateList.valueOf(resources.getColor(R.color.selected_color))
            }
        }
    }

    private fun checkAnswer() {
        binding.apply {
            when (selectedOptionId) {
                1 -> btn1.backgroundTintList =
                    ColorStateList.valueOf(resources.getColor(R.color.wrong_color))
                2 -> btn2.backgroundTintList =
                    ColorStateList.valueOf(resources.getColor(R.color.wrong_color))
                3 -> btn3.backgroundTintList =
                    ColorStateList.valueOf(resources.getColor(R.color.wrong_color))
                4 -> btn4.backgroundTintList =
                    ColorStateList.valueOf(resources.getColor(R.color.wrong_color))
            }

            when (currentQuestion.correctAnswerId + 1) {
                1 -> btn1.backgroundTintList =
                    ColorStateList.valueOf(resources.getColor(R.color.correct_color))
                2 -> btn2.backgroundTintList =
                    ColorStateList.valueOf(resources.getColor(R.color.correct_color))
                3 -> btn3.backgroundTintList =
                    ColorStateList.valueOf(resources.getColor(R.color.correct_color))
                4 -> btn4.backgroundTintList =
                    ColorStateList.valueOf(resources.getColor(R.color.correct_color))
            }

            if (selectedOptionId == currentQuestion.correctAnswerId + 1) {
                correctAnswersCounter++
            }

            changeOptionsBehavior(false)
            btnNext.text = getString(R.string.continue_text)
        }
    }

    private fun changeOptionsBehavior(enabled: Boolean) {
        binding.apply {
            btn1.isEnabled = enabled
            btn2.isEnabled = enabled
            btn3.isEnabled = enabled
            btn4.isEnabled = enabled
        }


    }
}