package vip.qsos.autoform.data_jpa.table

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import javax.persistence.*

@Entity
@Table(name = "form")
@ApiModel(value = "表单表")
class FormEntity {
    constructor()

    /**
     * @param title 表单名称
     * @param notice 表单提示内容
     * @param submitter 表单提交者
     * @param sceneType 表单场景类型
     * @param editable 表单是否可编辑
     */
    constructor(
            title: String,
            notice: String? = null,
            submitter: String? = null,
            sceneType: String? = null,
            editable: Boolean = true
    ) {
        this.title = title
        this.notice = notice
        this.submitter = submitter
        this.sceneType = sceneType
        this.editable = editable
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(value = "主键ID")
    var id: Long = -1L

    @Column(name = "title", unique = false, nullable = false, length = 32)
    @ApiModelProperty(value = "title", required = false)
    var title: String = "未知"

    @Column(name = "notice", unique = false, nullable = true, length = 32)
    @ApiModelProperty(value = "notice", required = false)
    var notice: String? = null

    @Column(name = "submitter", unique = false, nullable = true, length = 16)
    @ApiModelProperty(value = "submitter", required = false)
    var submitter: String? = null

    @Column(name = "scene_type", unique = false, nullable = true, length = 16)
    @ApiModelProperty(value = "sceneType", required = false)
    var sceneType: String? = null

    @Column(name = "editable", unique = false, nullable = false)
    @ApiModelProperty(value = "editable", required = false)
    var editable: Boolean = true

    @OneToMany(
            targetEntity = FormItemEntity::class,
            cascade = [CascadeType.REMOVE],
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "form_id", referencedColumnName = "id")
    var formItems: List<FormItemEntity> = arrayListOf()

}
