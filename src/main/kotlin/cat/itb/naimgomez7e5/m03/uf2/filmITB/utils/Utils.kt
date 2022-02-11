package cat.itb.naimgomez7e5.m03.uf2.filmITB.utils

import cat.itb.naimgomez7e5.m03.uf2.filmITB.management.AppManager
import cat.itb.naimgomez7e5.m03.uf2.filmITB.model.FilmItb
import java.net.URL
import java.net.URLConnection
import java.util.*
import kotlin.system.exitProcess

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

fun isInValidRange(minRange: Int, maxRange: Int, toCheck: Int) : Boolean
{
    if(toCheck < minRange)
        return false
    if(toCheck > maxRange)
        return false
    return true
}

fun exit(status : Int = 0)
{
    exitProcess(status);
}

/**
 * Get data from remote csv using an url
 * ! Return the CSV as Scanner
 * */
fun getCSVFromUrl(url: URL): Scanner {
    val response: URLConnection = url.openConnection()
    return Scanner(response.getInputStream())
}

fun readInputString( sc:Scanner, msg: String = "Input:"): String {
    print("$msg ")
    var input = sc.nextLine().replace(" ", "")

    while (input == "")
    {
        print("$msg ")
        input = sc.nextLine()
    }
    return input
}
fun inputInt(sc:Scanner, msg: String = "Input:"): Int {
    print("$msg ")
    var rawInput = sc.nextLine().replace(" ", "")

    while (rawInput == "" || !containsCharInRange(rawInput, 48, 57))
    {
        print("$msg ")
        rawInput = sc.nextLine().replace(" ", "")
    }
    return rawInput.toInt()
}

