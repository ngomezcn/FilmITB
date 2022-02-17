package cat.itb.naimgomez7e5.m03.uf2.filmITB.test

import cat.itb.naimgomez7e5.m03.uf2.filmITB.model.*
import cat.itb.naimgomez7e5.m03.uf2.filmITB.ui.AppState
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.*

internal class FilmItbTest {

    val appState = AppState();

    @BeforeEach
    fun setUp() {
        appState.filmItb.addFilm("Shrek", "Carl Peter", "Fantasy", "Elijah Wood", "...", 13, 222)
        appState.filmItb.addFilm("Avatar", "James Cameron", "Sci-Fi", "Sam Worthington", "...", 7, 145)
        print(appState.filmItb.films)
        appState.filmItb.users.add(User("James", "Smith",12))
        appState.filmItb.users.add(User("Robert", "Taylor",25))
        appState.filmItb.users.add(User("Ricardo", "Lord",12))
        AppState.currentUser = User("Michel", "Trevor", 45)
    }

    @Test
    fun deleteFilm() {
        val film = appState.filmItb.films[0]
        appState.filmItb.deleteFilm(film)
        val expected = -1
        assertEquals(expected, appState.filmItb.films.indexOf(film))
    }

    @Test
    fun addFilm() {
        val expectedFilm = Film("Lorem", "Lorem", "Lorem", "Lorem", "Lorem", 1, 1)
        appState.filmItb.addFilm(expectedFilm.title, expectedFilm.director, expectedFilm.genere, expectedFilm.mainActor, expectedFilm.resume, expectedFilm.ageRating, expectedFilm.duration)
        assertEquals(expectedFilm.title, appState.filmItb.films.last().title)
        assertEquals(expectedFilm.director, appState.filmItb.films.last().director)
        assertEquals(expectedFilm.genere, appState.filmItb.films.last().genere)
        assertEquals(expectedFilm.mainActor, appState.filmItb.films.last().mainActor)
        assertEquals(expectedFilm.resume, appState.filmItb.films.last().resume)
        assertEquals(expectedFilm.ageRating, appState.filmItb.films.last().ageRating)
        assertEquals(expectedFilm.duration, appState.filmItb.films.last().duration)
    }

    @Test
    fun addFilmToWatchedFilms() {
        appState.filmItb.addFilmToWatchedFilms(appState.filmItb.films.last())
        assertEquals(appState.filmItb.films.last().title, AppState.currentUser.watchedFilms.last().title)
        assertEquals(appState.filmItb.films.last().director, AppState.currentUser.watchedFilms.last().director)
        assertEquals(appState.filmItb.films.last().genere, AppState.currentUser.watchedFilms.last().genere)
        assertEquals(appState.filmItb.films.last().mainActor, AppState.currentUser.watchedFilms.last().mainActor)
        assertEquals(appState.filmItb.films.last().resume, AppState.currentUser.watchedFilms.last().resume)
        assertEquals(appState.filmItb.films.last().ageRating, AppState.currentUser.watchedFilms.last().ageRating)
        assertEquals(appState.filmItb.films.last().duration, AppState.currentUser.watchedFilms.last().duration)
    }

    @Test
    fun displayWatchedFilms() {
        val list = appState.filmItb.displayWatchedFilms()
        assertEquals(list, AppState.currentUser.watchedFilms)
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
        val expectedUser = User("Manolo", "Escobar", 45)

        appState.filmItb.addUser(expectedUser.name,expectedUser.lastName, expectedUser.age  )
        assertEquals(expectedUser.name, appState.filmItb.users.last().name)
        assertEquals(expectedUser.lastName, appState.filmItb.users.last().lastName)
        assertEquals(expectedUser.age, appState.filmItb.users.last().age)

    }

    @Test
    fun changeName() {
        val expected = "Juan"
        appState.filmItb.changeName(expected);
        assertEquals(expected, AppState.currentUser.name)
    }

    @Test
    fun changeLastName() {
        val expected = "Gomez"
        appState.filmItb.changeLastName(expected);
        assertEquals(expected, AppState.currentUser.lastName)
    }

    @Test
    fun changeAge() {
        val expected = 24
        appState.filmItb.changeAge(expected);
        assertEquals(expected, AppState.currentUser.age)
    }

    @Test
    fun deleteUser() {
        val user = appState.filmItb.users.last()
        appState.filmItb.deleteUser(user)
        val expected = -1
        assertEquals(expected, appState.filmItb.users.indexOf(user))
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