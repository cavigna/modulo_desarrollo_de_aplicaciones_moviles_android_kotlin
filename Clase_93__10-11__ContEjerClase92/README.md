# MODULO 4 | Desarrollo de Aplicaciones Móviles Android Kotlin | Ignacio Cavallo



https://github.com/cavigna/modulo_desarrollo_de_aplicaciones_moviles_android_kotlin

## Clase 93 | 10-11

En esta clase hicimos control del ejercicio de ayer. Cada uno de los 4 compañeros que seguimos en pie, expusimos nuestro proyecto.A medida que surgian inconvenientes tratamos entre todos de solucionar los problemas que iban surgiendo. Estuvo interesante, ya que el profesor simplemente nos guió y nosotros tratamos de resolver los inconvenientes que aparecian.


> A continuación dejaré otra parte del código que desarrollé ayer y hoy.







# CODIGO


## `Repositroy.kt`
```kotlin
class Repositorio(private val api: ApiService, private val dao: GalacticaDao) {

    suspend fun listadoTerrenosAPI() = api.listadoTerrenos()

    suspend fun agregarListadoDB(listaT : List<Terreno>) = dao.agregarListadoDB(listaT)

    fun listadoTerrenosDB() = dao.listadoTerrenoDB()

    fun conteoDB() = dao.conteoDB()

}

```

## `GalacticaViewModel.kt`

```kotlin

class GalacticaViewModel(private val repositorio: Repositorio) : ViewModel() {


    //val repo2 = Repositorio()
    //var listaTerrenosDB:LiveData<List<Terreno>>
    val listaTerrenosDB = repositorio.listadoTerrenosDB().asLiveData()


    var _uno = MutableLiveData<Int>()
    val uno :LiveData<Int> = _uno

    val currentTerreno = MutableLiveData<Terreno>()
    val conteoDB = repositorio.conteoDB()
    var pruebaDB = MutableLiveData<Int>(0)

    init {
        checkIfDBEmpty()
        listadoTerrenos()


    }




    //var pruebaDB = MutableLiveData(10)

    fun listadoTerrenos() {
        viewModelScope.launch {

            repositorio.agregarListadoDB(repositorio.listadoTerrenosAPI())
        }
    }

    fun checkIfDBEmpty() {

        viewModelScope.launch {


            if (listaTerrenosDB.value?.isEmpty() == true) {
                repositorio.agregarListadoDB(repositorio.listadoTerrenosAPI())
            }
        }

    }


}

```


