package vip.qsos.autoform.api

import org.junit.Before
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

@RunWith(SpringRunner::class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = [ServerLauncher::class]
)
class TestRedisUtil {

    @Resource
    private lateinit var mTableFormRepository: TableFormRepository

    @Resource
    private lateinit var mTableFormItemRepository: TableFormItemRepository

    @Resource
    private lateinit var mTableFormValueRepository: TableFormValueRepository

    private var formId: Long = -1L

    @Before
    fun before() {
        mTableFormRepository.deleteAll()
    }

    @Test
    fun create() {
        val form = FormDemoUtils.Create.feedbackForm()
        formId = mTableFormRepository.save(form).id
        println("创建完成，ID=$formId")
        form.formItems.forEach {
            mTableFormItemRepository.save(it)
            mTableFormValueRepository.saveAll(it.formValues)
        }
    }

    @Test
    fun find() {
        val form = mTableFormRepository.findById(formId).get()
        println(form.toString())
    }

    @Test
    fun findAll() {
        val r = mTableFormRepository.findAll()
        r.forEach {
            println(it.toString())
        }
    }
}