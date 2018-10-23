package arief.com.lithobase

import com.google.gson.annotations.SerializedName

data class Repo(@SerializedName("login") val name:String,
                @SerializedName("avatar_url") val avatar_url:String,
                @SerializedName("type") val type:String)


