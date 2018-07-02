import puntosv2.Punto

fun main(args: Array<String>) {
    val p = Punto(3.0, 5.0)
    p.trasladar(2.0,1.0)
    println(p)
    println(p.x)
    val q = Punto();
    println(q)
}