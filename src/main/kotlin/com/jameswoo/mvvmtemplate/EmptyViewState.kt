package com.jameswoo.mvvmtemplate

import com.android.tools.idea.wizard.template.escapeKotlinIdentifier

fun emptyViewState(
    packageName: String,
    screenName: String
) = """
package ${escapeKotlinIdentifier(packageName)}

sealed class ${screenName}ViewState {
    object Empty : ${screenName}ViewState()
    data class Data(val data: String) : ${screenName}ViewState()
}

"""