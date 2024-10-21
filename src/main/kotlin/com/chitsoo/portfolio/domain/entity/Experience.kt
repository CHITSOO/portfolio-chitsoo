package com.chitsoo.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class Experience : BaseEntity() {

    @Id // pk임을 알려줌
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "experience_id")
    var id: Long? = null //자료형 뒤에 ?은 null을 허용한다.
}