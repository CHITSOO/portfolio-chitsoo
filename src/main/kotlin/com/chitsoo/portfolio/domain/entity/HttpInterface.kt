package com.chitsoo.portfolio.domain.entity

import jakarta.persistence.*
import jakarta.servlet.http.HttpServletRequest

@Entity
class HttpInterface(httpServletRequest: HttpServletRequest) : BaseEntity() { // http 요청정보받기 위함

    @Id // pk임을 알려줌
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "http_interface_id")
    var id: Long? = null //자료형 뒤에 ?은 null을 허용한다.

    var cookies: String? = httpServletRequest.cookies
        ?.map { "${it.name}:${it.value}" }
        ?.toString() // ?은 null 아닐때만 실행되게 해서 NPE를 막아줌.

    var referer: String? = httpServletRequest.getHeader("referer") // 구글 닷컴의 도메인. 요청이 어디에서 왔냐.

    var localAddr: String? = httpServletRequest.localAddr

    var remoteAddr: String? = httpServletRequest.remoteAddr

    var remoteHost: String? = httpServletRequest.remoteHost

    var requestUri: String? = httpServletRequest.requestURI // main이면 /

    var userAgent: String? = httpServletRequest.getHeader("user-agent") // 크롬인지 사파리인지 모바일인지

}