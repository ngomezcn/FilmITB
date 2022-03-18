package cat.itb.naimgomez7e5.m03.uf2.filmITB.model
import kotlinx.serialization.Serializable

import cat.itb.naimgomez7e5.m03.uf2.filmITB.ui.UI

/**
 * The main model of films *Film*.
 *
 * This class has only has the attributes of a film
 *
 * @author Mgarcia & Ngomez
 * @property likes: By default it is instantiated at 0
 */
@Serializable
class Film(
    val title: String,
    val director: String,
    val genere: String,
    val mainActor: String,
    val resume: String,
    val ageRating: Int,
    val duration: Int,
    var likes: Int = 0,
)
