import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * class representing a user
 */
class User @JsonCreator constructor(
    @JsonProperty("_id") val id: Int,
    @JsonProperty("name") val name:String,
    @JsonProperty("email") val email: String,
    @JsonProperty("password") val password: String
){
    override fun toString(): String {
        return "User : $id | name : $name | email : $email | password : $password"
    }
}