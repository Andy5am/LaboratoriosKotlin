
fun main(args: Array<String>){
    val boxOfChocolate = Box<Chocolate>(arrayListOf<Chocolate>(
            Chocolate("Negro",5,"Hershey"),
            Chocolate("Blanco",7, "Snickers"),
            Chocolate("Leche", 10, "Granada")
    ))
    val forrest = Forrest<Chocolate>(boxOfChocolate)
    println("Caja de chocolates:\n")
    println(forrest.pick()+"\n")
    println(forrest.pick()+"\n")
    println(forrest.pick()+"\n")
    println(forrest.pick()+"\n")

    val boxOfCandy = Box<Candy>(arrayListOf<Candy>(
            Chocolate("Mani", 8, "Crunch"),
            Gomita("Acida",4, "limon"),
            Gomita("Azucar",11, "Cereza")
    ))
    val Gump = Forrest<Candy>(boxOfCandy)
    println("\nCaja de dulces:\n")
    println(Gump.pick()+"\n")
    println(Gump.pick()+"\n")
    println(Gump.pick()+"\n")
    println(Gump.pick()+"\n")

}