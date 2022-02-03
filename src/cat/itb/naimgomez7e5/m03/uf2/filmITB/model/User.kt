package cat.itb.naimgomez7e5.m03.uf2.filmITB.model

import cat.itb.naimgomez7e5.m03.uf2.filmITB.ui.AppState

data class User(
   // var id: Int,
    var name: String,
    var lastName: String,
    var age: Int){
    val likedFilms: List<String> = listOf()

    companion object {
        fun addUser(name: String, lastName: String, age: Int) {
            AppState.myUsers.add(
                User(name, lastName, age)
            )
            println("Usuari creat amb èxit!")
        }
        fun changeName(user: Int) {
            AppState.myUsers[user].name = AppState().inputString()
        }
        fun changeLast(user: Int) {
            AppState.myUsers[user].lastName = AppState().inputString()
        }
        fun changeAge(user: Int) {
            AppState.myUsers[user].age = AppState().inputInt()
        }
        fun deleteUser(user: Int){
            AppState.myUsers.removeAt(user)
        }
    }
}