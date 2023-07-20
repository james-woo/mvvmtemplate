package com.jameswoo.mvvmtemplate

import com.android.tools.idea.wizard.template.escapeKotlinIdentifier

fun emptyModel(
        packageName: String,
        modelName: String
) = """
package ${escapeKotlinIdentifier(packageName)}

class $modelName()

"""