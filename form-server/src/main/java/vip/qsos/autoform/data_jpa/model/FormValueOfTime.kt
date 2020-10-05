package vip.qsos.autoform.data_jpa.model

import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer
import com.google.gson.Gson
import vip.qsos.autoform.model.db.AbsValue

/**表单项值-时间实体类
 * @author : 华清松
 */
class FormValueOfTime : AbsValue {

    constructor()

    /**
     * @param time 设置的时间毫秒数
     * @param timeLimitMin 可选最小时间毫秒数
     * @param timeLimitMax 可选最大时间毫秒数
     */
    constructor(time: Long, timeLimitMin: Long, timeLimitMax: Long) {
        this.time = time
        this.timeLimitMin = timeLimitMin
        this.timeLimitMax = timeLimitMax
    }

    @JsonSerialize(using = ToStringSerializer::class)
    var time: Long = 0L

    @JsonSerialize(using = ToStringSerializer::class)
    var timeLimitMin: Long = 0L

    @JsonSerialize(using = ToStringSerializer::class)
    var timeLimitMax: Long = 0L

    override val valueType: Int = 3
    override fun json(): String {
        return Gson().toJson(this)
    }
}