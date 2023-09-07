import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("/users")
    fun getUsersData(): Call<List<User>>
}