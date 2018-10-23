package arief.com.lithobase.network

import arief.com.lithobase.Repo
import io.reactivex.Observable
import retrofit2.http.GET

interface Service {

    @GET("repos/square/retrofit/contributors")
    fun getRepo():Observable<List<Repo>>

}