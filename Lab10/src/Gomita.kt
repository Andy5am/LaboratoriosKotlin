class Gomita(type:String, sugarContent: Int, val flavor:String):Candy(type, sugarContent) {
    override fun toString(): String {
        return """
            Tipo: $type
            Azucar: $sugarContent
            Sabor: $flavor
        """.trimIndent()
    }
}