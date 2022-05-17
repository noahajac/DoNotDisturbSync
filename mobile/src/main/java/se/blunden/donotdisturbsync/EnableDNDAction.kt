package se.blunden.donotdisturbsync

import android.app.Activity
	import android.content.Context
	import android.os.Bundle
	import com.joaomgcd.taskerpluginlibrary.action.TaskerPluginRunnerActionNoOutputOrInput
	import com.joaomgcd.taskerpluginlibrary.config.TaskerPluginConfig
	import com.joaomgcd.taskerpluginlibrary.config.TaskerPluginConfigHelperNoOutputOrInput
	import com.joaomgcd.taskerpluginlibrary.config.TaskerPluginConfigNoInput
	import com.joaomgcd.taskerpluginlibrary.input.TaskerInput
	import com.joaomgcd.taskerpluginlibrary.runner.TaskerPluginResult
	import com.joaomgcd.taskerpluginlibrary.runner.TaskerPluginResultSucess

	class EnableDNDActionHelper(config: TaskerPluginConfig<Unit>) : TaskerPluginConfigHelperNoOutputOrInput<EnableDNDActionRunner>(config) {
	    override val runnerClass: Class<EnableDNDActionRunner> get() = EnableDNDActionRunner::class.java
	    override fun addToStringBlurb(input: TaskerInput<Unit>, blurbBuilder: StringBuilder) {
	        blurbBuilder.append("Enable DND on WearOS Device")
	    }
	}

	class ActivityConfigEnableDNDAction : Activity(), TaskerPluginConfigNoInput {
	    override val context: Context get() = applicationContext
	    private val taskerHelper by lazy { EnableDNDActionHelper(this) }
	    override fun onCreate(savedInstanceState: Bundle?) {
	        super.onCreate(savedInstanceState)
	        taskerHelper.finishForTasker()
	    }
	}

	class EnableDNDActionRunner : TaskerPluginRunnerActionNoOutputOrInput() {
	    override fun run(context: Context, input: TaskerInput<Unit>): TaskerPluginResult<Unit> {
	        WearMessageSender.sendDNDSyncMessage(context, 3)
	        return TaskerPluginResultSucess()
	    }
	}
