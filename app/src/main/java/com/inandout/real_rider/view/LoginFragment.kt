package com.inandout.real_rider.view

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.firestore.FirebaseFirestore
import com.inandout.real_rider.R
import com.inandout.real_rider.databinding.FragmentLoginBinding

import com.inandout.real_rider.base.BaseFragment
import com.inandout.real_rider.googleGMS.UserDTO
import com.inandout.real_rider.util.changeColorPartOfTextView

class LoginFragment : BaseFragment<FragmentLoginBinding>(R.layout.fragment_login) {
    var googleSignInClient : GoogleSignInClient? = null
    var GOOGLE_LOGIN_CODE = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(requireActivity(), gso)

        changeColorPartOfTextView(binding.tvRealRider, 0, 1, Color.parseColor("#F31414"))
        changeColorPartOfTextView(binding.tvRealRider, 5, 6, Color.parseColor("#668E5B"))
        initListener()
    }

    private fun initListener() {
        binding.tvStartBtn.setOnClickListener {
            var i = googleSignInClient?.signInIntent!!
            startActivityForResult(i, GOOGLE_LOGIN_CODE)
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == GOOGLE_LOGIN_CODE) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            val account = task.getResult(ApiException::class.java)
            val credential = GoogleAuthProvider.getCredential(account!!.idToken, null)

            FirebaseAuth.getInstance().signInWithCredential(credential)
                .addOnCompleteListener {
                        task ->
                    if(task.isSuccessful) {
                        println("login success")
                        println(task.result!!)
                        println(task.result!!.user)
                        saveUserDataToDataBase(task.result!!.user)
//                        findNavController().navigateSafe(R.id.action_loginFragment_to_mainFragment)
                    }
                }
        }
    }

    private fun saveUserDataToDataBase(user : FirebaseUser?) {
        var email = user?.email
        var uid = user?.uid

        val userDTO = UserDTO()
        userDTO.email = email

        FirebaseFirestore.getInstance().collection("users").document(uid!!).set(userDTO)
    }

}