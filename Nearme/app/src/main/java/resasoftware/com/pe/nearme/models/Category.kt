package resasoftware.com.pe.nearme.models

import java.io.Serializable

data class Category(
    var id: Int,
    val name: String?,
    val description: String?
) : Serializable {
    constructor() : this(
        0,
        "",
        ""
    )
}