//
//  FluentAdFlowWidgetViewManager.m
//  FluentAdFlowWidget
//
//  Created by Daniel Larner on 9/19/23.
//

#import <React/RCTViewManager.h>
#import <React/RCTEventEmitter.h>

@interface RCT_EXTERN_MODULE(FluentAdFlowViewManager, RCTViewManager)
    RCT_EXPORT_VIEW_PROPERTY(email, NSString)
    RCT_EXPORT_VIEW_PROPERTY(firstName, NSString)
    RCT_EXPORT_VIEW_PROPERTY(lastName, NSString)
    RCT_EXPORT_VIEW_PROPERTY(orderId, NSString)
    RCT_EXPORT_VIEW_PROPERTY(transactionValue, NSString)
    RCT_EXPORT_VIEW_PROPERTY(zip, NSString)
@end

@interface RCT_EXTERN_MODULE(AdsViewEventEmitter, RCTEventEmitter)
    RCT_EXTERN_METHOD(supportedEvents)
    RCT_EXTERN_METHOD(requiresMainQueueSetup)
@end
