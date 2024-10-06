package com.bity.icp_kotlin_kit.plugin.candid_parser.model.idl_type

import com.bity.icp_kotlin_kit.plugin.candid_parser.model.idl_comment.IDLComment
import guru.zoroark.tegral.niwen.parser.ParserNodeDeclaration
import guru.zoroark.tegral.niwen.parser.reflective

internal class IDLTypeBoolean(
    comment: IDLComment? = null,
    isOptional: Boolean = false,
    id: String? = null
) : IDLType(
    comment = comment,
    id = id,
    isOptional = isOptional
) {
    companion object : ParserNodeDeclaration<IDLTypeBoolean> by reflective()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        if (!super.equals(other)) return false
        return true
    }

    // Override to remove compiler warning
    override fun hashCode(): Int {
        return super.hashCode()
    }
}