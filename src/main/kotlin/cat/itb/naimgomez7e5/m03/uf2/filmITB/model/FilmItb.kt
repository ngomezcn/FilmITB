package cat.itb.naimgomez7e5.m03.uf2.filmITB.model

import cat.itb.naimgomez7e5.m03.uf2.filmITB.ui.AppState
import java.net.URL
import cat.itb.naimgomez7e5.m03.uf2.filmITB.utils.*


class FilmItb {
        val films = mutableListOf<Film>();
        val filmsURL =
                "https://docs.google.com/spreadsheets/d/e/2PACX-1vSfwJrQbPwQX0EAB3O5t_hQ4IwKPaxDr7a4RELng1sMxKT7gSNIi0B-72w9jaRvpUGnvaYuMKuPwfSA/pub?output=csv";

        val users = mutableListOf<User>();
        val usersURL =
                "https://docs.google.com/spreadsheets/d/e/2PACX-1vQBtQVIUV6oTkkqvlWMpWfUTyLanzsYvApKh860-vClyei8_ZM-4yoYeWgGjMj_HEFpd1XoMxx3y0JX/pub?output=csv";

        /**
         * Main func to load data
         * */
        fun loadData() {
                loadDataFilm(filmsURL);
                loadDataUsers(usersURL);
        }

        private fun loadDataFilm(url: String) {
                val data = getCSVFromUrl(URL(url))

                if (data.hasNextLine()) data.nextLine() // Remove header CSV
                while (data.hasNextLine()) {
                        val values = data.nextLine().split(",")
                        val sValues = mutableListOf<String>()
                        val iValues = mutableListOf<Int>()
                        for (i in values) {
                                if (i.toIntOrNull() == null) {
                                        sValues.add(i);
                                } else {
                                        iValues.add(i.toInt())
                                }
                        }
                        films.add(Film(sValues, iValues));
                }
        }

        /**
         * Deletes the indicated film from the database
         */
        fun deleteFilm(film: Film) {
                films.removeAt(
                        films.indexOf(film)
                );
        }

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

        fun addFilmToWatchedFilms(film: Film): Film {

                AppState.currentUser.watchedFilms.add(film);
                return film
        }

        fun displayWatchedFilms(): MutableList<Film> {
                val list = mutableListOf<Film>()
                for (i in AppState.currentUser.watchedFilms.indices) {
                        list.add(AppState.currentUser.watchedFilms[i])
                }
                return list
        }

        fun addFavorites(film: Film): Film {
                for(i in AppState.currentUser.likedFilms.indices){
                        if(AppState.currentUser.likedFilms[i].title == film.title){
                                film.likes = film.likes + 1
                        }
                }
                AppState.currentUser.likedFilms.add(film)
                return film
        }

        fun showFavorites(): MutableList<Film> {
                val filmList = mutableListOf<Film>()
                for (liked in AppState.currentUser.likedFilms) {
                        filmList.add(liked)
                }
                return filmList;
        }

        fun likesPerFilm(): MutableList<Film> {
                val filmList = mutableListOf<Film>()
                for (liked in AppState.currentUser.likedFilms) {
                        filmList.add(liked)
                }
                return filmList;
        }

        /**
         * Creates a new user, all the fields of the User(...) constructor will be passed
         */
        fun addUser(name: String, lastName: String, age: Int) {
                users.add(
                        User(name, lastName, age)
                )
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
         * Load data from remote repo
         * */
        private fun loadDataUsers(url: String) {
                val data = getCSVFromUrl(URL(url))

                if (data.hasNextLine()) data.nextLine() // Remove header CSV
                while (data.hasNextLine()) {
                        val values = data.nextLine().split(",")
                        val sValues = mutableListOf<String>()
                        val iValues = mutableListOf<Int>()
                        for (i in values) {
                                if (i.toIntOrNull() == null) {
                                        sValues.add(i);
                                } else {
                                        iValues.add(i.toInt())
                                }
                        }
                        println("$sValues $iValues")
                        users.add(User(sValues, iValues));
                }
        }

        fun searchFilmByTitle(search: String): MutableList<Film> {

                val matchList = mutableListOf<Film>()
                for (film in films) {
                        if(film.title.lowercase().contains(search.lowercase()))
                        {
                                matchList.add(film);
                        }
                }
                return matchList
        }

        fun searchDirectorByDirectorName(search: String): MutableList<Film> {

                val matchList = mutableListOf<Film>()
                for (film in films) {
                        if(film.director.lowercase().contains(search.lowercase()))
                        {
                                matchList.add(film);
                        }
                }
                return matchList
        }

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

        fun searchFilmByMainGenere(search: String): MutableList<Film> {
                val matchList = mutableListOf<Film>()
                for (film in films) {
                        if(film.genere.lowercase().contains(search.lowercase()))
                        {
                                matchList.add(film);
                        }
                }
                return matchList
        }

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

        fun searchFilmByRecomended()
        {

        }
}