package cat.itb.naimgomez7e5.m03.uf2.filmITB.ui

import cat.itb.naimgomez7e5.m03.uf2.filmITB.ui.*


class SearchUI {
    fun showMenu()
    {
        println("Search methods:")
        println("1: By title")
        println("2: By director")
        println("4: By genere")
        println("5: By length")
        println("6: Not watched")
        println("7: Recomended")
        println("0: Return to main menu")

        when(AppState().inputInt()) {
            1 ->
        }
    }
}