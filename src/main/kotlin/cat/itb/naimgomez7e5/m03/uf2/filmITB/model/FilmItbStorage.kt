package cat.itb.naimgomez7e5.m03.uf2.filmITB.model

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonArray
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.io.path.readText
import kotlin.io.path.writeText

/**
 * YOU CAN FIND THE EXAMPLE DATA FOLDER IN THE ROOT OF THIS REPO, the name of the folder is data/, contains two files data/films.json and data/users.json.
 */

class FilmItbStorage {
    private val homePath: Path = Paths.get(System.getProperty("user.home"))
    private val folderName: String = "data"
    private val folderPath =  homePath.resolve(folderName);

    /**
     * Parse json file to json array and fill a list with the films
     * @return MutableList<Film>
     */
    fun loadFilms(): MutableList<Film> {

        val films = mutableListOf<Film>();
        val filmsPath = folderPath.resolve("films.json");

        return if (Files.exists(filmsPath)) {
            val dataString = filmsPath.readText()
            if(dataString.isEmpty())
            {
                println("There is no data in films.json!\n")
                films
            }
            else {
                val dataJson = Json.parseToJsonElement(dataString)

                for(jsonUser in dataJson.jsonArray) {
                    val film : Film = Json.decodeFromString(jsonUser.toString())
                    films.add(film)
                }
                films;
            }

        } else {
            println("Failed to load users! There are errors with the path $filmsPath")
            films;
        }
    }

    /**
     * Parse json file to json array and fill a list with the users
     * @return MutableList<Users>
     */
    fun loadUsers(): MutableList<User> {

        val users = mutableListOf<User>();
        val usersPath = folderPath.resolve("users.json");

        return if (Files.exists(usersPath)) {
            val dataString = usersPath.readText()
            if(dataString.isEmpty())
            {
                println("There is no data in users.json!\n")
                users;
            }
            else {
                val dataJson = Json.parseToJsonElement(dataString)

                for(jsonFilm in dataJson.jsonArray) {
                    val user : User = Json.decodeFromString<User>(jsonFilm.toString())
                    users.add(user)
                }
                users;
            }


        } else
        {
            println("Failed to load users! There are errors with the path $usersPath")
            users;
        }
    }

    /**
     * Overwrite the .json and save the new films data
     * @return Boolean
     */
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

    /**
     * Overwrite the .json and save the new users data
     * @return Boolean
     */
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