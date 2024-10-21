package com.chitsoo.portfolio.domain.repository

import com.chitsoo.portfolio.domain.entity.Achievement
import org.springframework.data.jpa.repository.JpaRepository

interface AchievementRepository : JpaRepository<Achievement, Long> { // 엔티티와 id

}