class Forrest<T>(val caja : Box<T>) {
    fun pick(): String{
        val picked = caja.pickOne()
        if (picked!=null){
            return "Eligio esto: \n$picked"
        }
        return "Ya no hay nada"
    }
}