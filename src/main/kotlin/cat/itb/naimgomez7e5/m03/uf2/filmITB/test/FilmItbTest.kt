package cat.itb.naimgomez7e5.m03.uf2.filmITB.test

import cat.itb.naimgomez7e5.m03.uf2.filmITB.model.*
import cat.itb.naimgomez7e5.m03.uf2.filmITB.model.FilmItb
import cat.itb.naimgomez7e5.m03.uf2.filmITB.model.User
import cat.itb.naimgomez7e5.m03.uf2.filmITB.ui.AppState
import org.junit.Test
import org.junit.jupiter.api.BeforeEach

internal class FilmItbTest {

    val appState = AppState();

    @BeforeEach
    fun setUp() {
        appState.filmItb.films.add(Film("Avatar", "James Cameron", "Sci-Fi", "Sam Worthington", "...", 7, 145, 5343))
        appState.filmItb.films.add(Film("Shrek", "Carl Peter", "Fantasy", "Elijah Wood", "...", 13, 222, 91235))
        appState.filmItb.users.add(User("James", "Smith",12))
        appState.filmItb.users.add(User("Robert", "Taylor",25))

        AppState.currentUser = User("Michel", "Trevor", 45)
    }

    @Test
    fun getFilms() {

    }

    @Test
    fun getFilmsURL() {
    }

    @Test
    fun getUsers() {
    }

    @Test
    fun getUsersURL() {
    }

    @Test
    fun loadData() {
    }

    @Test
    fun deleteFilm() {
    }

    @Test
    fun addFilm() {
    }

    @Test
    fun watchedFilms() {
    }

    @Test
    fun displayWatchedFilms() {
    }

    @Test
    fun addFavorites() {
    }

    @Test
    fun showFavorites() {
    }

    @Test
    fun likesPerFilm() {
    }

    @Test
    fun addUser() {
    }

    @Test
    fun changeName() {
    }

    @Test
    fun changeLastName() {
    }

    @Test
    fun changeAge() {
    }

    @Test
    fun deleteUser() {
    }

    @Test
    fun getUserByName() {
    }

    @Test
    fun searchFilmByTitle() {
    }

    @Test
    fun searchDirectorByDirector() {
    }

    @Test
    fun searchFilmByMainActor() {
    }

    @Test
    fun searchFilmByMainGenere() {
    }

    @Test
    fun searchFilmByDuration() {
    }

    @Test
    fun searchFilmByNotWatched() {

    }

    @Test
    fun searchFilmByRecomended() {

    }
}