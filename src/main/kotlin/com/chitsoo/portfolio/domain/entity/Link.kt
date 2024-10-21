package com.chitsoo.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class Link(
    name: String,
    content: String,
    isActive: Boolean
) : BaseEntity() {

    @Id // pk임을 알려줌
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "link_id")
    var id: Long? = null //자료형 뒤에 ?은 null을 허용한다.

    var name: String = name //@Column 안붙이면 알아서 db에서 찾아서 맵핑됨

    var content: String = content

    var isActive: Boolean = isActive // DB에서는 camel이 알아서 snake로 바뀌어서 들어감
}