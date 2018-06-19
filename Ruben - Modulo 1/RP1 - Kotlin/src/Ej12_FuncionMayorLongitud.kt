import java.util.*

val TAM:IntArray = IntArray(10)

fun main(args: Array<String>) {
    print("Introduzca 10 numeros naturales: ")
    leer(Scanner(System.`in`))

    println("La longitud de la mayor sub-sucesion es: " + mayorLongitud(TAM))
}

fun mayorLongitud(array:IntArray):Int{
    var longitud:Int = 0
    var res:Int = 0
    var ultimoN:Int = array[0]

    for (i in array) {
        if (ultimoN > i)
            longitud = 1
        else {
            longitud++;
            if (longitud > res)
                res = longitud
        }

        ultimoN = i
    }

    return res
}

fun leer(teclado:Scanner){
    for (i in 0..TAM.lastIndex)
        TAM[i] = teclado.nextInt()
}