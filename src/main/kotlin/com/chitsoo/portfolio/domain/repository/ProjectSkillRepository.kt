package com.chitsoo.portfolio.domain.repository

import com.chitsoo.portfolio.domain.entity.ProjectSkill
import org.springframework.data.jpa.repository.JpaRepository

interface ProjectSkillRepository : JpaRepository<ProjectSkill, Long> { // 다대다라서 필요해서 만듦

}