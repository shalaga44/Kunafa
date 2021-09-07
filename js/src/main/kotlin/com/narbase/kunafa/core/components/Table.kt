@file:Suppress("unused")

package com.narbase.kunafa.core.components


import kotlinx.browser.document
import org.w3c.dom.HTMLTableCellElement
import org.w3c.dom.HTMLTableElement
import org.w3c.dom.HTMLTableRowElement
import org.w3c.dom.HTMLTableSectionElement


/*
 * Copyright 2017-2020 Narbase technologies and contributors. Use of this source code is governed by the MIT License.
 */
class Table(parent: View? = null, override val element: HTMLTableElement = (document.createElement("table") as HTMLTableElement)) : View(parent)

class TableRow(parent: View? = null, override val element: HTMLTableRowElement = (document.createElement("tr") as HTMLTableRowElement)) : View(parent)

class TableCell(parent: View? = null, override val element: HTMLTableCellElement = (document.createElement("td") as HTMLTableCellElement)) : View(parent) {
    var text
        get() = element.innerHTML
        set(value) {
            element.innerHTML = value
        }
}

class TableHeaderCell(parent: View? = null, override val element: HTMLTableCellElement = (document.createElement("th") as HTMLTableCellElement)) : View(parent) {
    var text
        get() = element.innerHTML
        set(value) {
            element.innerHTML = value
        }
}

class TableHeader(parent: View? = null, override val element: HTMLTableSectionElement = (document.createElement("thead") as HTMLTableSectionElement)) : View(parent)

class TableFooter(parent: View? = null, override val element: HTMLTableSectionElement = (document.createElement("tfoot") as HTMLTableSectionElement)) : View(parent)

class TableBody(parent: View? = null, override val element: HTMLTableSectionElement = (document.createElement("tbody") as HTMLTableSectionElement)) : View(parent)
