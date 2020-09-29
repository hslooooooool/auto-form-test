package vip.qsos.autoform.data_jpa.model

import com.google.gson.Gson
import vip.qsos.autoform.model.db.AbsValue

/**表单项值-文本输入实体类
 * @author : 华清松
 * @param content 输入内容
 */
data class FormValueOfInput(
        var content: String? = ""
) : AbsValue {
    override val valueType: Int = 1

    override fun json(): String {
        return Gson().toJson(this)
    }
}