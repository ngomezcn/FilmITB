package cat.itb.naimgomez7e5.m03.uf2.filmITB.management

import cat.itb.naimgomez7e5.m03.uf2.filmITB.model.Film
import cat.itb.naimgomez7e5.m03.uf2.filmITB.model.FilmItb
import cat.itb.naimgomez7e5.m03.uf2.filmITB.model.User
import cat.itb.naimgomez7e5.m03.uf2.filmITB.ui.UI
import java.net.URL
import java.net.URLConnection
import java.util.*


class AppManager {

    companion object {
        private val scan = Scanner(System.`in`)

        /**
         * Safe interface for string input
         * */
        private fun containsCharInRange(s : String, min : Int, max : Int) : Boolean
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

        /**
         * Safe interface for string input
         * */
        fun inputInt(msg: String = "Input:"): Int {
            print("$msg ")
            var rawInput = scan.nextLine().replace(" ", "")

            while (rawInput == "" || !containsCharInRange(rawInput, 48, 57))
            {
                print("$msg ")
                rawInput = scan.nextLine().replace(" ", "")
            }
            return rawInput.toInt()
        }

        /**
         * Safe interface for character string input
         * */
        fun inputString(msg: String = "Input:"): String {
            print("$msg ")
            var input = scan.nextLine().replace(" ", "")

            while (input == "")
            {
                print("$msg ")
                input = scan.nextLine()
            }
            return input
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

