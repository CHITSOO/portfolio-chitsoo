package com.chitsoo.portfolio.domain.constant

enum class SkillType {
    LANGUAGE, FRAMEWORK, DATABASE, TOOL // 이거는 순서대로 숫자로 들어가. 그래서 enum 쓸때는 STRING으로 지정해주는게 반드시 필요.
    // 물론 STRING은 데이터 용량을 더 차지한다는 단점이 있긴함.
    // 타협점으로는 ATTRIBUTE CONBUTOR 이런게 있음.
}