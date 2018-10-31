package arief.com.lithobase

import android.graphics.Color
import android.net.Uri
import android.util.Log
import com.facebook.litho.Column
import com.facebook.litho.Component
import com.facebook.litho.ComponentContext
import com.facebook.litho.Row
import com.facebook.litho.annotations.LayoutSpec
import com.facebook.litho.annotations.OnCreateLayout
import com.facebook.litho.annotations.Prop
import com.facebook.litho.widget.Image
import com.facebook.litho.widget.Text
import com.facebook.yoga.YogaEdge
import com.github.pavlospt.litho.glide.GlideImage

@LayoutSpec
class ItemListSpec {


    companion object {
        @JvmStatic
        @OnCreateLayout
        fun onCreateLayout(c: ComponentContext,
                           @Prop username:String,
                           @Prop realname:String,
                           @Prop urlImage:String
                           ): Component {

            Log.d("AF", "IMAGE :: $urlImage")
            val uriImage = urlImage

            return Row.create(c)
                    .paddingDip(YogaEdge.ALL, 16f)
                    .backgroundColor(Color.WHITE)
                    .child(
                           Row.create(c)
                                    .child(
                                         GlideImage.create(c)
                                                 .widthDip(64f)
                                                 .heightDip(64f)
                                                 .placeholderImageRes(R.drawable.ic_launcher_foreground)
                                                 .imageUrl(urlImage)
                                                 .build()

                                    ).child(
                                    Column.create(c)
                                            .marginDip(YogaEdge.START, 16f)
                                            .flexGrow(4f)
                                            .child(
                                                    Text.create(c)
                                                            .text(username)
                                                            .textSizeSp(18f)
                                            ).child(Text.create(c)
                                                    .text(realname)
                                                    .textSizeSp(14f))
                                            .build()

                                    ).build()


                    ).build()
        }
    }

}