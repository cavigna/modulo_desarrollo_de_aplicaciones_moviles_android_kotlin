# MODULO 4 | Desarrollo de Aplicaciones Móviles Android Kotlin | Ignacio Cavallo



https://github.com/cavigna/modulo_desarrollo_de_aplicaciones_moviles_android_kotlin

## Clase 102 | 23-11 | Evaluación del Módulo

Luego de un milenio de clases, finalmente llegamos a la instancia del módulo final

##### https://github.com/cavigna/DogsPics



> Realizar una aplicación Android Kotlin de Noticias. Esta aplicación debe contar con un buscador que nos permita presentar distintas noticias relacionadas a la búsqueda realizada, además agregar un botón que permita compartir las noticias. Las noticias se deben mostrar con una imagen que tendrá asociada una url que nos debe llevar a cada noticia. Se recomienda agregar las dependencias necesarias para hacer las peticiones, agregar librerías ya sea para imágenes (Picasso) o para ejecutar acciones en segundo plano (Anko). Finalmente debe compilar y empaquetar el proyecto.


A su vez, tambien existe esta información en la página:

>  Debe ser capaz de conectarse a un servicio REST y consumir datos.
● Debe mostrar un listado de información obtenida desde el servicio Rest
● Debe utilizar alguna técnica de caching (Persistencia local)
● Debe permitir modificar o almacenar los favoritos de ese listado.
● El usuario podrá ver un listado de los favoritos seleccionados obtenidos desde la persistencia local
● Usar MVVM + Retrofit + ROOM




Por lo que decidí hacer lo siguiente: 

### **Hacer las dos apps, con el objetivo de aplicar todo lo aprendido durante del curso.**



Ambas utilizarán el patron de diseño MVVM, como también uso de persistencia de datos.

### MVVM

<image src= "./images/mvvm.png" height="500px" alignment= "center">

Como se puede observar, la vista requerirá información la cual será solicitará al *View Model* y este a su vez llamará al repositorio.

## News App

api = https://newsapi.org/

### 1 - Modelo

Si una llamada típica a la API, nos devuelve lo siguiente:
```json
{
"status": "ok",
"totalResults": 9543,
"articles": [
    {
    "source": {
    "id": "business-insider",
    "name": "Business Insider"
    },
        "author": "mfox@businessinsider.com (Matthew Fox)",
        "title": "US stocks end mixed as yields jump after Biden picks Jerome Powell to lead the Fed for a 2nd term",
        "description": "\"The nomination of Powell and Brainard suggest continuity at the Fed given that they have generally been in alignment,\" Bank of America said.",
        "url": "https://markets.businessinsider.com/news/stocks/stock-market-news-today-biden-picks-jerome-powell-fed-chairman-2021-11",
        "urlToImage": "https://images2.markets.businessinsider.com/619c011963e3f300187545ce?format=jpeg",
        "publishedAt": "2021-11-22T21:16:11Z",
        "content": "Federal Reserve Chair Jerome Powell listens as President Joe Biden nominates him for a second four-year term.Kevin Lamarque/Reuters\r\n<ul><li>US stocks ended mixed on Monday after President Biden nomi… [+3016 chars]"
    },
    {...}
```

Entonces tendriamos los siguientes modelos:
```kotlin

data class NewsResponse(
    @SerializedName("articles")
    var articles: List<Article> = listOf(),
    @SerializedName("status")
    var status: String = "",
    @SerializedName("results")
    var totalResults: Int = 0
)

data class Source(
    @SerializedName("id")
    var id: Any = Any(),
    @SerializedName("name")
    var name: String = ""
)

data class Article(
    @SerializedName("author")
    var author: String = "",
    @SerializedName("content")
    var content: String = "",
    @SerializedName("description")
    var description: String = "",
    @SerializedName("publishedAt")
    var publishedAt: String = "",
    @SerializedName("source")
    var source: Source = Source(),
    @SerializedName("title")
    var title: String = "",
    @SerializedName("url")
    var url: String = "",
    @SerializedName("urlToImage")
    var urlToImage: String = ""
)
```
Como vemos, cada uno de los atributos de cada clase, se corresponde con las entradas de Json.

```kotlin
"status": "ok", //==>    @SerializedName("results") var totalResults: Int = 0
"totalResults": 9543, //==>   var totalResults: Int = 0
"articles":  //==> var articles: List<Article> = listOf()
```

## 2 - API Service
```kotlin
interface ApiService {

    companion object {
        val API_KEY = BuildConfig.API_KEY
    }
    
    @GET("top-headlines")
    suspend fun traerUltimasNoticiasAr(
        @Query(value = "country") country: String = "ar",
        @Query(value = "apiKey") apiKey: String = API_KEY,
        @Query(value = "pageSize") pageSize: Int = 50
    ): NewsResponse
    
    }
```






<image src= "./images/1.jpg">
<image src= "./2.jpg">





# CODIGO


## `PerroViewModel.kt`
```kotlin
package com.example.dogspics

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.asLiveData
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import cl.duoc.ejemploroom.getOrAwaitValue
import com.example.dogspics.dao.PerroDao
import com.example.dogspics.db.BaseDeDatos
import com.example.dogspics.model.PerroFavorito
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class PerroDaoTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: BaseDeDatos
    private lateinit var dao: PerroDao

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        database = Room.inMemoryDatabaseBuilder(context, BaseDeDatos::class.java)
           .allowMainThreadQueries()
            .build()

        dao = database.dao()
    }

    @After

    fun teardown(){
        database.close()
    }

    @Test
    fun agregarFavoritoTest() =  runBlockingTest {
        var perro  = PerroFavorito(id = 1, raza = "labrador", imagenUrl = "url")

        dao.agregarFavorito(perro)

        val listadoPerroFavoritoTest = dao.listadoDeFavoritos().asLiveData().getOrAwaitValue()


        assertThat(listadoPerroFavoritoTest).contains(perro)

    }

    @Test
    fun eliminarFavoritoTest() = runBlockingTest {
        val perro = PerroFavorito(2, "boxer", "url")

        dao.agregarFavorito(perro)
        dao.eliminarFavorito(perro)

        val listadoPerroFavoritoTest = dao.listadoDeFavoritos().asLiveData().getOrAwaitValue()

        assertThat(listadoPerroFavoritoTest).doesNotContain(perro)

    }    
}
```




