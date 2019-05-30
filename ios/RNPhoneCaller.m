#import <UIKit/UIKit.h>
#import "RNPhoneCaller.h"

@implementation RNPhoneCaller

- (dispatch_queue_t)methodQueue
{
  return dispatch_get_main_queue();
}

RCT_EXPORT_MODULE()

RCT_EXPORT_METHOD(call:(NSString *)phoneNumber resolver:(RCTPromiseResolveBlock)resolve rejecter:(RCTPromiseRejectBlock)reject)
{
  UIApplication *application = [UIApplication sharedApplication];
  NSString *scheme = @"tel://";
  NSURL *URL = [NSURL URLWithString:scheme];

  if ([application canOpenURL:URL]) {
    NSString *phoneURL = [scheme stringByAppendingString:phoneNumber];
    if (@available(iOS 10, *)) {
      [application openURL:[NSURL URLWithString:phoneURL] options:@{} completionHandler:nil];
    } else {
      [application openURL:[NSURL URLWithString:phoneURL]];
    }
    resolve(@"Success");
  } else {
    reject(@"Error", @"Cannot open URL", nil);
  }
}

@end
