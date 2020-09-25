package vip.qsos.autoform.model.form

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.io.Serializable
import javax.validation.constraints.NotNull

/**发送指令消息实体
 * @author : 华清松
 */
@ApiModel(description = "发送指令消息")
data class SendMessageOfOrderForm constructor(
        @ApiModelProperty(value = "消息指令", required = true)
        @NotNull(message = "消息指令不能为空")
        var action: String,
        @ApiModelProperty(value = "消息发送者账号", required = true)
        @NotNull(message = "发送账号不能为空")
        var sender: String,
        @ApiModelProperty(value = "消息接收账号", required = true)
        @NotNull(message = "接收账号不能为空")
        var receiver: String,
        @ApiModelProperty(value = "消息内容", required = true)
        @NotNull(message = "消息内容不能为空")
        var content: String,
        @ApiModelProperty(value = "消息类型", required = true)
        @NotNull(message = "消息类型不能为空")
        var contentType: Int = 0,
        @ApiModelProperty(value = "消息附加信息")
        var extra: String? = null
) : Serializable