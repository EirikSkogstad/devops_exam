package org.zenix.devopsexam

import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class QuoteServiceTest {

    @Autowired
    lateinit var quoteService: QuoteService

    @Test
    fun getRandomQuotes() {
        var quote: String

        repeat(20, {
            quote = quoteService.getRandomQuote()
            assertNotNull(quote)
            assertFalse(quote.isNullOrBlank())
        })
    }

}