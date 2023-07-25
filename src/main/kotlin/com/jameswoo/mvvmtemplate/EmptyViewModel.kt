package com.jameswoo.mvvmtemplate

import com.android.tools.idea.wizard.template.escapeKotlinIdentifier

fun emptyViewModel(
        packageName: String,
        modelName: String
) = """
package ${escapeKotlinIdentifier(packageName)}

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class ${modelName}ViewModel(
    application: Application,
): AndroidViewModel(application) {

    private val _viewState = MutableStateFlow<${modelName}ViewState>(${modelName}ViewState.Empty)
    val viewState: StateFlow<${modelName}ViewState> = _viewState
    
    fun handleViewAction(viewAction: ${modelName}ViewAction) {
        TODO()
    }
    
    private inline fun <reified T : ${modelName}ViewState> updateViewState(block: (T) -> T) {
        (_viewState.value as? T)?.let {
            _viewState.update {
                block(it as T)
            }
        }
    }
    
    class Factory(
        private val application: Application,
    ): ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return ${modelName}ViewModel(
                application = application,
            ) as T
        }
    }
}

"""