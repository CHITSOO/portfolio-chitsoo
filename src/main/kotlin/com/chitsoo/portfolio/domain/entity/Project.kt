package com.chitsoo.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class Project(
    name: String,
    description: String,
    startYear: Int,
    startMonth: Int,
    endYear: Int?, // 없으면 진행중
    endMonth: Int?,
    isActive: Boolean
) : BaseEntity() {

    @Id // pk임을 알려줌
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    var id: Long? = null //자료형 뒤에 ?은 null을 허용한다.

    var name: String = name

    var description: String = description

    var startYear: Int = startYear

    var startMonth: Int = startMonth

    var endYear: Int? = endYear

    var endMonth: Int? = endMonth

    var isActive: Boolean = isActive

    @OneToMany(targetEntity = ProjectDetail::class,
        fetch = FetchType.LAZY,
        cascade = [CascadeType.ALL])
    @JoinColumn(name = "project_id")
    var details: MutableList<ProjectDetail> = mutableListOf()

    @OneToMany(mappedBy = "project") // 양방향 연관관계의 주인을 지정. ProjectSkill에 project를 추가할건데, 이 아이를 통해 맵핑이 된다.. 맵핑을 하는 애는 ProjectSkill이고, 당하는애가 project.그래서 수동태
    var skills: MutableList<ProjectSkill> = mutableListOf() // 비어있는 리스트

    fun getEndYearMonth() : String {
        if (endYear == null || endMonth == null) {
            return "Present"
        }

        return "${endYear}.${endMonth}"
    }

    fun update( name: String, description: String, startYear: Int, startMonth: Int, endYear: Int?, /* 없으면 진행중*/ endMonth: Int?, isActive: Boolean) {
        this.name = name
        this.description = description
        this.startYear = startYear
        this.startMonth = startMonth
        this.endYear = endYear
        this.endMonth = endMonth
        this.isActive = isActive
    }

    fun addDetails(details: MutableList<ProjectDetail>?) {
        if(details != null) {
            this.details.addAll(details)
        }
    }
}