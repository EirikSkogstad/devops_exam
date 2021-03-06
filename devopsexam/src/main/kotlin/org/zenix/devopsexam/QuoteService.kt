package org.zenix.devopsexam

import org.springframework.stereotype.Service

@Service
class QuoteService {

    private val quoteDispenser = createRandomQuoteDispenser()

    fun getRandomQuote(): String {
        return quoteDispenser.getNextElement()
    }

    private final fun createRandomQuoteDispenser(): RandomElementDispenser<String> {
        // http://www.junauza.com/2010/12/top-50-programming-quotes-of-all-time.html
        return RandomElementDispenser(
                mutableListOf(
                        "In My Egotistical Opinion, most people's C programs should be indented six feet downward and covered with dirt. - Blair P. Houghton",
                        "Measuring programming progress by lines of code is like measuring aircraft building progress by weight - Bill Gates",
                        "Talk is cheap. Show me the code. ― Linus Torvalds",
                        "Walking on water and developing software from a specification are easy if both are frozen.- Edward V Berard",
                        "I think Microsoft named .Net so it wouldn’t show up in a Unix directory listing. - Oktal",
                        "I don't care if it works on your machine! We are not shipping your machine! - Vidiu Platon."
                )
        )
    }
}

