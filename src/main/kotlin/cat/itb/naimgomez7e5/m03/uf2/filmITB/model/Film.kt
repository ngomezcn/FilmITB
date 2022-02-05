package cat.itb.naimgomez7e5.m03.uf2.filmITB.model

class Film(
    val title: String,
    val director: String,
    val genere: String,
    val mainActor: String,
    val resume: String,
    val ageRating: Int,
    val duration: Int,
){
    constructor(sValues: List<String>, iValues: List<Int>) :
            this(
                sValues[0], sValues[1], sValues[2], sValues[3], sValues[4],
                iValues[0], iValues[1]);
}

