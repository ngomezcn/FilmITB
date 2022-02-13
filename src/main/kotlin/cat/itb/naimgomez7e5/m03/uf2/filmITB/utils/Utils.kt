package cat.itb.naimgomez7e5.m03.uf2.filmITB.utils

import cat.itb.naimgomez7e5.m03.uf2.filmITB.model.User
import cat.itb.naimgomez7e5.m03.uf2.filmITB.ui.AppState
import java.net.URL
import java.net.URLConnection
import java.util.*

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
     * Get data from remote csv using an url
     * ! Return the CSV as Scanner
     * */
    fun getCSVFromUrl(url: URL): Scanner {
        val response: URLConnection = url.openConnection()
        return Scanner(response.getInputStream())
    }

