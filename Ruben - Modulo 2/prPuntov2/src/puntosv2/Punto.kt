package puntosv2;
import kotlin.math.pow import kotlin.math.sqrt
data class Punto constructor (var x: Double, var y: Double) {
    constructor() : this(0.0, 0.0) {}

    fun distancia(p: Punto): Double =
            sqrt((p.x - this.x).pow(2.0) + (p.y - this.y).pow(2.0))

    fun trasladar(a: Double, b: Double) {
        x += a
        y += b
    }
}