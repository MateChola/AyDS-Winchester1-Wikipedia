package wikipedia.external.external.entities

data class WikipediaArtist(
    val name : String,
    var artistInfo : String,
    var wikipediaUrl: String,
    var isInDataBase : Boolean
)