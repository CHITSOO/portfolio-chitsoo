package com.chitsoo.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class Experience(
    title: String,
    description: String,
    startYear: Int,
    startMonth: Int,
    endYear: Int?, // 없으면 진행중
    endMonth: Int?,
    isActive: Boolean
) : BaseEntity() {

    @Id // pk임을 알려줌
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "experience_id")
    var id: Long? = null //자료형 뒤에 ?은 null을 허용한다.

    var title: String = title

    var description: String = description

    var startYear: Int = startYear

    var startMonth: Int = startMonth

    var endYear: Int? = endYear

    var endMonth: Int? = endMonth

    var isActive: Boolean = isActive

    @OneToMany(targetEntity = ExperienceDetail::class,// One이 Expreirence, 아래가 Many.
        fetch = FetchType.LAZY, // 부모가 용의자면 자식도 혐의가 잇을 거라고 생각해서 Eager로 해두면 묶인 Details까지 다 가져옴. 그래서 Details N번 더 쿼리 조회하고 + 자기자신 1번 더 호출함. 그래서 안좋음. Lazy는 말그대로 필요할 떄만 찾으러 감. 다 필요하면 결국 다 조회하니 근본해결법은 아님.
        cascade = [CascadeType.ALL]) // 영속성 컨택스트와 관련이 있는 개념. 부모가 여기에 들어가 있을 떄 자식도? (All은 맞음.)
    @JoinColumn(name = "experience_id") // 맵핑의 기준이 뭔지
    var details: MutableList<ExperienceDetail> = mutableListOf() // 빈리스트. mutable은 변할 수 있다는 뜻

    fun getEndYearMonth() : String {
        if (endYear == null || endMonth == null) {
            return "Present"
        }

        return "${endYear}.${endMonth}"
    }

    fun update( title: String, description: String, startYear: Int, startMonth: Int, endYear: Int?, /* 없으면 진행중*/ endMonth: Int?, isActive: Boolean) {
        this.title = title
        this.description = description
        this.startYear = startYear
        this.startMonth = startMonth
        this.endYear = endYear
        this.endMonth = endMonth
        this.isActive = isActive
    }

    fun addDetails(details: MutableList<ExperienceDetail>?) {
        if(details != null) {
            this.details.addAll(details)
        }
    }
}