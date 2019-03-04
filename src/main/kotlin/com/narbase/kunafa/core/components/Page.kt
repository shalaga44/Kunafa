@file:Suppress("unused")

package com.narbase.kunafa.core.components

import com.narbase.kunafa.core.components.layout.Container
import kotlin.browser.document
import kotlin.dom.clear

/**
 * NARBASE TECHNOLOGIES CONFIDENTIAL
 * ______________________________
 * [2013] - [2018] Narbase Technologies
 * All Rights Reserved.
 * Created by islam
 * On: 9/30/17.
 */
object Page : Container(null) {

    override fun addChild(child: View) {
        document.body?.append(child.element)
        children.add(child)
    }

    override fun removeChild(child: View) {
        children.remove(child)
        document.body?.removeChild(child.element)
        child.parent = null
    }

    var title: String
        get() = document.title
        set(value) {
            document.title = value
        }

    fun prepare() {
        id = "page"

        document.body?.style?.margin = "0"
        document.body?.style?.padding = "0"
        document.body?.style?.overflowY = "hidden"
        document.body?.style?.overflowX = "hidden"
        document.body?.style?.width = "100vw"
        document.body?.style?.height = "100vh"

        document.body?.clear()
    }

    override fun addToParent() {
        /*
        Should be empty. Page cannot be added to parent
         */
    }

}
