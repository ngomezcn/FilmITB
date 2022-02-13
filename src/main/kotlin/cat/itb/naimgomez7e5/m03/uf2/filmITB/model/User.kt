package cat.itb.naimgomez7e5.m03.uf2.filmITB.model

data class User(var name: String, var lastName: String, var age: Int)
{
    val likedFilms: MutableList<Film> = mutableListOf()
    val watchedFilms: MutableList<Film> = mutableListOf()

    constructor(sValues: List<String>, iValues: List<Int>) :
            this(sValues[0], sValues[1], iValues[0])
}