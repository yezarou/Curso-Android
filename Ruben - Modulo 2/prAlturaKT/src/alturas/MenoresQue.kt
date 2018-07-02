package alturas

class MenoresQue(internal var alturaMax: Double) : Seleccion {

    override fun test(pais: Pais): Boolean {
        return pais.altura <= alturaMax
    }
}
