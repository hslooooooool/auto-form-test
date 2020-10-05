package vip.qsos.autoform.data_jpa.model

import com.google.gson.Gson
import vip.qsos.autoform.model.db.AbsValue

/**表单项值-人员实体类
 * @author : 华清松
 */
class FormValueOfUser : AbsValue {
    constructor()

    /**
     * @param userId 用户ID
     * @param userName 用户名称
     * @param userDesc 用户描述，推荐为手机号
     * @param userAvatar 用户头像链接，http://qsos.vip/img/logo.png
     * */
    constructor(
            userId: String? = null,
            userName: String = "",
            userDesc: String = "",
            userAvatar: String? = null
    ) {
        this.userId = userId
        this.userName = userName
        this.userDesc = userDesc
        this.userAvatar = userAvatar
    }

    var userId: String? = null
    var userName: String = ""
    var userDesc: String = ""
    var userAvatar: String? = null
    override val valueType: Int = 4
    override fun json(): String {
        return Gson().toJson(this)
    }
}