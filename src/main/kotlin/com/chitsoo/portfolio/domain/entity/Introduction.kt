package com.chitsoo.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class Introduction(
    content: String,
    isActive: Boolean
) : BaseEntity() {

    @Id // pk임을 알려줌
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "introduction_id")
    var id: Long? = null //자료형 뒤에 ?은 null을 허용한다.

    var content: String = content

    var isActive: Boolean = isActive

}