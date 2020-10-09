package vip.qsos.autoform.api

import com.github.xiaoymin.knife4j.annotations.ApiSort
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import vip.qsos.autoform.model.BaseResult

@Api(tags = ["消息账号"])
@ApiSort(1)
@RequestMapping("/api/form")
interface AccountApi {

    @ApiOperation(value = "获取表单案例")
    @GetMapping("/demo")
    fun demo(
            @RequestParam
            @ApiParam(value = "表单场景", name = "sceneType", required = false, defaultValue = "1", type = "String")
            sceneType: String? = null
    ): BaseResult

}