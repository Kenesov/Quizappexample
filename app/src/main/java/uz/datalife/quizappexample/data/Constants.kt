package uz.datalife.quizappexample.data

object Constants {

    fun getQuastions(): List<Question>{

        return listOf(
            Question(1,"Informatsiya atamasi qanday so'zdan olmgan?",
                listOf("inform","information ","tinformatika","info"),2),
            Question(2,"Informatika so'zi dastlab qaysi davlatda vujudga kelgan?",
                listOf("Franciya","Germanoya","AQSH","Yaponiya"),3),
            Question(3, "Windows operatsion sistemasi nechanchi yilda ishlab chiqilgan? ",
                listOf("1985 yil","1992yil","1989yil","1990yil"),3),
            Question(4,"BIOSnima?", listOf("tezkor xotira","videoxotira","yarim doimiy xotira","doimiy xotira"),0),
            Question(5,"Ma'lumotlar ombori qaysi dasurda yaratiladi?",
                listOf("Microsoft Excel","Microsoft Word ","Microsoft Access", "Microsoft PowerPoint"),1),
            Question(6,"Sistema blokidagi parallel portlar nima deb ataladi?",
                listOf("COM","USB","LPT","PS/2"),2),
            Question(7,"Internetga qachon asos solingan?",
                listOf("1957 yilda","1958 yilda","1960 yilda","1969 yilda"),1),
            Question(8,"Server resurslaridan va xizmatidan fоydalanuvchi kоmpyuter qanday nоmlanadi?",
                listOf("Server","Prоtоkоl","Mijоz","Shlyuz"),0),
            Question(9,"Ikkilik sanоk sistemasida 10 ni 10 ga qo`shish nechaga teng?", listOf("20","100","110","10"),2),
            Question(10, "5 lik sanоq sistemasida 3+4 nechaga teng?", listOf("12","7","13","8"),2),
            Question(11,"Internetni o’rgatuvchi o’zbek tilidagi Web sahifa qachоn paydо bo’lgan?",
                listOf("1998","2000","1999","2001"),0),
            Question(12,"'O’zbekiston XXI asrga intilmoqda' iborasida necha bayt axborot bor?",
                listOf("32","29","31","34"),3),
            Question(13,"Diskka 1024 Kbayt axborot yozilgan, shu malumot necha Mbaytdan iborat?",
                listOf("1024","1048576","1","256"),3),
            Question(14,"HTML dasturlash tili nima?", listOf(
                "dasturlash tili emas","dasturlash tili","WWW dasturi","SQL tili"),1)
        )
        //Mirosoft Power Point dasturi qanday ishlar uchun muljallangan? Yo`qori darajadagi imkoniyatlarga ega bo’lgan hujjatlar tayyorlash muljallangan	Matematik amallarni va muhandislik xisob-kitoblarini bajarish uchun muljallangan	Turli ko’rinishdagi slayd va taqdimotlar yaratish uchun muljallangan	Ma’lumotlar bazasi bilan ishlash uchun mo’ljallangan

    }
}