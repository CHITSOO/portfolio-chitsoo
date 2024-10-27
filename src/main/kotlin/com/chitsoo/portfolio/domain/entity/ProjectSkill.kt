package com.chitsoo.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class ProjectSkill(project: Project, skill: Skill) : BaseEntity() {

    @Id // pk임을 알려줌
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_skill_id")
    var id: Long? = null //자료형 뒤에 ?은 null을 허용한다.

    @ManyToOne(targetEntity = Project::class, fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false) // nullable하면 맵핑이 끊김
    var project: Project = project

    @ManyToOne(targetEntity = Skill::class, fetch = FetchType.LAZY)
    @JoinColumn(name = "skill_id", nullable = false)
    var skill: Skill = skill
}