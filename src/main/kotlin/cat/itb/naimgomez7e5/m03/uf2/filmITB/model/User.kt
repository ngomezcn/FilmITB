package cat.itb.naimgomez7e5.m03.uf2.filmITB.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class User(var name: String, var lastName: String, var age: Int)
{
    val likedFilms: MutableList<Film> = mutableListOf()
    val watchedFilms: MutableList<Film> = mutableListOf()
}