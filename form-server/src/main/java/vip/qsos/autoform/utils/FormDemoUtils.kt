package vip.qsos.autoform.utils

import vip.qsos.autoform.data_jpa.model.*
import vip.qsos.autoform.data_jpa.table.FormEntity
import vip.qsos.autoform.data_jpa.table.FormItemEntity
import vip.qsos.autoform.data_jpa.table.FormValueEntity

/**表单案例类*/
object FormDemoUtils {

    /**创建一个表单Demo*/
    object Create {

        /**表单案例*/
        fun demo(): FormEntity {
            val form = FormEntity(
                    title = "表单案例DEMO",
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
            val contentValue1 = FormValueEntity(value = FormValueOfInput())
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

        /**常规信息*/
        fun normal(): FormEntity {
            val form = FormEntity(
                    title = "常规信息填报",
                    notice = "您可以通过常规信息上报其它信息",
                    submitter = "单元测试",
                    sceneType = "1",
                    editable = true
            )
            val formItemList = arrayListOf<FormItemEntity>()

            /**上报单位*/
            val desc1 = FormItemEntity(title = "上报单位", notice = "单元测试",
                    valueType = 0, editable = false)
            val descValue1 = FormValueEntity(
                    value = FormValueOfText("单元测试单位")
            )
            descValue1.editable = false
            desc1.formValues = arrayListOf(descValue1)
            formItemList.add(desc1)

            /**信息标题*/
            val content1 = FormItemEntity(title = "信息标题", notice = "请填写内容，必填",
                    valueType = 1, limitMin = 3, limitMax = 30, require = true)
            val contentValue1 = FormValueEntity(value = FormValueOfInput())
            content1.formValues = arrayListOf(contentValue1)
            formItemList.add(content1)

            /**信息等级*/
            val state1 = FormItemEntity(title = "信息等级", notice = "信息等级选择,必选",
                    valueType = 2, limitMin = 1, limitMax = 1, require = true)
            val state1FormValues = arrayListOf<FormValueEntity>()
            arrayListOf("一般", "重要", "紧急", "特急").forEachIndexed { index, s ->
                val stateValue = FormValueEntity(
                        position = index,
                        value = FormValueOfCheck("$index", s, s, index == 0)
                )
                state1FormValues.add(stateValue)
            }
            state1.formValues = state1FormValues
            state1.formValues.sortedBy { it.position }
            formItemList.add(state1)

            /**上报内容*/
            val content2 = FormItemEntity(title = "上报内容", notice = "请填写内容，必填",
                    valueType = 1, limitMin = 3, limitMax = 200, require = true)
            formItemList.add(content2)

            /**附件上传*/
            val file2 = FormItemEntity(title = "附件上传", notice = "所有文件",
                    valueType = 5, limitMin = 0, limitMax = 9, limitFormat = "FILE")
            formItemList.add(file2)

            form.formItems = formItemList
            return form
        }

        /**每日平安信息*/
        fun safety(): FormEntity {
            val form = FormEntity(
                    title = "每日平安信息填报",
                    submitter = "单元测试",
                    sceneType = "2",
                    editable = true
            )
            val formItemList = arrayListOf<FormItemEntity>()

            /**上报单位*/
            val desc1 = FormItemEntity(title = "上报单位", valueType = 0, editable = false)
            val descValue1 = FormValueEntity(
                    value = FormValueOfText("单元测试单位")
            )
            descValue1.editable = false
            desc1.formValues = arrayListOf(descValue1)
            formItemList.add(desc1)

            /**是否安全*/
            val state1 = FormItemEntity(title = "是否安全", notice = "是否安全选择,必选",
                    valueType = 2, limitMin = 1, limitMax = 1, require = true)
            val state1FormValues = arrayListOf<FormValueEntity>()
            arrayListOf("是", "否").forEachIndexed { index, s ->
                val stateValue = FormValueEntity(
                        position = index,
                        value = FormValueOfCheck("$index", s, s, index == 0)
                )
                state1FormValues.add(stateValue)
            }
            state1.formValues = state1FormValues
            state1.formValues.sortedBy { it.position }
            formItemList.add(state1)

            /**上报内容*/
            val content1 = FormItemEntity(title = "上报内容", notice = "请填写上报内容，必填",
                    valueType = 1, limitMin = 3, limitMax = 30, require = true)
            val contentValue1 = FormValueEntity(value = FormValueOfInput())
            content1.formValues = arrayListOf(contentValue1)
            formItemList.add(content1)

            /**附件上传*/
            val file2 = FormItemEntity(title = "附件上传", notice = "所有文件",
                    valueType = 5, limitMin = 0, limitMax = 9, limitFormat = "FILE")
            formItemList.add(file2)

            form.formItems = formItemList
            return form
        }

        /**每日消防信息*/
        fun fireControl(content: String): FormEntity {
            val form = FormEntity(
                    title = "每日消防信息填报",
                    submitter = "单元测试",
                    sceneType = "3",
                    editable = true
            )
            val formItemList = arrayListOf<FormItemEntity>()

            /**上报单位*/
            val desc1 = FormItemEntity(title = "上报单位", valueType = 0, editable = false)
            val descValue1 = FormValueEntity(
                    value = FormValueOfText("单元测试单位")
            )
            descValue1.editable = false
            desc1.formValues = arrayListOf(descValue1)
            formItemList.add(desc1)

            /**信息标题*/
            val title1 = FormItemEntity(title = "信息标题", valueType = 0, editable = false)
            val title1Value1 = FormValueEntity(value = FormValueOfText(content))
            title1Value1.editable = false
            title1.formValues = arrayListOf(title1Value1)
            formItemList.add(title1)

            /**消防要情*/
            val content1 = FormItemEntity(title = "消防要情", notice = "请填写消防要情，选填",
                    valueType = 1, limitMin = 0, limitMax = 300, require = false)
            val contentValue1 = FormValueEntity(value = FormValueOfInput())
            content1.formValues = arrayListOf(contentValue1)
            formItemList.add(content1)

            /**工作动态*/
            val content2 = FormItemEntity(title = "工作动态", notice = "请填写工作动态，选填",
                    valueType = 1, limitMin = 0, limitMax = 300, require = false)
            val contentValue2 = FormValueEntity(value = FormValueOfInput())
            content2.formValues = arrayListOf(contentValue2)
            formItemList.add(content2)

            /**节日（安保）综合情况*/
            val content3 = FormItemEntity(title = "节日（安保）综合情况", notice = "请填写节日（安保）综合情况，选填",
                    valueType = 1, limitMin = 0, limitMax = 300, require = false)
            val contentValue3 = FormValueEntity(value = FormValueOfInput())
            content3.formValues = arrayListOf(contentValue3)
            formItemList.add(content3)

            /**附件上传*/
            val file2 = FormItemEntity(title = "附件上传", notice = "所有文件",
                    valueType = 5, limitMin = 0, limitMax = 9, limitFormat = "FILE")
            formItemList.add(file2)

            form.formItems = formItemList
            return form
        }

        /**每周工作信息*/
        fun weekWork(content: String): FormEntity {
            val form = FormEntity(
                    title = "每周工作信息填报",
                    notice = "各指挥中心主任要严格审核把关，报送内容要简明扼要、突出重点，经常性工作无需上报，每个部分不超过100字，如无可不填，突出情况可单独上报",
                    submitter = "单元测试",
                    sceneType = "4",
                    editable = true
            )
            val formItemList = arrayListOf<FormItemEntity>()

            /**上报单位*/
            val desc1 = FormItemEntity(title = "上报单位", valueType = 0, editable = false)
            val descValue1 = FormValueEntity(
                    value = FormValueOfText("单元测试单位")
            )
            descValue1.editable = false
            desc1.formValues = arrayListOf(descValue1)
            formItemList.add(desc1)

            /**信息标题*/
            val title1 = FormItemEntity(title = "信息标题", valueType = 0, editable = false)
            val title1Value1 = FormValueEntity(value = FormValueOfText(content))
            title1Value1.editable = false
            title1.formValues = arrayListOf(title1Value1)
            formItemList.add(title1)

            /**应急值守*/
            val content1 = FormItemEntity(title = "应急值守", notice = "请填写应急值守内容（分析预警、舆情监控、信息报送、态势标绘、视频督导、重大活动安保等），选填",
                    valueType = 1, limitMin = 0, limitMax = 100, require = false)
            val contentValue1 = FormValueEntity(value = FormValueOfInput())
            content1.formValues = arrayListOf(contentValue1)
            formItemList.add(content1)

            /**调度指挥*/
            val content2 = FormItemEntity(title = "调度指挥", notice = "请填写调度指挥（重要灾情、调度指挥、接警调度、辅助决策、跨区域增援调度等），选填",
                    valueType = 1, limitMin = 0, limitMax = 100, require = false)
            val contentValue2 = FormValueEntity(value = FormValueOfInput())
            content2.formValues = arrayListOf(contentValue2)
            formItemList.add(content2)

            /**岗位练兵*/
            val content3 = FormItemEntity(title = "岗位练兵", notice = "请填写岗位练兵（岗位练兵开展情况，包括业务培训、大讲堂、比武、复盘演练等），选填",
                    valueType = 1, limitMin = 0, limitMax = 100, require = false)
            val contentValue3 = FormValueEntity(value = FormValueOfInput())
            content3.formValues = arrayListOf(contentValue3)
            formItemList.add(content3)

            /**制度规范*/
            val content4 = FormItemEntity(title = "制度规范", notice = "请填写制度规范（制定标准规范、印发文件规定、应急联动、值班值守等机制），选填",
                    valueType = 1, limitMin = 0, limitMax = 100, require = false)
            val contentValue4 = FormValueEntity(value = FormValueOfInput())
            content4.formValues = arrayListOf(contentValue4)
            formItemList.add(content4)

            /**业务研究*/
            val content5 = FormItemEntity(title = "业务研究", notice = "请填写业务研究（“十四五”规划、调研座谈、智能接处警系统、信息报送系统、正规化建设、改造扩建、亮点创新等），选填",
                    valueType = 1, limitMin = 0, limitMax = 100, require = false)
            val contentValue5 = FormValueEntity(value = FormValueOfInput())
            content5.formValues = arrayListOf(contentValue5)
            formItemList.add(content5)

            /**其他事项*/
            val content6 = FormItemEntity(title = "其他事项", notice = "请填写其他事项（领导视察慰问、重要批示、重大事项报告、上级交办等），选填",
                    valueType = 1, limitMin = 0, limitMax = 100, require = false)
            val contentValue6 = FormValueEntity(value = FormValueOfInput())
            content6.formValues = arrayListOf(contentValue6)
            formItemList.add(content6)

            /**下周工作*/
            val content7 = FormItemEntity(title = "下周工作", notice = "请填写下周工作，选填",
                    valueType = 1, limitMin = 0, limitMax = 100, require = false)
            val contentValue7 = FormValueEntity(value = FormValueOfInput())
            content7.formValues = arrayListOf(contentValue7)
            formItemList.add(content6)

            form.formItems = formItemList
            return form
        }

    }

}