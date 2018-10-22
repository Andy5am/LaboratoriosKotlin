import java.lang.Exception
// funciones para los menus
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
//Creacion de los heroes
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
//menu para elejir al narrador
    println("""
        En que idioma desea al narrador?
        1.espanol
        2.ingles
    """.trimIndent())
    val idioma = readLine()!!
    //inicializar al narrador y partido
    val narrador:Narrable = NarradorIng()
    val miPartido = Partido(narrador)
    //segun lo que elija el usuario se cambia el narrador espanol es el narrador por defecto
    if (idioma=="2"){
        val miNarrador = NarradorIng()
        miPartido.narrador=miNarrador
    }else {
        val miNarrador = NarradorEsp()
        miPartido.narrador=miNarrador
    }
//Bienvenida del narrador
    println(miPartido.bienvenida())
//Draft para seleccionar a los heroes
    for (i in 0 until 5){
        //se muestra la lista de heroes y se pregunta por cual desea
        println("Seleccion heores Radiant")
        var numero = 1
        for (i in Heroes){
            println("$numero: $i")
            numero++
        }
        //ciclo por si escribe un valor incorrecto
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
    //narrador inicia el juego
    println(miPartido.empezarJuego())
    //ciclo mientras no haya ganador
    var ganador = false
    do {
        //condiciones para el menu a imprimir
        if (miPartido.hayTorresRadiant() && miPartido.hayTorresDire()){
            println(menuInicial())
        }else{
            println(menuFinal())
        }
        var opcion = readLine()!!
        var esRadiant:Boolean = true
        when (opcion){
            //si el usuario elije la opcion 1 se le pregunta si el equipo radiant mato
            "1"->{
                println("Fue Radiant quien mato? si/no")
                var confirmar = readLine()!!
                esRadiant = confirmar != "si"
                // Se le pregunta cuantos mato
                if (confirmar=="si"||confirmar== "no") {
                    if ((!esRadiant && miPartido.hayHeroesRadiant()) || (esRadiant && miPartido.hayHeroesDire())) {
                        println("Cuantas muertes? 1-5")
                        //programacion defensiva por si no escribe un numero o la cantidad de heroes que tiene el equipo enemigo
                        try {
                            //Dependiendo de la cantidad de heroes y el equipo se muestra un diferente mensaje
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
                            //error si escribe algo incorrecto
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
                //si elige la opcion 2 se le pregunta si radiant mato
                println("Fue Radiant quien mato? si/no")
                var confirmar = readLine()!!
                esRadiant = confirmar!= "si"
                //en base a la respuesta el se elimina la torre y el narrador muestra mensaje
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
                //si elige la opcion 3 cuando ya este disponible
                println("Fue Radiant quien gano? si/no")
                var confirmar = readLine()!!
                // en base a su respuesta y al ver que el equipo contrario no tenga torres gana el juego o se continua
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
        }//condicion para terminar el juego
    }while (!ganador)
}
