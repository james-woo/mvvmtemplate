package com.jameswoo.mvvmtemplate

import com.android.tools.idea.wizard.template.escapeKotlinIdentifier

fun emptyViewAction(
    packageName: String,
    screenName: String
) = """
package ${escapeKotlinIdentifier(packageName)}

sealed class ${screenName}ViewAction {
    object OnBackPressed : ${screenName}ViewAction()
}

"""