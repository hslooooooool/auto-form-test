package vip.qsos.autoform.data_jpa.model

import com.google.gson.Gson
import vip.qsos.autoform.model.db.AbsValue

/**表单项值-表格实体类
 * @author : 华清松
 * @param sheetTitle 表格标题
 * @param sheetPosition 表格位置
 * @param sheetType 表格类型：-1容器，0文本
 * @param sheetFormat 表格内容格式限制
 * @param sheetContent 表格内容
 * @param sheetNotice 表格提示
 */
data class FormValueOfSheet(
        var sheetTitle: String,
        var sheetPosition: String,
        var sheetType: Int = 0,
        var sheetFormat: String = "NORMAL",
        var sheetContent: String = "",
        var sheetNotice: String = ""
) : AbsValue {
    override val valueType: Int = 7

    override fun json(): String {
        return Gson().toJson(this)
    }

}