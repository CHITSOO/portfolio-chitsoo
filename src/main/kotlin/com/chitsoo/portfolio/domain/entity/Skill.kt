package com.chitsoo.portfolio.domain.entity

import com.chitsoo.portfolio.domain.constant.SkillType
import jakarta.persistence.*

@Entity
class Skill(
    name: String,
    type: String, // 생성자에서는 String으로 받음. 어드민 프론트에서 받아서, 내부적으로 찾아서 필드 넣어줌.
    isActive: Boolean
) : BaseEntity() {

    @Id // pk임을 알려줌
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    var id: Long? = null //자료형 뒤에 ?은 null을 허용한다.

    var name: String = name

    @Column(name = "skill_type") // JPA를 활용하기 위해서. 일반명인 type에 이름 달아줌
    @Enumerated(value = EnumType.STRING) // 데이터 정합성 생각해서 String. Ordinary는 선언된 순서대로 1,2,3=>
    var type: SkillType = SkillType.valueOf(type) // 스트링으로 type을 받고, 문자열과 일치하는  enum을 반환해줌.

    var isActive: Boolean = isActive
}