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

	class DisableDNDActionHelper(config: TaskerPluginConfig<Unit>) : TaskerPluginConfigHelperNoOutputOrInput<DisableDNDActionRunner>(config) {
	    override val runnerClass: Class<DisableDNDActionRunner> get() = DisableDNDActionRunner::class.java
	    override fun addToStringBlurb(input: TaskerInput<Unit>, blurbBuilder: StringBuilder) {
	        blurbBuilder.append("Enable DND on WearOS Device")
	    }
	}

	class ActivityConfigDisableDNDAction : Activity(), TaskerPluginConfigNoInput {
	    override val context: Context get() = applicationContext
	    private val taskerHelper by lazy { DisableDNDActionHelper(this) }
	    override fun onCreate(savedInstanceState: Bundle?) {
	        super.onCreate(savedInstanceState)
	        taskerHelper.finishForTasker()
	    }
	}

	class DisableDNDActionRunner : TaskerPluginRunnerActionNoOutputOrInput() {
	    override fun run(context: Context, input: TaskerInput<Unit>): TaskerPluginResult<Unit> {
	        WearMessageSender.sendDNDSyncMessage(context, 1)
	        return TaskerPluginResultSucess()
	    }
	}
