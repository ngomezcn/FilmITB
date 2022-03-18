package cat.itb.naimgomez7e5.m03.uf2.filmITB.ui

import cat.itb.naimgomez7e5.m03.uf2.filmITB.model.FilmItb
import java.util.*
import kotlin.system.exitProcess
import cat.itb.naimgomez7e5.m03.uf2.filmITB.utils.*
import cat.itb.naimgomez7e5.m03.uf2.filmITB.model.FilmItbStorage
import java.nio.file.Paths

/**
 * The main interface *UI*.
 *
 * This class is the entry point of all program,
 * manage all the calls to the other classes and functions.
 *
 * @author Mgarcia & Ngomez
 * @see The demo data of is loaded from: https://drive.google.com/drive/folders/1ZlpA5C8LNe2BCB_bIqz1XHsx-nwZm48M?usp=sharing
 * @sample UI.start()
 */
class UI {
    private var appState = AppState();

    private val scan = Scanner(System.`in`);
    private var userUI = UserUI(scan, appState);
    private var filmUI = FilmUI(scan, appState);
    private var searchUI = SearchUI(scan, appState);
    private var loginUI = LoginUI(scan, appState);

    /**
     * Entry point of the all, must by called by main()
     */
    fun start() {
        loginUI.showLoginMenu()
        showMainMenu();
    }

    /**
     * Display main menu until and call sub-menu functions until users exit
     */
    private fun showMainMenu()
    {
        println("Welcome ${AppState.currentUser.name} to FilmsITB")
        println("1: User")
        println("2: Films")
        println("3: Search")
        println("0: Exit")
        userUI = UserUI(scan, appState);
        filmUI = FilmUI(scan, appState);
        searchUI = SearchUI(scan, appState);
        appState = when(inputInt(scan)) {
            1 -> userUI.showUsersMenu();
            2 -> filmUI.showFilmMenu();
            3 -> searchUI.showSearchMenu();
            0 -> return;
            else -> {
                return;
            }
        }
        showMainMenu()
    }

    /**
     * Stops the execution of the program with return 0 by default
     */
    fun exit(status : Int = 0)
    {
        exitProcess(status);
    }
}
fun main()
{
    UI().start()
}
