package cat.itb.naimgomez7e5.m03.uf2.filmITB.model

data class Film(
    val id: Int,
    val title: String,
    val releaseDate: String,
    val director: String,
    val resume: String,
    val genders: List<String>,
    val ageRating: Int,
    val lenght: Int,
    val mainActor: String){
    val likes = 0

}