import java.util.*

class Partido<T> (
        var Radiant:Equipo,
        var Dire:Equipo,
        var narrador:T
) where T:NarradorEsp{
    fun bienvenida():String{
        var evento = "bienvenida"
        return this.narrador.narrar(evento)
    }
    fun empezarJuego(){
        var evento = "empezar"
        this.narrador.narrar(evento)
    }
    fun ocurrioUnKill(equipo:Equipo){
        var evento = "kill"
        narrador.narrar(evento)
        if (equipo== Radiant){
            Radiant.heroes.removeAt(Random().nextInt(Radiant.heroes.size))
        }else{
            Dire.heroes.removeAt(Random().nextInt(Dire.heroes.size))
        }
    }
    fun OcurrieronDosOMasKills(kills:Int,equipo: Equipo){
        var evento= "kills"
        narrador.narrar(evento)
        if (equipo==Radiant){
            when(kills){
                2->{
                    for (i in 0 until kills) {
                        Radiant.heroes.removeAt(Random().nextInt(Radiant.heroes.size))
                    }
                }
                3->{
                    for (i in 0 until kills) {
                        Radiant.heroes.removeAt(Random().nextInt(Radiant.heroes.size))
                    }
                }
                4-> {
                    for (i in 0 until kills) {
                        Radiant.heroes.removeAt(Random().nextInt(Radiant.heroes.size))
                    }
                }
            }

        }else{
            when(kills){
                2->{
                    for (i in 0 until kills) {
                        Dire.heroes.removeAt(Random().nextInt(Dire.heroes.size))
                    }
                }
                3->{
                    for (i in 0 until kills) {
                        Dire.heroes.removeAt(Random().nextInt(Dire.heroes.size))
                    }
                }
                4->{
                    for (i in 0 until kills) {
                        Dire.heroes.removeAt(Random().nextInt(Dire.heroes.size))
                    }
                }
            }
        }
    }
    fun ocurrieronCincoKills(equipo: Equipo){
        var evento = "5kills"
        narrador.narrar(evento)
        if (equipo==Radiant){
            for (i in 0 until 5) {
                Radiant.heroes.removeAt(Random().nextInt(Radiant.heroes.size))
            }
        }else{
            for (i in 0 until 5) {
                Dire.heroes.removeAt(Random().nextInt(Dire.heroes.size))
            }
        }
    }
    fun matanUnaTorre(equipo: Equipo){
        val evento ="torre"
        narrador.narrar(evento)
        if (equipo==Radiant){
            Radiant.torres.removeAt(Random().nextInt(Radiant.torres.size))
        }else{
            Dire.torres.removeAt(Random().nextInt(Dire.torres.size))
        }
    }
    fun radiantGana(){
        val evento="radiant"
        narrador.narrar(evento)
    }
    fun direGana(){
        val evento= "dire"
        narrador.narrar(evento)
    }
    fun anadirHeroeRadiant(heroe:Heroe){
        Radiant.heroes.add(heroe)
    }
    fun anadirHeoreDire(heroe: Heroe){
        Dire.heroes.add(heroe)
    }
}