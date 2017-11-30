package org.zenix.devopsexam

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@Validated
@RequestMapping(
        path = arrayOf("/container-info")
)
class ContainerInfoController {

    @Autowired
    private lateinit var env: Environment

    @GetMapping
    fun get(): ResponseEntity<String> {
        return ResponseEntity.ok(env.getProperty("HOSTNAME"))
    }
}