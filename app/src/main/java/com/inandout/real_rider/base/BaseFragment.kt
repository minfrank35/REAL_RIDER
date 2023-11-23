package com.inandout.real_rider.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import androidx.navigation.fragment.findNavController
import com.inandout.real_rider.util.BluetoothThread


abstract class BaseFragment<T : ViewDataBinding>(@LayoutRes private val layoutResId: Int) : Fragment() {
    lateinit var binding : T
    lateinit var bluetoothThread : BluetoothThread
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    )  : View? {
        binding = DataBindingUtil.inflate(inflater, layoutResId, container, false)
        bluetoothThread = BluetoothThread.getInstance(requireContext())
        return binding.root
    }

    fun setOnBackPressed(callback : () -> Unit) {
        val onBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                callback()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(onBackPressedCallback)
    }

    fun Fragment.findNavControllerSafely(): NavController? {
        return if (isAdded) {
            findNavController() //The problem is caused when you try to call findNavController() on a fragment that has been detached,
        } else {
            null
        }
    }

    fun NavController.navigateSafe(
        @IdRes resId: Int,
        args: Bundle? = null,
        navOptions: NavOptions? = null,
        navExtras: Navigator.Extras? = null
    ) {
        val action = currentDestination?.getAction(resId) ?: graph.getAction(resId)
        // 현재 fragment의 id와 이동할 fragment의 id가 다르면 화면이동 실행 (같다는 건, 이미 이동이 된 후이기 때문)
        if (action != null && currentDestination?.id != action.destinationId) {
            navigate(resId, args, navOptions, navExtras)
        }
    }

    protected open fun finishApp() {
        requireActivity().finishAffinity()
        System.runFinalization()
        System.exit(0)
    }
}