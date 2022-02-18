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
        val expectedValue = appState.filmItb.displayWatchedFilms()
        assertEquals(expectedValue, AppState.currentUser.watchedFilms)
    }

    @Test
    fun addFavorites() {
        val expectedFilm = Film("Lorem", "Lorem", "Lorem", "Lorem", "Lorem", 1, 1)
        appState.filmItb.addFavorites(expectedFilm)
        assertEquals(expectedFilm, AppState.currentUser.likedFilms.last())
    }

    @Test
    fun showFavorites() {
        val expectedValue = AppState.currentUser.likedFilms
        assertEquals(expectedValue, appState.filmItb.showFavorites())

    }

    @Test
    fun likesPerFilm() {
        val film = appState.filmItb.films.last();
        AppState.currentUser.likedFilms.add(film)
        val expectedValue = film;
        assertEquals(expectedValue, appState.filmItb.likesPerFilm().last())
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
        val user = User("Snow", "Lanister", 84)
        appState.filmItb.users.add(user)
        assertEquals(null,  appState.filmItb.getUserByName("Paco"))
        assertEquals(user,  appState.filmItb.getUserByName("Snow"))
    }

    @Test
    fun searchFilmByTitle() {
        val film = Film("Avatar", "Not James Cameron", "Sci-Fi", "Sam Worthington", "...", 7, 145)
        appState.filmItb.films.add(film)

        assertEquals(0, appState.filmItb.searchFilmByTitle("Ibai").size)
        assertEquals(appState.filmItb.films.last(),  appState.filmItb.searchFilmByTitle("Avatar").last())
    }

    @Test
    fun searchDirectorByDirectorName() {
        val film = Film("Matrix", "Andrew Garfield", "Sci-Fi", "Brus", "...", 7, 145)
        appState.filmItb.films.add(film)

        assertEquals(0, appState.filmItb.searchDirectorByDirectorName("Ibai").size)
        assertEquals(appState.filmItb.films.last(),  appState.filmItb.searchDirectorByDirectorName("Andrew Garfield").last())
    }

    @Test
    fun searchFilmByMainActor() {
        val film = Film("Avatar", "Not James Cameron", "Sci-Fi", "Sam Worthington", "...", 7, 145)
        appState.filmItb.films.add(film)
        assertEquals(film,  appState.filmItb.searchFilmByMainActor("Sam Worthington").last())
        assertEquals(0,  appState.filmItb.searchFilmByMainActor("Ibai Llanos").size)
    }

    @Test
    fun searchFilmByMainGenere() {
        val film = Film("Avaastar", "Not Jameasds Cameron", "Sci-Fi", "Sam Wasdorthington", "...", 7, 145)
        appState.filmItb.films.add(film)
        assertEquals(film,  appState.filmItb.searchFilmByMainGenere("Sci-Fi").last())
        assertEquals(0,  appState.filmItb.searchFilmByMainGenere("awd").size)
    }

    @Test
    fun searchFilmByDuration() {
         val film = Film("Avadatar", "Not James Caasdmeron", "Sci-Fi", "Sam Worthington", "...", 7, 777)
        appState.filmItb.films.add(film)
        assertEquals(film,  appState.filmItb.searchFilmByDuration(777).last())
        assertEquals(0,  appState.filmItb.searchFilmByDuration(134234).size)
    }

    @Test
    fun searchFilmByNotWatched() {
        val expected = appState.filmItb.films.size - AppState.currentUser.watchedFilms.size
        assertEquals(expected,  appState.filmItb.searchFilmByNotWatched().size)
    }
}