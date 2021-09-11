package com.narbase.kunafa.core.components

import com.narbase.kunafa.core.css.*
import com.narbase.kunafa.core.dimensions.px

class Page : PageInterface, View() {

    override var id: String? = null

    override var useRtl: Boolean = false
    // todo: setter should make body rtl

    override var ref: String? = null

    override val styleSheetBuilder = PageStyleSheetBuilder(this)
    override val classNameGenerator = ClassNameGenerator()
    val namedStyles = mutableMapOf<String, RuleSet>()
    val keyframes = mutableListOf<Keyframes>()

    fun prepare() {
        page = this
    }

    override fun build(): String {
        val childrenStringBuilder = buildString { children.forEach { append(it.build()) } }

        val builder = StringBuilder()
        builder.apply {
            append("<!DOCTYPE html>")
            append("""<html lang="en">""")
            append(getHead())
            append("<body ${getMetaData()}>")

            append(childrenStringBuilder)

            append("</body>")
            append("</html>")
        }
        return builder.toString()
    }

    private fun getHead() = buildString {
        append("<head>")
        append("""<meta charset="UTF-8">""")
        append("""<meta content="width=device-width, initial-scale=1" name="viewport">""")
        append(getStyles())
        append("</head>")
    }

    private fun getMetaData() = buildString {
        appendLine("data-class-name-generator-counter=${classNameGenerator.counter++}")
        appendLine("data-use-rtl=${useRtl}")
        ref?.let { appendLine("data-kssr-page-ref=$it") }
    }

    private fun getStyles() = buildString {
        append("<style>")
        namedStyles.map {
            append(it.value.toString())
        }
        keyframes.map {
            append(it.toString())
        }
        append("</style>")
    }


    override val linearLayoutClass = classRuleSet {
        alignItems = Alignment.Start
        display = "inline-flex"
    }
    override val verticalLayoutClass = classRuleSet {
        flexDirection = "column"
    }
    override val horizontalLayoutClass = classRuleSet {
        flexDirection = "row"
    }


    val baseClass = classRuleSet {
        boxSizing = "border-box"
        margin = 0.px
        padding = 0.px
        flexShrink = "0"
    }

    val invisibleClass = classRuleSet {
        display = "none !important"
    }

    val verticalScrollLayoutClass = classRuleSet {
        isScrollableVertically = true
        isScrollableHorizontally = false
    }
    val horizontalScrollLayoutClass = classRuleSet {
        isScrollableHorizontally = true
        isScrollableVertically = false
    }

}