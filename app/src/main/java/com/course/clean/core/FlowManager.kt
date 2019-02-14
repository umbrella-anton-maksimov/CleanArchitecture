package com.course.clean.core

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.course.clean.R
import java.util.*
import kotlin.reflect.KClass

/**
 * Created by antonmaksimov on 2/13/19.
 * anton.maksimov@umbrella-web.com
 */

class FlowManager(
    private val fragmentManager: FragmentManager,
    private val containerId: Int = R.id.container
) {
    private val backStackTag = Stack<String>()

    val currentTag: String?
        get() = if (backStackTag.size < 1) null else backStackTag.peek()

    fun <T : Fragment> addFragment(fragmentClass: Class<T>, addToBackStack: Boolean = true) {
        val fragmentTransaction = fragmentManager.beginTransaction()
        val fragment = fragmentClass.newInstance()
        if (addToBackStack) fragmentTransaction.replace(containerId, fragment).addToBackStack(null)
        else fragmentTransaction.replace(containerId, fragment)
        fragmentTransaction.commit()
        backStackTag.push(fragment.javaClass.simpleName)
    }

    fun popBackStack() {
        if (backStackTag.size < 1) return
        backStackTag.pop()
        fragmentManager.popBackStack()
    }

    val size = backStackTag.size

    fun clearBackStack() = repeat((0 until fragmentManager.backStackEntryCount).count()) {
        fragmentManager.popBackStack()
    }

}