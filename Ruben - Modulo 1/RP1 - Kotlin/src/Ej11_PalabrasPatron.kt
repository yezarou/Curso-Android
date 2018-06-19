import java.util.*

fun main(args: Array<String>) {
    var entrada : String
    var patron : String
    var salida : String = ""
    var teclado = Scanner(System.`in`)

    print("Introduzca el patrón: ")
    patron = teclado.next()

    println("Introduzca el texto (FIN para terminar): ")
    do{
        entrada = teclado.next()
        if (entrada != "FIN" && CumplePatron(patron, entrada))
            salida += (entrada + " ")
    } while (entrada != "FIN")

    println("\nSALIDA:\n$salida")
}

private fun CumplePatron(a: String, b: String): Boolean {
    return SumaPalabras(a) == SumaPalabras(b)
}

private fun SumaPalabras(a: String): Int {
    var suma:Int = 0

    for (i in a)
        suma += i.toInt()

    return suma
}