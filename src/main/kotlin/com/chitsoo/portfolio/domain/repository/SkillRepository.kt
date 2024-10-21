package com.chitsoo.portfolio.domain.repository

import com.chitsoo.portfolio.domain.entity.Skill
import org.springframework.data.jpa.repository.JpaRepository

interface SkillRepository : JpaRepository<Skill, Long>