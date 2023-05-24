# AyDS-Winchester1-Wikipedia

Para importar el submódulo, se debe ejecutar el siguiente comando en la línea de comandos (CMD) mientras se encuentra ubicado en la carpeta del proyecto en la ruta ".../libs".

    git submodule add https://github.com/MateChola/AyDS-Winchester1-Wikipedia.git WikipediaExternal
 

# Utilización del submodulo

Para obtener una instancia del servicio externo, es necesario realizar una llamada al inyector utilizando la función "generateWikipediaService()", como se muestra en el siguiente ejemplo:

    val wikipediaArticleService = WikipediaInjector.generateWikipediaService()


Una vez obtenida la instancia del servicio, es posible acceder a la obtención de información relacionada con artistas.
Para obtener un objeto asociado a un artista en particular, se debe llamar a la función "getArtist()" de la clase "WikipediaArticleService" como se ejemplifica a continuación:

    val wikipediaArtist = wikipediaArticleService.getArtist(artistName)

La función getArtist recibe como parámetro un string con el nombre del artista. En caso de que se encuentre el artista correspondiente, se devuelve un objeto de tipo "WikipediaArtist" que contiene la información del mismo. De lo contrario, se retorna "null".

"WikipediaArtist" contiene lo siguiente:
- name: Representa el nombre del artista y se almacena como una cadena de texto.
- artistInfo: Contiene información sobre el artista y se guarda como una cadena de texto. 
- wikipediaUrl: Almacena la URL de la página de Wikipedia asociada al artista. Se guarda como una cadena de texto.
- isInDataBase: Es un indicador booleano que especifica si el artista se encuentra en la base de datos. Su valor puede ser verdadero o falso.
