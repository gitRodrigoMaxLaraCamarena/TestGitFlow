package resasoftware.com.pe.nearme.models

import java.io.Serializable

data class Type_User(
    var id: Int,
    var description: String,
    var name: String
): Serializable {
    constructor() : this(
        0,
		"",
		""
    )
}