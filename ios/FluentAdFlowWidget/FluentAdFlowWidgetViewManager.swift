//
//  FluentAdFlowWidgetViewManager.swift
//  FluentAdFlowWidget
//
//  Created by Daniel Larner on 9/19/23.
//

import FluentAdFlowWidget

@objc(FluentAdFlowWidgetViewManager)
class FluentAdFlowWidgetViewManager: RCTViewManager {

  override func view() -> (FluentAdFlowWidgetView) {
    return FluentAdFlowWidgetView()
  }

  @objc override static func requiresMainQueueSetup() -> Bool {
    return false
  }
}

class FluentAdFlowWidgetView : FluentAdFlowWidgetView  {
  required init(frame: CGRect){
    super.init(frame: frame)
    super.events.listenTo(eventName: "onHide", action: onHidden)
    super.events.listenTo(eventName: "onShow", action: onShow)
  }

  required init?(coder aDecoder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
  }

  override func didSetProps(_ changedProps: [String]!) {
    super.updateView(changedProps)
  }

  func onHidden(data: Any?) {
    print("-------- on Hidden -------------")
    AdFlowViewEventEmitter.emitter.sendEvent(withName: "onHide", body: ["hidden"])
  }

  func onShow(data: Any?) {
    print("-------- on Show -------------")
    AdFlowViewEventEmitter.emitter.sendEvent(withName: "onShow", body: ["show"])
  }
}


@objc(AdFlowViewEventEmitter)
open class AdFlowViewEventEmitter: RCTEventEmitter {

  public static var emitter: AdFlowViewEventEmitter!

  override init() {
    super.init()
      AdFlowViewEventEmitter.emitter = self
  }

  @objc
  override public func supportedEvents() -> [String] {
    ["onReady", "onPending", "onFailure", "onHide", "onShow"]
  }

  @objc override public static func requiresMainQueueSetup() -> Bool {
        return false
    }
}
