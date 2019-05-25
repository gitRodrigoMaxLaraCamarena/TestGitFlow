package resasoftware.com.pe.nearme.models

import java.io.Serializable

data class Comment(
    var id: Int,
    val enterpriseId: Enterprise?,
    val userId: User?,
    val comment: String?
) : Serializable {
    constructor() : this(
        0,
        Enterprise(),
        User(),
        ""
    )
}