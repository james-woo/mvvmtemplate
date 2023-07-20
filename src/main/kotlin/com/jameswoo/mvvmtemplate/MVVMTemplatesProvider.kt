package com.jameswoo.mvvmtemplate

import com.android.tools.idea.wizard.template.Template
import com.android.tools.idea.wizard.template.WizardTemplateProvider

class MVVMTemplatesProvider : WizardTemplateProvider() {
    override fun getTemplates(): List<Template> {
        return listOf(mvvmTemplate)
    }
}