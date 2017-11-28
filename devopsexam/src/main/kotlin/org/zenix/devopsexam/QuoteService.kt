package org.zenix.devopsexam

import org.springframework.stereotype.Service
import java.util.*

@Service
class QuoteService {

    // http://www.junauza.com/2010/12/top-50-programming-quotes-of-all-time.html
    private val quotes = listOf("Talk is cheap. Show me the code. ― Linus Torvalds",
            "Walking on water and developing software from a specification are easy if both are frozen.- Edward V Berard",
            "I think Microsoft named .Net so it wouldn’t show up in a Unix directory listing. - Oktal",
            "I don't care if it works on your machine! We are not shipping your machine! - Vidiu Platon.")

    fun getRandomQuote(): String {
        val random = Random()
        val index = random.nextInt(quotes.size)
        return quotes[index]
    }

}