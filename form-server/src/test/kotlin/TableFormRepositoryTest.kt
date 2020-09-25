
import org.aspectj.weaver.ast.Test


@RunWith(SpringRunner::class) //不加此注解会报错
@SpringBootTest
class TableFormRepositoryTest {
    @Resource
    private val userService: IUserService? = null

    @Test
    fun saveUser() {
        userService.saveUsers(Users(1, "root", "root"))
    }

    @get:Test
    val allUser: Unit
        get() {
            val users: List<Users> = userService.getAllUser()
            for (user in users) {
                java.lang.System.out.println(user)
            }
        }

    @get:Test
    val userByName: Unit
        get() {
            val users: List<Users> = userService.getUserByUserName("root")
            for (user in users) {
                java.lang.System.out.println(user)
            }
        }

    @get:Test
    val userByPassword: Unit
        get() {
            val users: List<Users> = userService.getUserByPassword("root")
            for (user in users) {
                java.lang.System.out.println(user)
            }
        }
}