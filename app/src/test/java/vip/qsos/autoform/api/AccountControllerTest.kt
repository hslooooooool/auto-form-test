package vip.qsos.autoform.api

import com.google.gson.Gson
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import vip.qsos.autoform.ServerLauncher
import vip.qsos.autoform.data_jpa.repository.TableFormItemRepository
import vip.qsos.autoform.data_jpa.repository.TableFormRepository
import vip.qsos.autoform.data_jpa.repository.TableFormValueRepository
import vip.qsos.autoform.utils.FormDemoUtils
import javax.annotation.Resource
import javax.transaction.Transactional

@RunWith(SpringRunner::class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = [ServerLauncher::class]
)
open class TestRedisUtil {

    @Resource
    private lateinit var mTableFormRepository: TableFormRepository

    @Resource
    private lateinit var mTableFormItemRepository: TableFormItemRepository

    @Resource
    private lateinit var mTableFormValueRepository: TableFormValueRepository

    @Test
    @Transactional
    open fun create() {
        val form = FormDemoUtils.Create.demo()
        mTableFormRepository.save(form).apply {
            println("表单创建完成，表单-${this.title}，ID=${this.id}")
            this.formItems.forEach {
                println("表单创建完成，表单项-${it.title}，ID=${it.id}")
                it.formValues.forEach { v ->
                    println("表单创建完成，表单项值-${it.title}，ID=${v.id}")
                }
            }
            println("表单数据：\n\n" + Gson().toJson(this) + "\n\n")
        }
    }

}