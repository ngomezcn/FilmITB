package cat.itb.naimgomez7e5.m03.uf2.filmITB.model

import cat.itb.naimgomez7e5.m03.uf2.filmITB.ui.AppState
import java.net.URL
import cat.itb.naimgomez7e5.m03.uf2.filmITB.utils.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class FilmItb {

    private val filmItbStorage = FilmItbStorage();
    val films = filmItbStorage.loadFilms();
    val users = filmItbStorage.loadUsers()

    fun saveData() {
        filmItbStorage.saveUsers(users)
        filmItbStorage.saveFilms(films)
    }

    /**
     * Deletes the indicated film from the database
     */
    fun deleteFilm(film: Film) {
        films.removeAt(
            films.indexOf(film)
        )
    }

    /**
     *  Add a new film by passing one by one attributes
     */
    fun addFilm(
        title: String,
        director: String,
        genere: String,
        mainActor: String,
        resume: String,
        ageRating: Int,
        duration: Int
    ) {
        films.add(Film(title, director, genere, mainActor, resume, ageRating, duration, 0))
    }

    /**
     * Add the indicated film to the currenstUser wachtedFilms
     */
    fun addFilmToWatchedFilms(film: Film): Film {

        AppState.currentUser.watchedFilms.add(film);
        return film
    }

    /**
     * Returns a List<Film> of movies the currentuser has seen
     */
    fun displayWatchedFilms(): List<Film> {
        val list = mutableListOf<Film>()
        for (i in AppState.currentUser.watchedFilms.indices) {
            list.add(AppState.currentUser.watchedFilms[i])
        }
        return list
    }

    /**
     * Adds the indicated movie to the favorite movies of the currentuser
     * and increment the likes of the film by one
     */
    fun addFavorites(film: Film): Film {
        for(i in AppState.currentUser.likedFilms.indices){
            if(AppState.currentUser.likedFilms[i].title == film.title){
                film.likes = film.likes + 1
            }
        }
        AppState.currentUser.likedFilms.add(film)
        return film
    }

    /**
     * Return a List<Film> with favorites films of the currentuser
     */
    fun showFavorites(): List<Film> {
        val filmList = mutableListOf<Film>()
        for (liked in AppState.currentUser.likedFilms) {
            filmList.add(liked)
        }
        return filmList;
    }

    /**
     * Return a List<Film> with the films who currentuser liked
     */
    fun likesPerFilm(): MutableList<Film> {
        return films;
    }

    /**
     * Creates a new user and add to list of users
     */
    fun addUser(name: String, lastName: String, age: Int) {
        var user = User(name, lastName, age)
        users.add(user)
    }

    /**
     * By default, changes the field name of the currentUser
     */
    fun changeName(newName: String, user: User = AppState.currentUser) {
        user.name = newName;
    }

    /**
     * By default, changes the field name of the currentUser
     */
    fun changeLastName(newLastName: String, user: User = AppState.currentUser) {
        user.lastName = newLastName;
    }

    /**
     * By default, changes the field age of the currentUser
     */
    fun changeAge(newAge: Int, user: User = AppState.currentUser) {
        user.age = newAge;
    }

    /**
     * Deletes the indicated user from the database
     */
    fun deleteUser(user: User) {

        users.removeAt(
            users.indexOf(user)
        );
    }

    /**
     * Find user by name.
     */
    fun getUserByName(indicatedName: String): User? {
        for (user in users) {
            if (user.name.lowercase() == indicatedName.lowercase()) {
                return user;
            }
        }
        return null;
    }



    /**
     * Return a List<Film> with the films that match with the search
     */
    fun searchFilmByTitle(search: String): List<Film> {

        val matchList = mutableListOf<Film>()
        for (film in films) {
            if(film.title.lowercase().contains(search.lowercase()))
            {
                matchList.add(film);
            }
        }
        return matchList
    }

    /**
     * Return a List<Film> with the films that match with the search
     */
    fun searchDirectorByDirectorName(search: String): List<Film> {

        val matchList = mutableListOf<Film>()
        for (film in films) {
            if(film.director.lowercase().contains(search.lowercase()))
            {
                matchList.add(film);
            }
        }
        return matchList
    }

    /**
     * Return a List<Film> with the films that match with the search
     */
    fun searchFilmByMainActor(search: String): MutableList<Film> {
        val matchList = mutableListOf<Film>()
        for (film in films) {
            if(film.mainActor.lowercase().contains(search.lowercase()))
            {
                matchList.add(film);
            }
        }
        return matchList
    }

    /**
     * Return a List<Film> with the films that match with the search
     * @return a list of films of genre search
     */
    fun searchFilmByMainGenere(genreToSearch: String): MutableList<Film> {
        val matchList = mutableListOf<Film>()
        for (film in films) {
            if(film.genere.lowercase().contains(genreToSearch.lowercase()))
            {
                matchList.add(film);
            }
        }
        return matchList
    }

    /**
     * Return a List<Film> with the films that match with the search
     */
    fun searchFilmByDuration(search: Int): MutableList<Film> {
        val matchList = mutableListOf<Film>()
        for (film in films) {
            if(film.duration == search)
            {
                matchList.add(film);
            }
        }
        return matchList
    }

    /**
     * Return a List<Film> with the films that match with the search
     */
    fun searchFilmByNotWatched(): MutableList<Film>
    {
        val matchList = mutableListOf<Film>()
        for (film in films) {
            if(film !in AppState.currentUser.watchedFilms)
            {
                matchList.add(film);
            }
        }
        return matchList
    }

}