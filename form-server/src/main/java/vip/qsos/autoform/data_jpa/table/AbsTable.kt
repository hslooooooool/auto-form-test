package vip.qsos.autoform.data_jpa.table

import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.MappedSuperclass

/**
 * @author : 华清松
 * 数据库表通用字段
 */
@MappedSuperclass
abstract class AbsTable(
        @JsonIgnore
        @Column(name = "gmt_create", nullable = false)
        var gmtCreate: LocalDateTime = LocalDateTime.now(),

        @JsonIgnore
        @Column(name = "gmt_update", nullable = false)
        var gmtUpdate: LocalDateTime = LocalDateTime.now(),

        @JsonIgnore
        @Column(name = "deleted", nullable = false)
        var deleted: Boolean = false
)