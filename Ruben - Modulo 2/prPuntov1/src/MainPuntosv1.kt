import puntosv1.Punto

fun main(args: Array<String>) {
    val p: Punto = Punto(3.0,5.0)
    p.trasladar(2.0,1.0)
    println(p)
    println(p.getX())
    val q: Punto = Punto();
    println(q)
}