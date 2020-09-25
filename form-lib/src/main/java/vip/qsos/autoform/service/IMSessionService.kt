package vip.qsos.autoform.service

/**消息连接管理接口
 * @author : 华清松
 */
interface IMSessionService : AbsService<Int, Any> {
    /**保存连接信息*/
    fun save(sessionClient: Any)
}