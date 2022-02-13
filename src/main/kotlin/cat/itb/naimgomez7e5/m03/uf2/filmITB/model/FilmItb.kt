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
                        println("$sValues $iValues")
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
                val newFilm = FilmItb()
                newFilm.films.add(Film(title, director, genere, mainActor, resume, ageRating, duration))
        }

        fun watchedFilms(film: Film): Film {

                AppState.currentUser.watchedFilms.add(film);
                return film
        }

        fun displayWatchedFilms() {
                for (i in AppState.currentUser.watchedFilms.indices) {
                        println("$i ${AppState.currentUser.watchedFilms[i].title}")
                }
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

        fun showFavorites() {
                for (i in AppState.currentUser.likedFilms.indices) {
                        println("$i ${AppState.currentUser.likedFilms[i].title}")
                }
        }

        fun likesPerFilm() {
                for (i in AppState.currentUser.likedFilms.indices) {
                        println("$i ${AppState.currentUser.likedFilms[i].title} ${AppState.currentUser.likedFilms[i].likes}")
                }
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

        fun searchFilmByTitle(titleSearch: String): MutableList<Film> {

                val matchedFilms = mutableListOf<Film>()
                for (film in films) {
                        if (titleSearch.lowercase() == film.title.lowercase()) {
                                matchedFilms.add(film);
                        }
                }
                return matchedFilms
        }

        fun searchDirectorByFullName(nameSearch: String): MutableList<Film> {

                val matchedDirectors = mutableListOf<Film>()
                for (film in films) {
                        if (nameSearch.lowercase() == film.title) {
                                matchedDirectors.add(film);
                        }
                }
                return matchedDirectors
        }
}