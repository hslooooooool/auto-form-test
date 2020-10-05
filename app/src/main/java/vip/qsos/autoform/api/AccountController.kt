package vip.qsos.autoform.api

import org.springframework.web.bind.annotation.RestController
import vip.qsos.autoform.model.BaseResult
import vip.qsos.autoform.utils.FormDemoUtils

@RestController
class AccountController : AccountApi {

    override fun demo(type: String?): BaseResult {
        val demo = FormDemoUtils.Create.feedbackForm()
        return BaseResult.data(data = demo)
    }

    override fun init(size: Int): BaseResult {
        return BaseResult.data(data = "")
    }

}