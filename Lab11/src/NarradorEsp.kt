class NarradorEsp():Narrable{//hereda de la interfaz
    override fun narrar(evento:String):String {
    //condiciones de los diferentes mensaje segun evento
        var mensaje = ""
        if (evento == "bienvenida") {
            mensaje = "Bienvenido a Dota 2"
            return mensaje
        } else if (evento == "empezar") {
            mensaje = "Que empiece el juego"
            return mensaje
        } else if (evento == "kill") {
            mensaje = "Heroe eliminado"
            return mensaje
        } else if (evento == "kills") {
            mensaje = "Heroes eliminados"
            return mensaje
        } else if (evento == "5kills") {
            mensaje = "Masacre de herores"
            return mensaje
        } else if (evento == "torre") {
            mensaje = "Torre eliminada"
            return mensaje
        }else if (evento=="radiant"){
            mensaje="Radiant gana!!"
            return mensaje
        }else{
            return "Dire Gana!!"
        }

    }


}
