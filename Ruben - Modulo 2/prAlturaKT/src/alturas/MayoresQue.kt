package alturas

class MayoresQue(internal var alturaMin: Double) : Seleccion {

    override fun test(pais: Pais): Boolean {
        return pais.altura >= alturaMin
    }
}
