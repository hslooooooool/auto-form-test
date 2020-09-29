package vip.qsos.autoform.data_jpa.table

import com.fasterxml.jackson.annotation.JsonIgnore
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import vip.qsos.autoform.model.db.AbsValue
import vip.qsos.autoform.utils.FormTransUtils
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "form_value")
@ApiModel(value = "表单项值表")
class FormValueEntity : AbsTable {
    constructor()

    /**
     * @param limitFormat 限制条件
     * @param editable 是否可编辑
     * @param position 顺序
     * @param value 真实值对象
     */
    constructor(
            limitFormat: String? = null,
            editable: Boolean = true,
            position: Int = 1,
            value: AbsValue
    ) {
        this.limitFormat = limitFormat
        this.editable = editable
        this.position = position
        this.value = value
        this.valueType = value.valueType
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(value = "主键ID")
    var id: Long = -1L

    @Column(name = "limit_format", unique = false, nullable = true, length = 32)
    @ApiModelProperty(value = "limitFormat", required = false)
    var limitFormat: String? = null

    @Column(name = "editable", unique = false, nullable = false)
    @ApiModelProperty(value = "editable", required = false)
    var editable: Boolean = true

    @Column(name = "position", unique = false, nullable = false, length = 32)
    @ApiModelProperty(value = "position", required = false)
    var position: Int = 1

    @Column(name = "value_type", unique = false, nullable = false, length = 32)
    @ApiModelProperty(value = "valueType", required = false)
    var valueType: Int = 0

    @NotNull
    @Column(name = "form_value", unique = false, nullable = false, length = 255)
    @ApiModelProperty(value = "formValue", required = false)
    var formValue: String? = null

    @Transient
    @JsonIgnore
    @ApiModelProperty(value = "value", required = false)
    var value: AbsValue? = null
        set(value) {
            field = value
            field?.let {
                this.formValue = FormTransUtils.transValue(it)
            }
        }
        get() {
            return when {
                field != null -> {
                    field
                }
                formValue != null -> {
                    field = FormTransUtils.tansValue(valueType, formValue!!)
                    field
                }
                else -> null
            }
        }

    @JsonIgnore
    @ManyToOne(targetEntity = FormItemEntity::class, fetch = FetchType.LAZY)
    @JoinColumn(name = "form_value_id", referencedColumnName = "id")
    var formItem: FormItemEntity? = null

}