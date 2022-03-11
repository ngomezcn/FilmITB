package cat.itb.naimgomez7e5.m03.uf2.filmITB.model

import kotlinx.serialization.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


import java.nio.file.*;

class FilmItbStorage {
    fun checkFileExist(name: String): Boolean {
        val path: Path
        path = Path("../data")
        val files : List<Path> = path.listirectoryEntries()
        /*val file = File("../data/$name")
        if(file.exists()){
            return true
        }
        return false*/
    }

    fun saveFilms(filmItb: FilmItb){
    }

    fun saveUsers(filmItb: FilmItb){
    }

    fun loadFilms(): MutableList<Film>{
        val loadedFilms = mutableListOf<Film>()
        return loadedFilms;
    }

    fun loadUsers(): MutableList<User>{
        val loadedUsers = mutableListOf<User>()
         Json.decodeFromString<MutableList<User>>("""
            {
              "users": [
                {
                  "name": "sara",
                  "lastName": "lopez",
                  "age": 13
                },
                {
                  "name": "manolito",
                  "lastName": "ferrer",
                  "age": 20
                }
              ]
            }
             """.trimIndent())
        return loadedUsers;
    }



}