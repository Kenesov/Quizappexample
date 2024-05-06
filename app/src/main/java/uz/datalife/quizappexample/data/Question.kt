package uz.datalife.quizappexample.data

data class Question(
    val id: Int,
    val question: String,
    val options: List<String>,
    val correctAnswerId: Int
)
