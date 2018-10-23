package arief.com.lithobase

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import arief.com.lithobase.network.BaseRequest
import com.facebook.litho.ComponentContext
import com.facebook.litho.LithoView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.ArrayList
import com.facebook.litho.widget.LinearLayoutInfo
import com.facebook.litho.widget.Recycler
import com.facebook.litho.widget.RecyclerBinder
import io.reactivex.functions.Consumer


class MainActivity : AppCompatActivity() {

    var listUser = ArrayList<User>()
    val context  by lazy {
        ComponentContext(this)
    }
    val recyclerBinder by lazy {
        RecyclerBinder.Builder()
                .layoutInfo(LinearLayoutInfo(LinearLayoutManager(this)))
                .build(context)
    }

    val recyclerComponent by lazy {
            Recycler.create(context)
                    .binder(recyclerBinder)
                    .build()
    }

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            loadData()

            val  lithoView = LithoView.create(
                    this,
                    recyclerComponent)


            setContentView(lithoView)


        }

        fun loadData(){
            val request = BaseRequest();
            request.getService().getRepo()
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(Consumer {
                        setUpList(it)
                        it.forEach {
                            Log.d("AF", "name : ${it.name}, avatar: ${it.avatar_url}, type: ${it.type}")
                        }
                    }, Consumer {
                        Log.e("AF", "eror data : ${it.message}")
                    })


        }

        fun setUpList( listData:List<Repo>){

            var pos = 0;
            listData.forEach {

                recyclerBinder.insertItemAt(pos, ItemList.create(context)
                        .username(it.name)
                        .realname(it.type)
                        .urlImage(it.avatar_url)
                        .build())

                pos++
            }
        }

}
