package vip.qsos.autoform.utils

import vip.qsos.autoform.data_jpa.model.*
import vip.qsos.autoform.data_jpa.table.FormEntity
import vip.qsos.autoform.data_jpa.table.FormItemEntity
import vip.qsos.autoform.data_jpa.table.FormValueEntity

/**表单案例类*/
object FormDemoUtils {

    /**创建一个表单Demo*/
    object Create {
        /**反馈表单*/
        fun feedbackForm(): FormEntity {
            val form = FormEntity(
                    title = "表单案例",
                    notice = "这是一个表单填写案例",
                    submitter = "单元测试",
                    sceneType = "单元测试",
                    editable = true
            )
            val formItemList = arrayListOf<FormItemEntity>()

            /**说明*/
            val desc1 = FormItemEntity(title = "文本举例1", notice = "文本举例1",
                    valueType = 0, editable = false)
            val descValue1 = FormValueEntity(
                    value = FormValueOfText("填写表单,帮助我们解决问题,您将有机会获得优惠券,感谢支持!")
            )
            descValue1.editable = false
            desc1.formValues = arrayListOf(descValue1)
            formItemList.add(desc1)

            /**说明*/
            val desc2 = FormItemEntity(title = "文本举例2", notice = "文本举例2",
                    valueType = 0, editable = false)
            val descValue2 = FormValueEntity(
                    value = FormValueOfText("填写表单,帮助我们解决问题,您将有机会获得优惠券,感谢支持!填写表单,帮助我们解决问题,您将有机会获得优惠券,感谢支持!填写表单,帮助我们解决问题,您将有机会获得优惠券,感谢支持!")
            )
            descValue2.editable = false
            val array2 = arrayListOf<FormValueEntity>()
            array2.add(descValue2)
            desc2.formValues = array2
            formItemList.add(desc2)

            /**内容*/
            val content1 = FormItemEntity(title = "内容举例1", notice = "请填写内容，必填",
                    valueType = 1, limitMin = 5, limitMax = 100, require = true)
            val contentValue1 = FormValueEntity(value = FormValueOfText())
            content1.formValues = arrayListOf(contentValue1)
            formItemList.add(content1)

            /**内容*/
            val content2 = FormItemEntity(title = "内容举例2", notice = "请填写内容，非必填",
                    valueType = 1, limitMin = 0, limitMax = 200, require = false)
            formItemList.add(content2)

            /**单选举例*/
            val state1 = FormItemEntity(title = "单选举例1", notice = "单选举例,必选",
                    valueType = 2, limitMin = 1, limitMax = 1, require = true)
            val state1FormValues = arrayListOf<FormValueEntity>()
            for (i in 1..2) {
                val stateValue = FormValueEntity(
                        position = i,
                        value = FormValueOfCheck("$i", "选项$i", "$i")
                )
                state1FormValues.add(stateValue)
            }
            state1.formValues = state1FormValues
            state1.formValues.sortedBy { it.position }
            formItemList.add(state1)

            /**单选举例*/
            val state2 = FormItemEntity(title = "单选举例2", notice = "单选举例,非必选",
                    valueType = 2, limitMin = 1, limitMax = 1, require = false)
            val state2FormValues = arrayListOf<FormValueEntity>()
            for (i in 1..4) {
                val stateValue = FormValueEntity(
                        position = i,
                        value = FormValueOfCheck("$i", "选项$i", "$i")
                )
                state2FormValues.add(stateValue)
            }
            state2.formValues = state2FormValues
            state2.formValues.sortedBy { it.position }
            formItemList.add(state2)

            /**位置举例*/
            val location = FormItemEntity(title = "位置举例", notice = "位置举例,必选",
                    valueType = 6, limitMin = 1, limitMax = 1, require = true)
            formItemList.add(location)

            /**多选举例*/
            val type1 = FormItemEntity(title = "多选举例1", notice = "多选举例,必选",
                    valueType = 2, limitMin = 1, limitMax = 3, require = true)
            val type1FormValues = arrayListOf<FormValueEntity>()
            for (i in 1..7) {
                val typeValue = FormValueEntity(
                        position = i,
                        value = FormValueOfCheck("$i", "选项$i", "$i")
                )
                type1FormValues.add(typeValue)
            }
            type1.formValues = type1FormValues
            type1.formValues.sortedBy { it.position }
            formItemList.add(type1)

            /**多选举例*/
            val type2 = FormItemEntity(title = "多选举例2", notice = "多选举例,非必选",
                    valueType = 2, limitMin = 0, limitMax = 0, require = false)
            val type2FormValues = arrayListOf<FormValueEntity>()
            for (i in 1..5) {
                val typeValue = FormValueEntity(
                        position = i,
                        value = FormValueOfCheck("$i", "选项$i", "$i", false)
                )
                type2FormValues.add(typeValue)

            }
            type2.formValues = type2FormValues
            type2.formValues.sortedBy { it.position }
            formItemList.add(type2)

            /**时间举例*/
            val nowTime = System.currentTimeMillis()
            val limitTime = 5L * 365 * 60 * 24 * 1000 * 60
            val time1 = FormItemEntity(title = "时间举例1", notice = "时间举例,必选",
                    valueType = 3, require = true)
            val timeValue1 = FormValueEntity(
                    position = 1, limitFormat = "yyyy-MM-dd HH:mm",
                    value = FormValueOfTime(nowTime, nowTime - limitTime, nowTime + limitTime))
            time1.formValues = arrayListOf(timeValue1)
            time1.formValues.sortedBy { it.position }
            formItemList.add(time1)

            /**时间举例*/
            val time2 = FormItemEntity(title = "时间举例2", notice = "时间举例,非必选",
                    valueType = 3, editable = false)
            val timeValue2 = FormValueEntity(
                    position = 1, limitFormat = "yyyy-MM-dd HH:mm",
                    value = FormValueOfTime(nowTime, nowTime - limitTime, nowTime + limitTime)
            )
            time2.formValues = arrayListOf(timeValue2)
            time2.formValues.sortedBy { it.position }
            formItemList.add(time2)

            /**附件上传*/
            val file = FormItemEntity(title = "附件举例1", notice = "全是图片",
                    valueType = 5, limitMin = 0, limitMax = 9, limitFormat = "IMAGE")
            val fileValue = FormValueEntity(
                    value = FormValueOfFile(fileName = "测试图片", fileUrl = "http://www.qsos.vip/upload/2018/11/ic_launcher20181225044818498.png")
            )
            file.formValues = arrayListOf(fileValue)
            formItemList.add(file)

            /**附件上传*/
            val file2 = FormItemEntity(title = "附件举例2", notice = "所有文件",
                    valueType = 5, limitMin = 0, limitMax = 9, limitFormat = "FILE")
            val file2FormValues = arrayListOf<FormValueEntity>()
            for (i in 1..2) {
                val file2Value = FormValueEntity(
                        value = FormValueOfFile(fileName = "测试文件$i", fileUrl = "http://www.qsos.vip/upload/2018/11/ic_launcher20181225044818498.png")
                )
                file2Value.editable = i != 1
                file2FormValues.add(file2Value)
            }
            file2.formValues = file2FormValues
            formItemList.add(file2)

            /**人员举例*/
            val user = FormItemEntity(title = "人员举例1", notice = "管理员，至少一人",
                    valueType = 4, limitMin = 1, limitFormat = "ADMIN", require = true)
            val userFormValues = arrayListOf<FormValueEntity>()
            for (i in 1..2) {
                val userValue = FormValueEntity(
                        value = FormValueOfUser(userName = "管理人员$i", userAvatar = "http://www.qsos.vip/upload/2018/11/ic_launcher20181225044818498.png")
                )
                userFormValues.add(userValue)
            }
            user.formValues = userFormValues
            formItemList.add(user)

            /**人员举例*/
            val user2 = FormItemEntity(title = "人员举例2", notice = "抄送人员，必须抄送给抄送人1", valueType = 4)
            val user2FormValues = arrayListOf<FormValueEntity>()
            for (i in 1..3) {
                val value = FormValueEntity(
                        value = FormValueOfUser(userName = "抄送人员$i", userAvatar = "http://www.qsos.vip/upload/2018/11/ic_launcher20181225044818498.png")
                )
                value.editable = i != 1
                user2FormValues.add(value)
            }
            user2.formValues = user2FormValues
            formItemList.add(user2)

            form.formItems = formItemList
            return form
        }
    }

}