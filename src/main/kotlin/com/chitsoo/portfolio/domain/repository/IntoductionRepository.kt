package com.chitsoo.portfolio.domain.repository

import com.chitsoo.portfolio.domain.entity.Introduction
import org.springframework.data.jpa.repository.JpaRepository

interface IntoductionRepository : JpaRepository<Introduction, Long>