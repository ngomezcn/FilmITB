package cat.itb.naimgomez7e5.m03.uf2.filmITB.model

import cat.itb.naimgomez7e5.m03.uf2.filmITB.ui.AppState

data class User(
   // var id: Int,
    val name: String,
    val lastName: String,
    val age: Int){
    val likedFilms: List<String> = listOf()


    companion object { // yoo que es esto
        fun addUser(name: String, lastName: String, age: Int) {
            AppState.myUsers.add(
                User(name, lastName, age)
            )
            println("Usuari creat amb èxit!")
        }
    }
}