package JarrasKT

class Jarra(private val capacidad: Int) {
    private var contenido: Int

    init {
        contenido = 0
    }

    fun capacidad() = capacidad

    fun contenido() = contenido

    fun llena() {
        contenido = capacidad
    }

    fun vacia() {
        contenido = 0
    }

    fun llenaDesde(j: Jarra) {
        while (this.contenido < this.capacidad && j.contenido > 0) {
            j.contenido--
            this.contenido++
        }
    }

    override fun toString() = "($contenido / $capacidad)"
}