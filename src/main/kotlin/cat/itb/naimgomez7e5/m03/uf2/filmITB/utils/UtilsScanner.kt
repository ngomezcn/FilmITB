package cat.itb.naimgomez7e5.m03.uf2.filmITB.utils

import cat.itb.naimgomez7e5.m03.uf2.filmITB.utils.*
import java.util.*

fun inputString(sc:Scanner, msg: String = "Input:"): String {
    print("$msg ")
    var input = sc.nextLine().replace(" ", "")

    while (input == "")
    {
        print("$msg ")
        input = sc.nextLine()
    }
    return input
}

fun inputInt(sc : Scanner, msg: String = "Input:"): Int {
    print("$msg ")
    var rawInput = sc.nextLine().replace(" ", "")

    while (rawInput == "" || !containsCharInASCIIRange(rawInput, 48, 57))
    {
        print("$msg ")
        rawInput = sc.nextLine().replace(" ", "")
    }
    return rawInput.toInt()
}
