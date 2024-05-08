package uz.datalife.quizappexample.data

object Constants {

    const val PREFS_NAME = "QuizappSettings"

    fun provideQuestions(): List<Question> {
        val questions = mutableListOf<Question>()

        questions.add(
            Question(
                id = 0,
                question = "Informatsiya atamasi qanday so'zdan olmgan?",
                answers = listOf("inform","information ","tinformatika","info"),
                correctAnswerId = 1
            )
        )

        questions.add(
            Question(
                id = 1,
                question = "Informatika so'zi dastlab qaysi davlatda vujudga kelgan?",
                answers = listOf("Franciya","Germanoya","AQSH","Yaponiya"),
                correctAnswerId = 2
            )
        )

        questions.add(
            Question(
                id = 2,
                question = "Windows operatsion sistemasi nechanchi yilda ishlab chiqilgan? ",
                answers = listOf("1985 yil","1992yil","1989yil","1990yil"),
                correctAnswerId = 0
            )
        )

        questions.add(
            Question(
                id = 3,
                question = "BIOSnima?",
                answers = listOf("tezkor xotira","videoxotira","yarim doimiy xotira","doimiy xotira"),
                correctAnswerId = 0
            )
        )

        questions.add(
            Question(
                id = 4,
                question = "Ma'lumotlar ombori qaysi dasurda yaratiladi?",
                answers = listOf("Microsoft Excel","Microsoft Word ","Microsoft Access", "Microsoft PowerPoint"),
                correctAnswerId = 0
            )
        )

        questions.add(
            Question(
                id = 5,
                question = "Sistema blokidagi parallel portlar nima deb ataladi?",
                answers = listOf("COM","USB","LPT","PS/2"),
                correctAnswerId = 0
            )
        )

        questions.add(
            Question(
                id = 6,
                question = "Internetga qachon asos solingan?",
                answers = listOf("1957 yilda","1958 yilda","1960 yilda","1969 yilda"),
                correctAnswerId = 0
            )
        )

        questions.add(
            Question(
                id = 7,
                question = "Server resurslaridan va xizmatidan fоydalanuvchi kоmpyuter qanday nоmlanadi?",
                answers = listOf("Server","Prоtоkоl","Mijоz","Shlyuz"),
                correctAnswerId = 0
            )
        )

        questions.add(
            Question(
                id = 8,
                question = "Ikkilik sanоk sistemasida 10 ni 10 ga qo`shish nechaga teng?",
                answers = listOf("20","100","110","10"),
                correctAnswerId = 0
            )
        )

        questions.add(
            Question(
                id = 9,
                question = "5 lik sanоq sistemasida 3+4 nechaga teng?",
                answers = listOf("12","7","13","8"),
                correctAnswerId = 1
            )
        )

        questions.add(
            Question(
                id = 10,
                question = "Internetni o’rgatuvchi o’zbek tilidagi Web sahifa qachоn paydо bo’lgan?",
                answers = listOf("1998","2000","1999","2001"),
                correctAnswerId = 1
            )
        )

        return questions
    }

}