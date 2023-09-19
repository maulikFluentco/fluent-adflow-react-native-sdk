package com.FluentAdFlowWidget

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.widget.FrameLayout
import com.jetbrains.kmm.shared.SomeUIComponent
import com.jetbrains.kmm.shared.sdktest
import android.app.Activity
import android.view.View


class FluentAdFlowWidgetView(context: Context) : FrameLayout(context) {
  init {
    sdktest.init(context)
    launchWebView(user_email, user_fName, user_lName, user_orderId, user_txnAmt, user_zip)

//    val sampleTextComponent: View = testComponent.createComponent("test@test.com", "John", "Smith", "123abcdev456", "99.99", "11211")
//    this.addView(sampleTextComponent)
//    this.setBackgroundColor(Color.RED)
    Log.d("FluentAdFlowWidgetView", "Inside FluentAdFlowWidgetView Constructor")
  }
  companion object {
    fun setUserDetails(email:String, fName:String, lName:String, orderId:String, txnAmt:String, zip:String) {
      user_email = email;
      user_fName = fName;
      user_lName = lName;
      user_orderId = orderId;
      user_txnAmt = txnAmt;
      user_zip = zip;
    }
    var user_email:String = ""
    var user_fName:String = ""
    var user_lName:String = ""
    var user_orderId:String = ""
    var user_txnAmt:String = ""
    var user_zip:String = ""
  }
  public fun launchWebView(email:String, fName:String, lName:String, orderId:String, txnAmt:String, zip:String){
    val testComponent = SomeUIComponent()
    Log.d("launchWebView", "email: " + email)
    Log.d("launchWebView", "fName: " + fName)
    Log.d("launchWebView", "lName: " + lName)
    Log.d("launchWebView", "orderId: " + orderId)
    Log.d("launchWebView", "txnAmt: " + txnAmt)
    Log.d("launchWebView", "zip: " + zip)


    val sampleTextComponent: View = testComponent.createComponent(email, fName, lName, orderId, txnAmt, zip)
    this.addView(sampleTextComponent)
  }
}
