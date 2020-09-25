package vip.qsos.autoform.data_jpa.model

import com.google.gson.Gson
import vip.qsos.autoform.model.db.AbsValue

/**表单项值-人员实体类
 * @author : 华清松
 * @param userId 用户ID
 * @param userName 用户名称
 * @param userDesc 用户描述，推荐为手机号
 * @param userAvatar 用户头像链接，http://qsos.vip/img/logo.png
 */
data class FormValueOfUser(
        var userId: String? = null,
        var userName: String,
        var userDesc: String = "",
        var userAvatar: String? = null
) : AbsValue {

    override fun json(): String {
        return Gson().toJson(this)
    }
}