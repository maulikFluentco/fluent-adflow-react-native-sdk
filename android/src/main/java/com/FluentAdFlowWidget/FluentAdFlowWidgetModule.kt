package com.FluentAdFlowWidget
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.Promise
import android.util.Log
class FluentAdFlowWidgetModule(reactContext: ReactApplicationContext) :
  ReactContextBaseJavaModule(reactContext) {

  override fun getName(): String {
    return NAME
  }

  // Example method
  // See https://reactnative.dev/docs/native-modules-android
  @ReactMethod
  fun initSdk(email: String, fName: String,lName:String,orderId:String, txnAmt:String,zip:String,promise: Promise) {
    Log.d("email,,,",email)
    Log.d("fName,,,",fName)
    Log.d("lName,,,",lName)
    Log.d("orderId,,,",orderId)
    Log.d("txnAmt,,,",txnAmt)
    Log.d("zip,,,",zip)
    FluentAdFlowWidgetView.setUserDetails(email, fName, lName, orderId, txnAmt, zip)
    Log.d("FluentAdFlowWidgetView", "initSdk")
    promise.resolve(1)
  }

  companion object {
    const val NAME = "FluentAdFlowWidget"
  }
}
