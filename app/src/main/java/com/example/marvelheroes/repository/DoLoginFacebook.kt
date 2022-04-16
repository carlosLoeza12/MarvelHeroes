package com.example.marvelheroes.repository

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.marvelheroes.data.model.User
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.GraphRequest
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import org.json.JSONException
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class DoLoginFacebook @Inject constructor() {

    suspend fun getDataFacebook(callbackManager: CallbackManager, fragment: Fragment): Any =

        suspendCoroutine {
            LoginManager.getInstance()
                .logInWithReadPermissions(fragment, listOf("email", "public_profile"))

            LoginManager.getInstance().registerCallback(callbackManager,
                object : FacebookCallback<LoginResult> {

                    override fun onSuccess(result: LoginResult) {
                        //Graph API to access the data of user's facebook account
                        val id = result.accessToken.userId
                        val request = GraphRequest.newMeRequest(result.accessToken) { fbObject, response ->
                            try {
                                //Log.e("result", "onSuccess: fbObject $fbObject")
                                val firstName = fbObject?.getString("first_name")
                                val lastName = fbObject?.getString("last_name")
                                val email = fbObject?.getString("email")
                                val urlImg = "https://graph.facebook.com/$id/picture?return_ssl_resources=1"
                                it.resume(User(id, firstName, lastName, email, urlImg, "Facebook"))

                            } catch (e: JSONException) {
                                it.resume(e)
                            }
                        }
                        val parameters = Bundle()
                        parameters.putString("fields", "id, first_name, last_name, email")
                        request.parameters = parameters
                        //Execute this Graph request asynchronously
                        request.executeAsync()
                    }

                    override fun onCancel() {
                        it.resume("cancel")

                    }

                    override fun onError(error: FacebookException) {
                        it.resume(error)
                    }
                })
        }
}



