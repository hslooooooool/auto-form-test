package vip.qsos.autoform.data_jpa.model

import com.google.gson.Gson
import vip.qsos.autoform.model.db.AbsValue
import java.util.*

/**表单项值-文件实体类
 * @author : 华清松
 * @param fileId 文件ID
 * @param fileName 文件名称
 * @param fileType 文件类型 IMAGE, VIDEO, AUDIO, FILE
 * @param fileUrl 文件服务器路径地址，如http://qsos.vip/file/logo.png
 * @param fileCover 文件封面地址，如http://qsos.vip/file/logo.png或/0/data/app1/logo.png
 * */
data class FormValueOfFile constructor(
        var fileId: String? = null,
        var fileName: String = "",
        var fileType: Type = Type.FILE,
        var fileUrl: String? = null,
        var fileCover: String? = null
) : AbsValue {
    override val valueType: Int = 5
    override fun json(): String {
        return Gson().toJson(this)
    }

    enum class Type { IMAGE, ALBUM, VIDEO, AUDIO, FILE }

    companion object {
        fun getFileTypeByMime(fileType: String?): Type {
            return when (fileType?.toUpperCase(Locale.ENGLISH)) {
                Type.IMAGE.name -> Type.IMAGE
                Type.ALBUM.name -> Type.ALBUM
                Type.VIDEO.name -> Type.VIDEO
                Type.AUDIO.name -> Type.AUDIO
                else -> Type.FILE
            }
        }
    }
}