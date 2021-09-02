package com.narbase.kunafa.core.ssr.components

import com.narbase.kunafa.core.css.CssStyleSheetBuilder
import com.narbase.kunafa.core.css.Keyframes
import com.narbase.kunafa.core.css.RuleSet

class PageStyleSheetBuilder(override val page: Page) : CssStyleSheetBuilder(page) {

    override fun addRuleSetToDocument(ruleSet: RuleSet) {
        page.namedStyles
    }

    override fun addKeyframesToDocument(keyframes: Keyframes) {
    }

}