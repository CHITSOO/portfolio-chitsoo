package com.chitsoo.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class ExperienceDetail( // Experience -> ExperienceDetail(o) <- (x) : 1대1 단방향 연관관계
    content: String,
    isActive: Boolean
) : BaseEntity() {

    @Id // pk임을 알려줌
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "experience_detail_id")
    var id: Long? = null //자료형 뒤에 ?은 null을 허용한다.

    var content: String = content

    var isActive: Boolean = isActive

    fun update(content: String, isActibe: Boolean) {
        this.content = content
        this.isActive = isActive
    }
}