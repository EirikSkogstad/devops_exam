package org.zenix.devopsexam

import java.util.*

class RandomElementDispenser<out T>(private var elements: MutableList<T>) {

    private val elementsBackup: List<T>

    init {
        Collections.shuffle(elements)
        elementsBackup = elements.toList()
    }

    fun getNextElement(): T {
        if (elements.isEmpty()) {
            elements = elementsBackup.toMutableList()
        }

        return elements.removeAt(elements.size - 1)
    }
}