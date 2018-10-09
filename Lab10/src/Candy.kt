abstract class Candy(
        val type: String,
        val sugarContent: Int
) {
    var isOpen : Boolean = false
    fun open(){
        isOpen = true
    }
}