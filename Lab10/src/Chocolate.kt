class Chocolate(type: String, sugarContent: Int, val brand: String): Candy(type, sugarContent) {
    override fun toString(): String {
        return """
            tipo: $type
            azucar: $sugarContent
            marca: $brand
        """.trimIndent()
    }
}