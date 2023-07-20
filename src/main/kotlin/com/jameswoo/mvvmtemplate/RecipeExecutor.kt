package com.jameswoo.mvvmtemplate

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.PackageName
import com.android.tools.idea.wizard.template.RecipeExecutor

fun RecipeExecutor.mvvmRecipe(
        moduleData: ModuleTemplateData,
        packageName: PackageName,
        modelName: String,
) {
    val emptyActivity = emptyActivity(packageName, modelName)
    val emptyActivityPath = moduleData.srcDir.resolve("${modelName}Activity.kt")
    save(emptyActivity, emptyActivityPath)

    val emptyViewModel = emptyViewModel(packageName, modelName)
    val emptyViewModelPath = moduleData.srcDir.resolve("${modelName}ViewModel.kt")
    save(emptyViewModel, emptyViewModelPath)

    val emptyModel = emptyModel(packageName, modelName)
    val emptyModelPath = moduleData.srcDir.resolve("${modelName}.kt")
    save(emptyModel, emptyModelPath)

    val emptyViewState = emptyViewState(packageName, modelName)
    val emptyViewStatePath = moduleData.srcDir.resolve("${modelName}ViewState.kt")
    save(emptyViewState, emptyViewStatePath)

    val emptyViewAction = emptyViewAction(packageName, modelName)
    val emptyViewActionPath = moduleData.srcDir.resolve("${modelName}ViewAction.kt")
    save(emptyViewAction, emptyViewActionPath)

    open(emptyActivityPath)
}