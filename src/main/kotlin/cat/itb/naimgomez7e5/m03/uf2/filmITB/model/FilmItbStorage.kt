package cat.itb.naimgomez7e5.m03.uf2.filmITB.model

import kotlinx.serialization.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonPrimitive
import org.json.JSONObject
import java.io.File
import java.nio.file.Path
import java.nio.file.Files

import java.nio.file.*;
import kotlin.io.path.*

class FilmItbStorage {
    private val rootPath: Path = Paths.get("").toAbsolutePath()
    private val folderName: String = "data"
    private val folderPath =  rootPath.resolve(folderName);

    fun loadFilms(): MutableList<Film> {
        val films = mutableListOf<Film>();
        val filmsPath = folderPath.resolve("films.json");

        return if (Files.exists(filmsPath)) {
            val dataString = filmsPath.readText()
            val dataJson = Json.parseToJsonElement(dataString)

            for(i in dataJson.jsonArray.indices) {
                val film : Film = Json.decodeFromString(dataJson.jsonArray[i].toString())
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
            val dataJson = Json.parseToJsonElement(dataString)

            for(i in dataJson.jsonArray.indices) {
                val user : User = Json.decodeFromString<User>(dataJson.jsonArray[i].toString())
                users.add(user)
            }
            users;
        } else
        {
            println("Failed to load users! There are errors with the path $usersPath")
            users;
        }
    }

    fun saveFilms(films: List<Film>) : Boolean{
        val filmsPath = folderPath.resolve("films.json");
        return if (Files.exists(filmsPath)) {

            val filmsString = Json.encodeToString(films)
            filmsPath.writeText(filmsString)
            true
        } else {
            println("Failed to save users! There are errors with the path $filmsPath")
            false;
        }
    }

    fun saveUsers(users: List<User>): Boolean {
        val usersPath = folderPath.resolve("users.json")
        return if (Files.exists(usersPath)) {

            val usersString = Json.encodeToString(users)
            usersPath.writeText(usersString)
            true
        } else {
            println("Failed to save users! There are errors with the path $usersPath")
            false
        }
    }
}