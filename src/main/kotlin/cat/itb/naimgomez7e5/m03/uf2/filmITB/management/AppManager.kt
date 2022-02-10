package cat.itb.naimgomez7e5.m03.uf2.filmITB.management

import cat.itb.naimgomez7e5.m03.uf2.filmITB.model.FilmItb
import cat.itb.naimgomez7e5.m03.uf2.filmITB.model.User
import cat.itb.naimgomez7e5.m03.uf2.filmITB.ui.AppState
import java.net.URL
import java.net.URLConnection
import java.util.*


class AppManager {

    companion object {

        private val scan = Scanner(System.`in`)
        /**
         *
         * */
        fun containsCharInRange(s : String, min : Int, max : Int) : Boolean
        {
            for (char in s.iterator())
            {
                if(char.code < min || char.code > max)
                {
                    return false
                }
            }
            return true
        }

        fun isCurrentUser(user : User) : Boolean
        {
            if(AppState.currentUser == user)
            {
                return true
            }
            return false

        }

        fun isInValidRange(minRange: Int, maxRange: Int, toCheck: Int) : Boolean
        {
            if(toCheck < minRange)
                return false
            if(toCheck > maxRange)
                return false
            return true
        }

        /**
         * Interface to manage exit menu
         * */
        fun awaitEnter(msg: String = "Press enter to continue:") {
            print("$msg ")
            scan.nextLine()
        }

        /**
         * Get data from remote csv using an url
         * ! Return the CSV as Scanner
         * */
        fun getCSVFromUrl(url: URL): Scanner {
            val response: URLConnection = url.openConnection()
            return Scanner(response.getInputStream())
        }

        /**
         * Main func to load data
         * */
        fun loadData()
        {
            FilmManager.loadData(FilmItb.filmsURL);
            UserManager.loadData(FilmItb.usersURL);
        }
    }
}

