package arief.com.lithobase

import com.facebook.litho.annotations.Prop
import com.facebook.litho.sections.Children
import com.facebook.litho.sections.annotations.GroupSectionSpec
import com.facebook.litho.sections.annotations.OnCreateChildren
import com.facebook.litho.sections.SectionContext
import com.facebook.litho.sections.common.SingleComponentSection



@GroupSectionSpec
class ListSectionSpec  {

    companion object {

        @OnCreateChildren
        @JvmStatic
        fun onCreateLayoutChildren(sectionContext: SectionContext
        , @Prop users:List<User>):Children{

            val children = Children.create()

            for(user:User in users) {
                children.child(
                        SingleComponentSection.create(sectionContext)
                                .key(user.username)
                                .component(ItemList.create(sectionContext)
                                        .username(user.username)
                                        .realname(user.realname)
                                        .urlImage(user.urlImage)
                                        .build()))
            }

            return children.build()


        }
    }

}