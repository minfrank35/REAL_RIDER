package com.inandout.real_rider.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController


abstract class BaseFragment<T : ViewDataBinding>(@LayoutRes private val layoutResId: Int) : Fragment() {
    lateinit var binding : T
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    )  : View? {
        binding = DataBindingUtil.inflate(inflater, layoutResId, container, false)

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
}