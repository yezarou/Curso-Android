package alturas

class EnContinente(internal var continente: String) : Seleccion {

    override fun test(pais: Pais): Boolean {
        return pais.continente.contains(continente)
    }
}
