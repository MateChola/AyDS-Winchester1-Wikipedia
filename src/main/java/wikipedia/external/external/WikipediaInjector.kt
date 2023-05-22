package wikipedia.external.external

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import wikipedia.external.external.article.WikipediaArticleServiceImpl
import wikipedia.external.external.article.WikipediaToArtistResolver
import wikipedia.external.external.article.WikipediaToArtistResolverImpl

private const val WIKIPEDIA_BASE_URL = "https://en.wikipedia.org/w/"

object WikipediaInjector {

     fun generateWikipediaService(): WikipediaArticleService {
        val wikipediaAPI = createWikipediaAPI()
        val wikipediaToArtistResolver : WikipediaToArtistResolver =
            WikipediaToArtistResolverImpl()
        return WikipediaArticleServiceImpl(
            wikipediaAPI,
            wikipediaToArtistResolver
        )
    }

    private fun createWikipediaAPI(): wikipedia.external.external.article.WikipediaAPI {
        val retrofit = createRetrofit()
        return retrofit.create(wikipedia.external.external.article.WikipediaAPI::class.java)
    }
    private fun createRetrofit() = Retrofit.Builder().baseUrl(WIKIPEDIA_BASE_URL).addConverterFactory(
        ScalarsConverterFactory.create()).build()

}