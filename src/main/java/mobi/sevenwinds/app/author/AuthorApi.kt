package mobi.sevenwinds.app.author

import com.papsign.ktor.openapigen.annotations.type.string.length.MinLength
import com.papsign.ktor.openapigen.route.info
import com.papsign.ktor.openapigen.route.path.normal.NormalOpenAPIRoute
import com.papsign.ktor.openapigen.route.path.normal.post
import com.papsign.ktor.openapigen.route.response.respond
import com.papsign.ktor.openapigen.route.route

fun NormalOpenAPIRoute.author() {
    route("/author") {
        route("/add").post<Unit, AuthorRecord, AuthorRecord>(info("Добавить запись")) { param, body ->
            respond(AuthorService.addRecord(body))
        }
    }
}

data class AuthorRecord(
    @MinLength(3, errorMessage = "ФИО не должно быть меньше 3 символов")
    val fullName: String
)