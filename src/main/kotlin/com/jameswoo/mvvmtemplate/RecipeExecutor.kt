package com.jameswoo.mvvmtemplate

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.PackageName
import com.android.tools.idea.wizard.template.RecipeExecutor

fun RecipeExecutor.mvvmRecipe(
    moduleData: ModuleTemplateData,
    packageName: PackageName,
    screenName: String,
) {
    val emptyActivity = emptyActivity(packageName, screenName)
    val emptyActivityPath = moduleData.srcDir.resolve("${screenName}Activity.kt")
    save(emptyActivity, emptyActivityPath)

    val emptyViewModel = emptyViewModel(packageName, screenName)
    val emptyViewModelPath = moduleData.srcDir.resolve("${screenName}ViewModel.kt")
    save(emptyViewModel, emptyViewModelPath)

    val emptyViewState = emptyViewState(packageName, screenName)
    val emptyViewStatePath = moduleData.srcDir.resolve("${screenName}ViewState.kt")
    save(emptyViewState, emptyViewStatePath)

    val emptyViewAction = emptyViewAction(packageName, screenName)
    val emptyViewActionPath = moduleData.srcDir.resolve("${screenName}ViewAction.kt")
    save(emptyViewAction, emptyViewActionPath)

    open(emptyActivityPath)
}