import java.util.*

fun main(args: Array<String>) {
    var teclado : Scanner = Scanner(System.`in`)
    var matriz:Array<IntArray> = leerMatriz(teclado)

    println("asd")

    mostrarMatriz(matriz)

    println()

    mostrarMatriz(suavizado(matriz))

    teclado.close()
}

fun suavizado(matriz:Array<IntArray>) : Array<IntArray>{
    var res : Array<IntArray> = Array(matriz.lastIndex + 1,{IntArray(matriz[0].lastIndex+1)})
    var suma : Int
    var nVecinos : Int

    for (i in 0..matriz.lastIndex){
        for (j in 0..matriz[0].lastIndex) {
            suma = 0
            nVecinos = 0
            for (k in -1..1) {
                for (l in -1..1){
                    try {
                        suma += matriz[i + k][j + l]
                        nVecinos++
                    }
                    catch (e:Exception){}
                }
            }
            res[i][j] = suma / nVecinos
        }
    }

    return res
}

fun mostrarMatriz(matriz: Array<IntArray>){
    for (i in matriz){
        for (j in i)
            print(j)
        println()
    }
}

fun leerMatriz(teclado: Scanner) : Array<IntArray> {
    var matriz: Array<IntArray> = Array(4, { IntArray(3) })

    for (i in 0..matriz.lastIndex) {
        for (j in 0..matriz[0].lastIndex) {
            matriz[i][j] = teclado.nextInt()
        }
    }

    return matriz
}