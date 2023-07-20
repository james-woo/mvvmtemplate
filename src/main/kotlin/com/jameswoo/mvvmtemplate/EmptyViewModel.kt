package com.jameswoo.mvvmtemplate

import com.android.tools.idea.wizard.template.escapeKotlinIdentifier

fun emptyViewModel(
    packageName: String,
    screenName: String
) = """
package ${escapeKotlinIdentifier(packageName)}

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ${screenName}ViewModel(
    application: Application,
): AndroidViewModel(application) {
    
    class Factory(
        private val application: Application,
    ): ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MainViewModel(
                application = application,
            ) as T
        }
    }
}
"""