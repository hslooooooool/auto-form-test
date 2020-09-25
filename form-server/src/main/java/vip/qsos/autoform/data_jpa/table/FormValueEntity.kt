package vip.qsos.autoform.data_jpa.table

import com.google.gson.Gson
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import vip.qsos.autoform.model.db.AbsValue
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
            value: AbsValue? = null
    ) {
        this.limitFormat = limitFormat
        this.editable = editable
        this.position = position
        this.value = value
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

    @NotNull
    @Column(name = "value", unique = false, nullable = false, length = 255)
    @ApiModelProperty(value = "valueOfJson", required = false)
    var valueOfJson: String? = null

    @Transient
    var value: AbsValue? = null
        set(value) {
            field = value
            field?.let {
                valueOfJson = Gson().toJson(it)
            }
        }

    @ManyToOne(targetEntity = FormItemEntity::class, fetch = FetchType.LAZY)
    @JoinColumn(name = "form_value_id", referencedColumnName = "id")
    var formItem: FormItemEntity? = null

}