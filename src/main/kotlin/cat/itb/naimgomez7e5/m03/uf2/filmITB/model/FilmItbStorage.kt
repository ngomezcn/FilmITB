package cat.itb.naimgomez7e5.m03.uf2.filmITB.model

import kotlinx.serialization.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.nio.file.Path
import kotlin.io.path.Path

import java.nio.file.*;

class FilmItbStorage {
    fun checkFileExist(name: String): Boolean {

        val path = Path("asdsd/asdasd");

        //val files : List<Path> = path.listirectoryEntries()
        /*val file = File("../data/$name")
        if(file.exists()){
            return true
        }
        return false*/

        return true
    }

    fun saveFilms(filmItb: FilmItb){
    }

    fun saveUsers(filmItb: FilmItb){
    }

    fun loadFilms(): MutableList<Film> {
        return mutableListOf<Film>();
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