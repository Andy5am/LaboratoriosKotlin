class NarradorIng(
        var nombre: String,
        var idioma: String
):Narrable {
    override fun narrar(evento:String):String{
        var mensaje = ""
        if (evento == "bienvenida") {
            mensaje = "Welcome to Dota 2"
            return mensaje
        } else if (evento == "empezar") {
            mensaje = "Let the match begin !!"
            return mensaje
        } else if (evento == "kill") {
            mensaje = "Heroe killed"
            return mensaje
        } else if (evento == "kills") {
            mensaje = "Heroes killed"
            return mensaje
        } else if (evento == "5kills") {
            mensaje = "Heroe masacre"
            return mensaje
        } else if (evento == "torre") {
            mensaje = "Tower eliminated"
            return mensaje
        }else if (evento=="radiant"){
            mensaje="Radiant wins!!"
            return mensaje
        }else{
            return "Dire wins!!"
        }

    }
}