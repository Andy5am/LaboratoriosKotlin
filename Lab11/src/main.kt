import java.lang.Exception

fun menuInicial():String{
    return """
        MENU:
    1. Ocurrieron muertes
    2. Matar torres
    """.trimIndent()
}
fun menuFinal():String{
    return """
        MENU:
    1. Ocurrieron muertes
    2. Matar torres
    3. Matan ancient
    """.trimIndent()
}

fun main(args: Array<String>){
    val Heroes:ArrayList<Heroe> = arrayListOf(
    Heroe("Doom","Fuerza"),
    Heroe("Axe","Fuerza"),
    Heroe("Magnus","Fuerza"),
    Heroe("Phoenix","Fuerza"),
    Heroe("Tusk","Fuerza"),
    Heroe("Sven","Fuerza"),
    Heroe("Clinkz","Agilidad"),
    Heroe("Sniper","Agilidad"),
    Heroe("Luna","Agilidad"),
    Heroe("Spectre","Agilidad"),
    Heroe("Ursa","Agilidad"),
    Heroe("Mirana","Agilidad"),
    Heroe("Enigma","Inteligencia"),
    Heroe("Lina","Inteligencia"),
    Heroe("Warlock","Inteligencia"),
    Heroe("Zeus","Iteligencia"),
    Heroe("Puck","Inteligencia"),
    Heroe("Lion","Inteligencia"),
    Heroe("Huskar","Fuerza"),
    Heroe("Pugna","Inteligencia"))

    println("""
        En que idioma desea al narrador?
        1.espanol
        2.ingles
    """.trimIndent())
    val idioma = readLine()!!
    val narrador:Narrable = NarradorIng()
    val miPartido = Partido(narrador)
    if (idioma=="2"){
        val miNarrador = NarradorIng()
        miPartido.narrador=miNarrador
    }else {
        val miNarrador = NarradorEsp()
        miPartido.narrador=miNarrador
    }

    println(miPartido.bienvenida())

    for (i in 0 until 5){
        println("Seleccion heores Radiant")
        var numero = 1
        for (i in Heroes){
            println("$numero: $i")
            numero++
        }
        var elejido = false
        do {
            println("Elija su heroe")
            try {
                var eleccion = readLine()!!.toInt() - 1
                miPartido.anadirHeroeRadiant(Heroes[eleccion])
                Heroes.removeAt(eleccion)
                elejido = true
            } catch (e: Exception) {
                println("Escriba un numero de heroe")
            }
        }while (!elejido)
        println("Seleccion heroes Dire")
        numero = 1
        for (i in Heroes){
            println("$numero: $i")
            numero++
        }
        elejido = false
        do {
            println("Elija su heroe")
            try {
                var eleccion = readLine()!!.toInt() - 1
                miPartido.anadirHeroeDire(Heroes[eleccion])
                Heroes.removeAt(eleccion)
                elejido = true
            } catch (e: Exception) {
                println("Escriba un numero de heroe")
            }
        }while (!elejido)
    }
    println(miPartido.empezarJuego())
    var ganador = false
    do {
        if (miPartido.hayTorresRadiant() && miPartido.hayTorresDire()){
            println(menuInicial())
        }else{
            println(menuFinal())
        }
        var opcion = readLine()!!
        var esRadiant:Boolean = true
        when (opcion){
            "1"->{
                println("Fue Radiant quien mato? si/no")
                var confirmar = readLine()!!
                esRadiant = confirmar != "si"
                if (confirmar=="si"||confirmar== "no") {
                    if ((!esRadiant && miPartido.hayHeroesRadiant()) || (esRadiant && miPartido.hayHeroesDire())) {
                        println("Cuantas muertes? 1-5")
                        try {
                            var muertes = readLine()!!.toInt()
                            if (muertes == 1) {
                                println(miPartido.ocurrioUnKill(esRadiant))
                            } else if (muertes in 2..4) {
                                println(miPartido.OcurrieronDosOMasKills(muertes, esRadiant))
                            } else if (muertes == 5) {
                                println(miPartido.ocurrieronCincoKills(esRadiant))
                            } else {
                                println("Escriba un numero dentro del parametro indicado")
                            }
                        } catch (e: Exception) {
                            println("No hay esa cantidad de heroes")
                        }
                    } else {
                        println("Ya no le quedan heroes")
                    }
                }else{
                    println("Escriba si o no")
                }
            }
            "2"->{
                println("Fue Radiant quien mato? si/no")
                var confirmar = readLine()!!
                esRadiant = confirmar!= "si"
                if (confirmar=="si"||confirmar == "no") {
                    if ((!esRadiant && miPartido.hayTorresRadiant()) || (esRadiant && miPartido.hayTorresDire())) {
                        println(miPartido.matanUnaTorre(esRadiant))
                    } else {
                        println("Ya no le quedan torres")
                    }
                }else{
                    println("Escriba si o no")
                }
            }
            "3"->{
                println("Fue Radiant quien gano? si/no")
                var confirmar = readLine()!!
                esRadiant = confirmar!= "si"
                if (confirmar =="si" || confirmar!== "no"){
                    if (!esRadiant){
                        println(miPartido.radiantGana())
                        if (!miPartido.hayTorresDire()){
                            ganador = true
                        }
                    }else{
                        println(miPartido.direGana())
                        if (!miPartido.hayTorresRadiant()){
                            ganador=true
                        }
                    }
                }else{
                    println("Escriba si o no")
                }
            }
        }
    }while (!ganador)
}
