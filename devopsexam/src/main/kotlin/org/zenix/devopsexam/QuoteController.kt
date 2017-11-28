package org.zenix.devopsexam

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@Validated
@RequestMapping(
        path = arrayOf("/quotes")
)
class QuoteController {

    @Autowired
    lateinit var quoteService: QuoteService

    @GetMapping
    fun get(): ResponseEntity<String> {
        return ResponseEntity.ok(quoteService.getRandomQuote())
    }
}