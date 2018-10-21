
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
    val RadiantAncient = Ancient()
    val DireAncient= Ancient()
    val Radiant = Equipo(RadiantAncient)
    val Dire = Equipo(DireAncient)
    val miNarrador = NarradorEsp("espanol")

    val miPartido = Partido(Radiant,Dire,miNarrador)

    println(miPartido.bienvenida())

    for (i in 0 until 5){
        println("Seleccion heores Radiant")
        var numero = 1
        for (i in Heroes){
            println("$numero: $i")
            numero++
        }
        println("Elija su heroe")
        var eleccion = readLine()!!.toInt()-1
        miPartido.anadirHeroeRadiant(Heroes.get(eleccion))
        println(miPartido.Radiant.heroes)
    }






}
