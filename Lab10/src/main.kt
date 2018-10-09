
fun main(args: Array<String>){
    val boxOfChocolate = Box<Chocolate>(arrayListOf<Chocolate>(
            Chocolate("Negro",5,"Hershey"),
            Chocolate("Blanco",7, "Snickers"),
            Chocolate("Leche", 10, "Granada")
    ))
    val forrest = Forrest<Chocolate>(boxOfChocolate)
    println(forrest.pick())
    println(forrest.pick())
    println(forrest.pick())
    println(forrest.pick())

}