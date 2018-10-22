//clase torre con sus atributos
data class Torre( var muerta:Boolean = false) {
    fun morir(){
        muerta = true
    }
}