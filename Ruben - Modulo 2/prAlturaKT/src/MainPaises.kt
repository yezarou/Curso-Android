import alturas.MayoresQue
import alturas.MenoresQue
import alturas.Pais
import alturas.Paises

import java.io.FileNotFoundException

object MainPaises {
    @JvmStatic
    fun main(args: Array<String>) {
        val paises = Paises()
        val paisesFiltrado: Array<Pais>

        try {
            paises.leePaises("prAltura/src/alturas.txt")
            paises.paises.filter { pais -> pais.nombre.startsWith("E") }
        } catch (e: FileNotFoundException) {
            println("No existe el fichero.")
        }

        println("Mayores que 1.77")
        for (p in paises.selecciona(MayoresQue(1.77))) {
            println(p)
        }

        println("Menores que 1.77")
        for (p in paises.selecciona(MenoresQue(1.77))) {
            println(p)
        }

        /*
        println("De Europa")
        for (p in paises.selecciona { p -> p.continente == "Europe" }) {
            println(p)
        }
        */
    }
}
