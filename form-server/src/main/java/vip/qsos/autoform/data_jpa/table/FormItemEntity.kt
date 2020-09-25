package vip.qsos.autoform.data_jpa.table

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "form_item")
@ApiModel(value = "表单项表")
class FormItemEntity : AbsTable {
    constructor()

    /**
     * * @param title 表单项名称
     * @param notice 表单项提示内容
     * @param valueType 表单项值类型，如：0：文本展示；1：输入；2：选项；3：时间；4：人员；5：文件；6：位置
     * @param editable 表单项是否可编辑
     * @param position 表单项顺序
     * @param visible 表单项是否显示
     * @param require 表单项是否必填
     * @param limitMin 值的最小数量
     * @param limitMax 值的最大数量
     * @param limitFormat 值格式限制。如：选用户的时候，可为角色字段;选时间的时候,可为时间格式；多个条件可用";"分割，不传不限制
     * */
    constructor(
            title: String,
            notice: String? = null,
            valueType: Int = 0,
            position: Int = 0,
            editable: Boolean = true,
            visible: Boolean = true,
            require: Boolean = false,
            limitMin: Int = 0,
            limitMax: Int = 0,
            limitFormat: String? = null
    ) {
        this.title = title
        this.notice = notice
        this.valueType = valueType
        this.position = position
        this.editable = editable
        this.visible = visible
        this.require = require
        this.limitMin = limitMin
        this.limitMax = limitMax
        this.limitFormat = limitFormat
    }

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(value = "主键ID")
    var id: Long = -1L

    @Column(name = "title", unique = false, nullable = false, length = 32)
    @ApiModelProperty(value = "title", required = false)
    var title: String = ""

    @Column(name = "notice", unique = false, nullable = true, length = 64)
    @ApiModelProperty(value = "notice", required = false)
    var notice: String? = null

    @Column(name = "value_type", unique = false, nullable = false, length = 32)
    @ApiModelProperty(value = "valueType", required = false)
    var valueType: Int = 0

    @Column(name = "position", unique = false, nullable = false, length = 16)
    @ApiModelProperty(value = "position", required = false)
    var position: Int = 0

    @Column(name = "editable", unique = false, nullable = false)
    @ApiModelProperty(value = "editable", required = false)
    var editable: Boolean = true

    @Column(name = "visible", unique = false, nullable = false)
    @ApiModelProperty(value = "visible", required = false)
    var visible: Boolean = true

    @Column(name = "require", unique = false, nullable = false)
    @ApiModelProperty(value = "require", required = false)
    var require: Boolean = false

    @Column(name = "limit_min", unique = false, nullable = false, length = 16)
    @ApiModelProperty(value = "limitMin", required = false)
    var limitMin: Int = 0

    @Column(name = "limit_max", unique = false, nullable = false, length = 32)
    @ApiModelProperty(value = "limitMax", required = false)
    var limitMax: Int = 0

    @Column(name = "limit_format", unique = false, nullable = true, length = 32)
    @ApiModelProperty(value = "limitFormat", required = false)
    var limitFormat: String? = null

    @ManyToOne(targetEntity = FormEntity::class, fetch = FetchType.LAZY)
    @JoinColumn(name = "form_id", referencedColumnName = "id")
    var form: FormEntity? = null

    @OneToMany(
            targetEntity = FormValueEntity::class,
            cascade = [CascadeType.ALL],
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "form_value_id", referencedColumnName = "id")
    var formValues: List<FormValueEntity> = arrayListOf()

    @Transient
    var formValue: FormValueEntity? = null
        get() = if (formValues.isEmpty()) null else formValues[0]
        set(value) {
            field = value
            value?.let {
                val vs = arrayListOf<FormValueEntity>()
                vs.addAll(formValues)
                if (formValues.isNotEmpty()) {
                    vs.removeAt(0)
                }
                vs.add(0, value)
                formValues = vs
            }
        }

    @Transient
    var limitTypeList: List<String>? = null
        get() {
            if (field == null) {
                field = limitFormat?.toLowerCase(Locale.ENGLISH)?.split(";") ?: arrayListOf()
            }
            return field
        }

}