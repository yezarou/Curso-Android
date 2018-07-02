package alturas

class Pais(val nombre: String, val continente: String, val altura: Double) {

    override fun equals(obj: Any?): Boolean {
        return (obj as Pais).nombre === nombre
    }

    override fun hashCode(): Int {
        return nombre.hashCode()
    }

    override fun toString(): String {
        return "Pais($nombre, $continente, $altura)"
    }
}
