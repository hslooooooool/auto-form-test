package vip.qsos.autoform.model.db

/**表单项值实体类
 * @author : 华清松
 */
interface IFormValue {
    /**表单项值主键*/
    var id: Long

    /**限制条件*/
    var limit: String?

    /**是否可编辑*/
    var editable: Boolean

    /**顺序*/
    var position: Int

    /**真实值对象*/
    var value: AbsValue?

    /**真实值对象转Json存储*/
    var valueOfJson: String?
}