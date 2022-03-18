package cat.itb.naimgomez7e5.m03.uf2.filmITB.model

import kotlinx.serialization.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import org.json.JSONObject
import java.io.File
import java.nio.file.Path
import kotlin.io.path.Path
import java.nio.file.Files

import java.nio.file.*;
import kotlin.io.path.listDirectoryEntries
import kotlin.io.path.readLines
import kotlin.io.path.readText

class FilmItbStorage {
    private val rootPath: Path = Paths.get("").toAbsolutePath()
    private val folderName: String = "data"
    private val folderPath =  rootPath.resolve(folderName);

    fun loadFilms(): MutableList<Film> {
        val films = mutableListOf<Film>();
        val filmsPath = folderPath.resolve("films.json");

        return if (Files.exists(filmsPath)) {
            val dataString = filmsPath.readText()
            val dataJson = JSONObject(dataString)

            val jsonArray = dataJson.getJSONArray("films")
            for(jsonUser in jsonArray) {
                val film : Film = Json.decodeFromString<Film>(jsonUser.toString())
                films.add(film)
            }
            films;
        } else {
            println("Failed to load users! There are errors with the path $filmsPath")
            films;
        }
    }

    fun loadUsers(): MutableList<User> {

        val users = mutableListOf<User>();
        val usersPath = folderPath.resolve("users.json");

        return if (Files.exists(usersPath)) {
            val dataString = usersPath.readText()
            val dataJson = JSONObject(dataString);
            val jsonArray = dataJson.getJSONArray("users");

            for(jsonUser in jsonArray) {
                 val user : User = Json.decodeFromString<User>(jsonUser.toString())
                 users.add(user);
            }

            users;
        } else
        {
            println("Failed to load users! There are errors with the path $usersPath")
            users;
        }
    }

    fun saveFilms() : Boolean{
        val filmsPath = folderPath.resolve("users.json");
        return if (Files.exists(filmsPath)) {


            true
        } else {
            println("Failed to save users! There are errors with the path $filmsPath")
            false;
        }
    }

    fun saveUsers(){

    }
}