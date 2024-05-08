package uz.datalife.quizappexample.data

data class Question(
    val id: Int,
    val question: String,
    val answers: List<String>,
    val correctAnswerId: Int
)
