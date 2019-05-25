package resasoftware.com.pe.nearme.models

import java.io.Serializable

data class Type_User(
    var id: Int,
    val description: String?,
    val name: String?
) : Serializable {
    constructor() : this(
        0,
		"",
		""
    )
}