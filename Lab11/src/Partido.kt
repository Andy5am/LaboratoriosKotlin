import java.util.*
//parametro generico T
class Partido<T> (
        var narrador:T
) where T : Narrable{//Se define que tiene que ser un narrador
    //se anaden sus equipos
    var Radiant:Equipo = Equipo()
    var Dire:Equipo = Equipo()
    //diferentes metodos para los distintos eventos
    fun bienvenida():String{
        var evento = "bienvenida"
        return narrar(narrador,evento)
    }
    fun empezarJuego():String{
        var evento = "empezar"
        return narrar(narrador,evento)
    }
    //para los eventos de kills se eliminan los heroes/torres eliminados
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
                    //heroes eliminados segun lo que ponga el usuario
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
    //metodos para determinar ganador con condiciones para que no hagan trampa
    fun radiantGana():String{
        val evento="radiant"
        if (!hayTorresDire()) {
            return narrar(narrador, evento)
        }else{
            return "Todavia hay torres. No haga trampa"
        }
    }
    fun direGana():String{
        val evento= "dire"
        if (!hayTorresRadiant()) {
            return narrar(narrador, evento)
        }else{
            return "Todavia hay torres. No haga trampa"
        }
    }
    //metodos para anadir los heores al incio en el draft
    fun anadirHeroeRadiant(heroe:Heroe){
        Radiant.heroes.add(heroe)
    }
    fun anadirHeroeDire(heroe: Heroe){
        Dire.heroes.add(heroe)
    }
    //metodos para ver que hayan torres y asi poder eliminar mas o determinar si puede ganar
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
    //metodos para ver si hay heroes y asi ver si puede matar mas
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
//metodo para la interfaz para los narradores
fun narrar(narrable: Narrable,evento:String):String{
    return narrable.narrar(evento)
}