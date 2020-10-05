package vip.qsos.autoform.utils

import com.google.gson.Gson
import com.google.gson.JsonParseException
import vip.qsos.autoform.data_jpa.model.*
import vip.qsos.autoform.model.db.AbsValue

object FormTransUtils {

    fun transValue(value: AbsValue): String {
        return Gson().toJson(value)
    }

    fun tansValue(valueType: Int, json: String): AbsValue? {
        return Gson().fromJson(json,
                when (valueType) {
                    0 -> FormValueOfText::class.java
                    1 -> FormValueOfInput::class.java
                    2 -> FormValueOfCheck::class.java
                    3 -> FormValueOfTime::class.java
                    4 -> FormValueOfUser::class.java
                    5 -> FormValueOfFile::class.java
                    6 -> FormValueOfLocation::class.java
                    else -> throw JsonParseException("表单项类型不存在")
                })
    }
}