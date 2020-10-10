package vip.qsos.autoform.api

import com.github.xiaoymin.knife4j.annotations.ApiSort
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import vip.qsos.autoform.model.BaseResult

@Api(tags = ["表单案例"])
@ApiSort(1)
@RequestMapping("/api/form")
interface AccountApi {

    @ApiOperation(value = "获取表单案例")
    @GetMapping("/demo")
    fun demo(
            @RequestParam
            @ApiParam(value = "表单场景，0：案例1：常规信息2：每日平安3：每日消防4：每周工作", name = "sceneType", required = false, defaultValue = "0", type = "String")
            sceneType: String? = null
    ): BaseResult

}