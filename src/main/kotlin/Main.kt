import com.fasterxml.jackson.databind.ObjectMapper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import kotlin.system.exitProcess

fun main(args: Array<String>) {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://64fa06564098a7f2fc154b9b.mockapi.io")
        .addConverterFactory(JacksonConverterFactory.create())
        .build()

    val userAPI = retrofit.create(ApiService::class.java)
    val call = userAPI.getUsersData()

    /**
     * Request API to get users Data
     */
    call.enqueue(object : Callback<List<User>>{

        override fun onResponse(p0: Call<List<User>>, res: Response<List<User>>) {
            var userList = res.body()

            for(user in userList){
                // Override toString is Better ?
                // println("User : "+user.id+" | name : "+user.name+" | email : "+user.email+" | password : "+user.password)
                println(user.toString())
            }
        }

        override fun onFailure(p0: Call<List<User>>, p1: Throwable) {
            println(p1.toString())
        }
    })
}