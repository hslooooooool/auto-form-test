package vip.qsos.autoform.api

import org.springframework.web.bind.annotation.RestController
import vip.qsos.autoform.model.BaseResult
import vip.qsos.autoform.utils.FormDemoUtils
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RestController
class AccountController : AccountApi {

    override fun demo(sceneType: String?): BaseResult {
        val demo = when (sceneType) {
            "1" -> FormDemoUtils.Create.normal()
            "2" -> FormDemoUtils.Create.safety()
            "3" -> FormDemoUtils.Create.fireControl(
                    "测试单位每日消防信息（${LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))}）"
            )
            "4" -> FormDemoUtils.Create.weekWork(
                    "测试单位每周工作信息（${LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))}）"
            )
            "5" -> FormDemoUtils.Create.sheet()
            else -> FormDemoUtils.Create.demo()
        }

        return BaseResult.data(data = demo)
    }

}