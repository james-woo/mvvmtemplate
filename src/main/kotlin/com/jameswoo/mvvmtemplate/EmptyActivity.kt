package com.jameswoo.mvvmtemplate

import com.android.tools.idea.wizard.template.escapeKotlinIdentifier

fun emptyActivity(
    packageName: String,
    screenName: String
) = """
package ${escapeKotlinIdentifier(packageName)}

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier

class ${screenName}Activity : ComponentActivity() {

    private val viewModel by viewModels<${screenName}ViewModel> {
        ${screenName}ViewModel.Factory(
            application = this.application,
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewState by viewModel.viewState.collectAsState()

            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background,
            ) {
                when (val currentViewState = viewState) {
                    is TestViewState.Data -> {
                        Text("Hello, Data!")
                    }
                    is TestViewState.Empty -> {
                        Text("Hello, World!")
                    }
                }
            }
        }
    }
}

"""