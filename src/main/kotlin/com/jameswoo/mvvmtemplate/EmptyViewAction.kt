package com.jameswoo.mvvmtemplate

import com.android.tools.idea.wizard.template.escapeKotlinIdentifier

fun emptyViewAction(
        packageName: String,
        modelName: String
) = """
package ${escapeKotlinIdentifier(packageName)}

sealed class ${modelName}ViewAction {
    object OnBackPressed : ${modelName}ViewAction()
}

"""