package com.marklogic.gradle.task.tasks

import org.gradle.api.tasks.TaskAction

import com.marklogic.appdeployer.command.Command
import com.marklogic.appdeployer.impl.SimpleAppDeployer
import com.marklogic.gradle.task.MarkLogicTask

class DeployTasksTask extends MarkLogicTask {

    @TaskAction
    void deployTasks() {
        List<Command> commands = getProject().property("mlTaskCommands")
        SimpleAppDeployer deployer = new SimpleAppDeployer(getManageClient(), getAdminManager())
        deployer.setCommands(commands)
        deployer.deploy(getAppConfig())
    }
}