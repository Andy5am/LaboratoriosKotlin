//clase ancient con sus atributos
data class Ancient(var muerto:Boolean = false) {
    fun morir(){
        muerto = true
    }
}