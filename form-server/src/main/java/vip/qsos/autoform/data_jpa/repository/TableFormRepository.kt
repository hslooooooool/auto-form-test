package vip.qsos.autoform.data_jpa.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import vip.qsos.autoform.data_jpa.table.FormEntity

@Repository
interface TableFormRepository : JpaRepository<FormEntity, Long>