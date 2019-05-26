package resasoftware.com.pe.nearme.models

import java.io.Serializable

data class Comment(
    val id: Int,
    var enterpriseId: Enterprise,
    var userId: User,
    val comment: String
): Serializable {
    constructor() : this(
        0,
        Enterprise(),
        User(),
        ""
    )
}