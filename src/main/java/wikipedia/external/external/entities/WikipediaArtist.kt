package wikipedia.external.external.entities

const val WIKIPEDIA_LOGO = "https://upload.wikimedia.org/wikipedia/commons/8/8c/Wikipedia-logo-v2-es.png"
data class WikipediaArtist(
    val name : String,
    var artistInfo : String,
    var wikipediaUrl: String,
    var isInDataBase : Boolean
)