package com.sam.ncp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle


class InstallReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        val manager = context.packageManager

        if (intent.action == Intent.ACTION_PACKAGE_ADDED) {
            val installed = intent.data!!.schemeSpecificPart

            intent.setClass(context, InstalledAlert::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.putExtra("extra", installed)
            context.startActivity(intent)

        }

        if (intent.action == Intent.ACTION_PACKAGE_REMOVED) {
            val removed = intent.data!!.schemeSpecificPart


            intent.setClass(context, RemovedAlert::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.putExtra("extra", removed)
            context.startActivity(intent)


        }
        if (intent.action == Intent.ACTION_PACKAGE_REPLACED) {
            val replaced = intent.data!!.schemeSpecificPart


            intent.setClass(context, ReplacedAlert::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.putExtra("extra", replaced)
            context.startActivity(intent)


        }
    }
}


