package alturas

import java.io.File
import java.io.FileNotFoundException
import java.util.ArrayList
import java.util.Locale
import java.util.Scanner

class Paises {
    val paises: MutableList<Pais>

    init {
        paises = ArrayList()
    }

    @Throws(FileNotFoundException::class)
    fun leePaises(file: String) {
        Scanner(File(file)).use { sc -> leePaises(sc) }
    }

    private fun leePaises(sc: Scanner) {
        val nPaises = 0

        while (sc.hasNextLine()) {
            Scanner(sc.nextLine()).useLocale(Locale.ENGLISH).use { scPais ->
                scPais.useDelimiter(",")
                val nombre = scPais.next()
                val continente = scPais.next()
                val altura = scPais.nextDouble()
                paises.add(Pais(nombre, continente, altura))
            }
        }
    }

    fun selecciona(sel: Seleccion): List<Pais> {
        val res = ArrayList<Pais>()

        for (pais in paises) {
            if (sel.test(pais)) {
                res.add(pais)
            }
        }

        return res
    }
}
