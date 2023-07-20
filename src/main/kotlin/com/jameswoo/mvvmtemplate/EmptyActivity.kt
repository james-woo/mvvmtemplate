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

class ${screenName}Activity : ComponentActivity() {

    private val viewModel by viewModels<${screenName}ViewModel> {
        ${screenName}ViewModel.Factory(
            application = this.application,
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background,
            ) {
                Text("Hello, World!")
            }
        }
    }
}

"""