package cat.itb.naimgomez7e5.m03.uf2.filmITB.model

data class User(
   // var id: Int,
    val name: String,
    val lastName: String,
    val age: Int){
    val likedFilms: List<String> = listOf()
}