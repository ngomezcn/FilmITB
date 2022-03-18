package cat.itb.naimgomez7e5.m03.uf2.filmITB.utils

import cat.itb.naimgomez7e5.m03.uf2.filmITB.model.User
import cat.itb.naimgomez7e5.m03.uf2.filmITB.ui.AppState
import java.net.URL
import java.net.URLConnection
import java.util.*

    /**
     * Check if argument char() is in valid a..b ASCII  range
     */
    fun containsCharInASCIIRange(s : String, min : Int, max : Int) : Boolean
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
     *  Check if argument user() is the current logged user
     */
    fun isCurrentUser(user : User) : Boolean
    {
        if(AppState.currentUser == user)
        {
            return true
        }
        return false

    }

    /**
     * Check if int is in indicated range
     */
    fun isInValidRange(minRange: Int, maxRange: Int, toCheck: Int) : Boolean
    {
        if(toCheck < minRange)
            return false
        if(toCheck > maxRange)
            return false
        return true
    }

