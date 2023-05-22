package wikipedia.external.external

import wikipedia.external.external.entities.WikipediaArtist


interface WikipediaArticleService {
    fun getArtist(artistName: String): WikipediaArtist
}