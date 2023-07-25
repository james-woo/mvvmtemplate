package com.jameswoo.mvvmtemplate

import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.defaultPackageNameParameter
import java.io.File

val mvvmTemplate
    get() = template {
        name = "MVVM Template"
        description = "MVVM Template"
        minApi = 21

        // Conditions under which the template should be rendered in the new project wizard
        constraints = listOf(
            TemplateConstraint.AndroidX,
            TemplateConstraint.Kotlin
        )

        // Determines which menu entry the template belongs to, e.g. Application, Activity, Compose, Service, etc.
        category = Category.Activity

        // Determines which form factor the template belongs to, e.g. phone, tablets, wear os, etc.
        formFactor = FormFactor.Mobile

        // UI context in which the template should be displayed.
        screens = listOf(WizardUiContext.ActivityGallery)

        val modelName = stringParameter {
            name = "Model name"
            default = "Main"
        }

        val packageName = defaultPackageNameParameter

        // Collection of widgets to render in NewProjectExtraDetail
        widgets(
            TextFieldWidget(modelName),
            PackageNameWidget(packageName)
        )

        // Thumbnail for the template
        thumb { File("compose-activity-material3").resolve("template_compose_empty_activity_material3.png") }

        // The recipe used to generate the template output
        recipe = { data: TemplateData ->
            mvvmRecipe(
                moduleData = data as ModuleTemplateData,
                packageName = packageName.value,
                modelName = modelName.value,
            )
        }
    }
