package com.jameswoo.mvvmtemplate

import com.android.tools.idea.wizard.template.escapeKotlinIdentifier

fun emptyViewState(
        packageName: String,
        modelName: String
) = """
package ${escapeKotlinIdentifier(packageName)}

sealed class ${modelName}ViewState {
    object Empty : ${modelName}ViewState()
    data class Data(val data: String) : ${modelName}ViewState()
}

"""