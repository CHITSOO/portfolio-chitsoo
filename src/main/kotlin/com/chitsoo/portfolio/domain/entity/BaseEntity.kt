package com.chitsoo.portfolio.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime

@MappedSuperclass // 이 클래스를 상속받는 클래스가 칼럼과 맵핑가능.
abstract class BaseEntity {

    @CreatedDate // JPA가 생성된 시간을 자동으로 생성
    @Column(nullable = false, updatable = false) // 값이 항상 있어야 하고, 생성일시라서 수정되면 안되어서 넣어줌
    var createdDateTime: LocalDateTime = LocalDateTime.now()

    @LastModifiedDate // 수정된 마지막 일시
    @Column(nullable = false)
    var updatedDateTime: LocalDateTime = LocalDateTime.now()


}