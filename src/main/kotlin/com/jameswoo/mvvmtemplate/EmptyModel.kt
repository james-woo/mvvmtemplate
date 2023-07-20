package com.jameswoo.mvvmtemplate

import com.android.tools.idea.wizard.template.escapeKotlinIdentifier

fun emptyModel(
    packageName: String,
    screenName: String
) = """
package ${escapeKotlinIdentifier(packageName)}

class $screenName()

"""