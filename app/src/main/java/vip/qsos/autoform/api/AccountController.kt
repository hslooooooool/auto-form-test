package vip.qsos.autoform.api

import org.springframework.web.bind.annotation.RestController
import vip.qsos.autoform.model.BaseResult

@RestController
class AccountController constructor(

) : AccountApi {

    override fun assign(): BaseResult {
        return BaseResult.data(data = "")
    }

    override fun list(used: Boolean?): BaseResult {
        return BaseResult.data(data = "")
    }

    override fun init(size: Int): BaseResult {

        return BaseResult.data(data = "")
    }
}