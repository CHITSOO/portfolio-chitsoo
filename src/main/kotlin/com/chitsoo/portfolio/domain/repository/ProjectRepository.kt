package com.chitsoo.portfolio.domain.repository

import com.chitsoo.portfolio.domain.entity.Project
import org.springframework.data.jpa.repository.JpaRepository

interface ProjectRepository : JpaRepository<Project, Long>