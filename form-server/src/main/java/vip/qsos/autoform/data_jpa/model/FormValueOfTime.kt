package vip.qsos.autoform.data_jpa.model

import com.google.gson.Gson
import vip.qsos.autoform.model.db.AbsValue

/**表单项值-时间实体类
 * @author : 华清松
 * @param time 设置的时间毫秒数
 * @param timeLimitMin 可选最小时间毫秒数
 * @param timeLimitMax 可选最大时间毫秒数
 */
data class FormValueOfTime(
        var time: Long = 0L,
        var timeLimitMin: Long = 0L,
        var timeLimitMax: Long = 0L
) : AbsValue {
    override val valueType: Int = 3
    override fun json(): String {
        return Gson().toJson(this)
    }
}