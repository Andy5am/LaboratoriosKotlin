import java.util.*

class Box<T> (
        private val lista: ArrayList<T>
){
    fun pickOne():T?{
        if(lista.size>0){
            return lista.removeAt(Random().nextInt(lista.size))
        }
        return null
    }
}