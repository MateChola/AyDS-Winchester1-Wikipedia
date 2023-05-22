package wikipedia.external.external.article

import wikipedia.external.external.WikipediaArticleService
import retrofit2.Response
import wikipedia.external.external.entities.WikipediaArtist

internal class WikipediaArticleServiceImpl(
    private val wikipediaAPI : WikipediaAPI,
    private val wikipediaToArtistResolver : WikipediaToArtistResolver,
): WikipediaArticleService {

    override fun getArtist(artistName: String): WikipediaArtist {
        val callResponse = getArtistInfoFromService(artistName)
        return WikipediaArtist(
            name = artistName,
            artistInfo = getArtistInfo(artistName, callResponse),
            wikipediaUrl = getArticleUrl(artistName, callResponse),
            isInDataBase = false
        )
    }

    private fun getArtistInfoFromService(artistName: String): Response<String> {
        return wikipediaAPI.getArtistInfo(artistName).execute()
    }
    private fun getArtistInfo(artistName: String, callResponse: Response<String>): String{
        return wikipediaToArtistResolver.getArtistInfo(artistName, callResponse)
    }

    private fun getArticleUrl(artistName: String, callResponse: Response<String>): String{
        return wikipediaToArtistResolver.getArticleUrl(artistName, callResponse)
    }


}