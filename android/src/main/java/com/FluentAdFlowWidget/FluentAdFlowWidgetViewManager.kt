package com.FluentAdFlowWidget

import android.graphics.Color
import android.view.View
import android.util.Log
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp

class FluentAdFlowWidgetViewManager : SimpleViewManager<View>() {
  override fun getName() = "FluentAdFlowWidgetView"

  override fun createViewInstance(reactContext: ThemedReactContext): View {
    Log.d("FluentAdFlowWidgetView", "createViewInstance")
    return FluentAdFlowWidgetView(reactContext)
  }

  @ReactProp(name = "color")
  fun setColor(view: View, color: String) {
//    view.setBackgroundColor(Color.parseColor(color))
  }
}
