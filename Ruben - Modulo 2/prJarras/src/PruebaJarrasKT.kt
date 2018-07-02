import JarrasKT.Jarra

fun main(args: Array<String>) {
    val j1 = Jarra(7)
    val j2 = Jarra(5)

    j2.llena()
    j1.llenaDesde(j2)
    j2.llena()
    j1.llenaDesde(j2)
    j1.vacia()
    j1.llenaDesde(j2)
    j2.llena()
    j1.llenaDesde(j2)

    println(j1.toString() + j2.toString())
}
