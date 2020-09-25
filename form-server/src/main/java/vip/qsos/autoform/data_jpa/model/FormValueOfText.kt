package vip.qsos.autoform.data_jpa.model

import com.google.gson.Gson
import vip.qsos.autoform.model.db.AbsValue

/**表单项值-文本实体类
 * @author : 华清松
 * @param content 输入内容
 */
data class FormValueOfText(
        var content: String? = ""
) : AbsValue {

    override fun json(): String {
        return Gson().toJson(this)
    }
}