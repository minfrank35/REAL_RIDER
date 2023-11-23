package com.inandout.real_rider.view

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.inandout.real_rider.R
import com.inandout.real_rider.base.BaseFragment
import com.inandout.real_rider.const.PERMISSION_BLUETOOTH_LOADING_ACTIVITY
import com.inandout.real_rider.databinding.FragmentIntroBinding
import com.inandout.real_rider.util.PermissionUtil

class IntroFragment : BaseFragment<FragmentIntroBinding>(R.layout.fragment_intro) {

    val REQUIRED_PERMISSIONS = arrayOf(Manifest.permission.BLUETOOTH_SCAN, Manifest.permission.BLUETOOTH_CONNECT)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {
            if (it[Manifest.permission.BLUETOOTH_SCAN] == true && it[Manifest.permission.BLUETOOTH_CONNECT] == true) {
                Toast.makeText(requireActivity(), "블루투스 권한이 허용", Toast.LENGTH_SHORT).show()
                init()
            }
        }.launch(REQUIRED_PERMISSIONS)

    }

    private fun init() {
        bluetoothThread.start()
        Handler().postDelayed({
            findNavControllerSafely()?.navigateSafe(R.id.action_introFragment_to_intro2Fragment)
        }, 2000) // 3초(3000밀리초) 지연
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_BLUETOOTH_LOADING_ACTIVITY) { //101
            if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(requireContext(), "블루투스 권한을 허용하였습니다.", Toast.LENGTH_SHORT).show()
                init()
            } else {
                Toast.makeText(requireContext(), "블루투스 권한을 거절하였습니다. 앱을 종료합니다.", Toast.LENGTH_SHORT).show()
                finishApp()
            }
        }
    }
}