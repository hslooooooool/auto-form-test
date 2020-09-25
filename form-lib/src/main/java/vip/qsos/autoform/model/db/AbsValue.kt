package vip.qsos.autoform.model.db

/**自定义的表单项值需继承此类
 * @author : 华清松
 */
interface AbsValue {
    fun json(): String
}