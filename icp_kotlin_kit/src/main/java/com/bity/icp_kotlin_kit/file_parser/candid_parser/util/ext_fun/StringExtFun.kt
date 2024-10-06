package com.bity.icp_kotlin_kit.file_parser.candid_parser.util.ext_fun

internal fun String.kotlinVariableName() = replaceFirstChar { it.lowercase() }

internal fun String.trimCommentLine() =
    this.removeRange(0..1)
        .replace("\\s+".toRegex(), " ")
        .trimStart()

internal fun String.toKotlinFileString(): String {
    val kotlinFile = StringBuilder()
    var indent = 0

    this.lines().forEach {

        val line = when {
            it.trim().startsWith("*") -> { it.trim() }
            else -> it.trim().replace("\\s+".toRegex(), " ")
        }

        when {
            indent == 0 -> { }
            line.startsWith(")") || line.startsWith("}") -> indent--
            else -> { }
        }

        val lineToAppend = when {
            line.startsWith("*") -> " $line"
            else -> line
        }
        kotlinFile.appendLine("""${"\t".repeat(indent)}$lineToAppend""")

        when {
            line.endsWith("(") || line.endsWith("{") -> indent++
        }
    }

    return kotlinFile.toString()
}