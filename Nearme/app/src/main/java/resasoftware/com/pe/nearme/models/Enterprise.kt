package resasoftware.com.pe.nearme.models

import java.io.Serializable

data class Enterprise(
    var id: Int,
    val categoryId: Category?,
    val description: String?,
    val image: String?,
    val location: String?,
    val name: String?,
	val star: String?
) : Serializable {
    constructor() : this(
        0,
        Category(),
        "",
        "",
		"",
		"",
		""
    )
}