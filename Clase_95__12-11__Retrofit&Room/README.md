# MODULO 4 | Desarrollo de Aplicaciones Móviles Android Kotlin | Ignacio Cavallo



https://github.com/cavigna/modulo_desarrollo_de_aplicaciones_moviles_android_kotlin

## Clase 95 | 12-11

Retomando la clase anterior expuse sobre Corrutinas. La verdad que aprendí un montón gracias a muchas horas fuera de clase investigando sobre el tema.

En la segunda parte de la clase comenzamos un ejercicio desafiante que incluye corrutinas, Retrofit y Room. Aquí esta el link del repo

https://github.com/cavigna/DogsPics


> A continuación muestro unas capturas de pantalla


<image src= "./1.jpg">
<image src= "./2.jpg">




# CODIGO


## `PerroViewModel.kt`
```kotlin
class PerroViewModel(private val repositorio: Repositorio) : ViewModel() {


    val listadoRazaDB: LiveData<List<ListadoRazaDB>> = repositorio.listadoRazasDB().asLiveData()

    private var _listadoImagenesPorRaza = MutableLiveData<PerroImagenes>()
    val listadoImagenesPorRaza: LiveData<PerroImagenes> = _listadoImagenesPorRaza

    var razaSeleccionada = ""

    fun imagenesPorRaza(nombreRaza:String){

        viewModelScope.launch(IO) {
            _listadoImagenesPorRaza.postValue(repositorio.imagenesPorRaza(nombreRaza))
        }

    }




    fun agregarListadoRaza() {
        viewModelScope.launch {
            val listado = repositorio.listadoRazaAPI()
            val listadoRazaDB = mutableListOf<ListadoRazaDB>()

            for (s in listado) {
                listadoRazaDB.add(ListadoRazaDB(raza = s))
            }



            repositorio.agregarListaRazaDB(listadoRazaDB)


        }
    }

}
}




