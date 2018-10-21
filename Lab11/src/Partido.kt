import java.util.*
import kotlin.math.E

class Partido<T> (
        var narrador:T
) where T : Narrable{
    var Radiant:Equipo = Equipo()
    var Dire:Equipo = Equipo()
    fun bienvenida():String{
        var evento = "bienvenida"
        return narrar(narrador,evento)
    }
    fun empezarJuego():String{
        var evento = "empezar"
        return narrar(narrador,evento)
    }
    fun ocurrioUnKill(esRadiant:Boolean):String{
        var evento = "kill"
        if (esRadiant){
            Radiant.heroes.removeAt(Random().nextInt(Radiant.heroes.size))
        }else{
            Dire.heroes.removeAt(Random().nextInt(Dire.heroes.size))
        }
        return narrar(narrador,evento)
    }
    fun OcurrieronDosOMasKills(kills:Int,esRadiant: Boolean):String? {
        if (kills>0) {
            var evento = "kills"
            if (esRadiant) {
                when (kills) {
                    2 -> {
                        for (i in 0 until kills) {
                            Radiant.heroes.removeAt(Random().nextInt(Radiant.heroes.size))
                        }
                    }
                    3 -> {
                        for (i in 0 until kills) {
                            Radiant.heroes.removeAt(Random().nextInt(Radiant.heroes.size))
                        }
                    }
                    4 -> {
                        for (i in 0 until kills) {
                            Radiant.heroes.removeAt(Random().nextInt(Radiant.heroes.size))
                        }
                    }
                }

            } else {
                when (kills) {
                    2 -> {
                        for (i in 0 until kills) {
                            Dire.heroes.removeAt(Random().nextInt(Dire.heroes.size))
                        }
                    }
                    3 -> {
                        for (i in 0 until kills) {
                            Dire.heroes.removeAt(Random().nextInt(Dire.heroes.size))
                        }
                    }
                    4 -> {
                        for (i in 0 until kills) {
                            Dire.heroes.removeAt(Random().nextInt(Dire.heroes.size))
                        }
                    }
                }
            }
            return narrar(narrador, evento)
        } else {
            return null
        }
    }
    fun ocurrieronCincoKills(esRadiant: Boolean):String{
        var evento = "5kills"
        narrador.narrar(evento)
        if (esRadiant){
            for (i in 0 until 5) {
                Radiant.heroes.removeAt(Random().nextInt(Radiant.heroes.size))
            }
        }else{
            for (i in 0 until 5) {
                Dire.heroes.removeAt(Random().nextInt(Dire.heroes.size))
            }
        }
        return narrar(narrador,evento)
    }
    fun matanUnaTorre(esRadiant: Boolean):String{
        val evento ="torre"
        narrador.narrar(evento)
        if (esRadiant){
            Radiant.torres.removeAt(Random().nextInt(Radiant.torres.size))
        }else{
            Dire.torres.removeAt(Random().nextInt(Dire.torres.size))
        }
        return narrar(narrador,evento)
    }
    fun radiantGana():String{
        val evento="radiant"
        if (!hayTorresDire()) {
            return narrar(narrador, evento)
        }else{
            return "Todavia hay torres"
        }
    }
    fun direGana():String{
        val evento= "dire"
        if (!hayTorresRadiant()) {
            return narrar(narrador, evento)
        }else{
            return "Todavia hay torres"
        }
    }
    fun anadirHeroeRadiant(heroe:Heroe){
        Radiant.heroes.add(heroe)
    }
    fun anadirHeroeDire(heroe: Heroe){
        Dire.heroes.add(heroe)
    }
    fun hayTorresRadiant():Boolean{
        if (Radiant.torres.size>0){
            return true
        }
        return false
    }
    fun hayTorresDire():Boolean{
        if (Dire.torres.size>0){
            return true
        }
        return false
    }
    fun hayHeroesRadiant():Boolean{
        if (Radiant.heroes.size>0){
            return true
        }
        return false
    }
    fun hayHeroesDire():Boolean{
        if (Dire.heroes.size>0){
            return true
        }
        return false
    }
}
fun narrar(narrable: Narrable,evento:String):String{
    return narrable.narrar(evento)
}