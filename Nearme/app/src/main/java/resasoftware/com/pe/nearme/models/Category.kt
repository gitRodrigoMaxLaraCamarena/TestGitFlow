package resasoftware.com.pe.nearme.models

import java.io.Serializable

data class Category(
    val id: Int,
    val name: String,
    val description: String
): Serializable {
    constructor() : this(
        0,
        "",
        ""
    )
}