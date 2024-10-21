package com.chitsoo.portfolio.domain.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity // JPA에서 테이블에 맵핑되는 엔티티임을 알 수 있음
class Achievement(
    title: String,
    description: String,
    achievedDate: LocalDate?, // nullable이라 ? 넣어줌
    host: String,
    isActive: Boolean
) : BaseEntity() {

    @Id // pk임을 알려줌
    @GeneratedValue(strategy = GenerationType.IDENTITY) // pk 생성전략 - mySQL이 알아서.
    @Column(name = "achievement_id") // db에서는 연결하고, 쓸때는 id로 쓰게.
    var id: Long? = null //자료형 뒤에 ?은 null을 허용한다. 초기값 null

    var title: String = title

    var description: String = description

    var achievedDate: LocalDate? = achievedDate // 위에서 받은 값을 여기다가 넣어주는 거.

    var host: String = host

    var isActive: Boolean = isActive
}