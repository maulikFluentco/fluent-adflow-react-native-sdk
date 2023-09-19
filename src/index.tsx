import {
  requireNativeComponent,
  UIManager,
  Platform,
  NativeModules,
  type ViewStyle,
} from 'react-native';

const LINKING_ERROR =
  `The package '@fluencto/fluent-adflow-react-native-sdk' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo Go\n';

type FluentAdFlowProps = {
  color: string;
  style: ViewStyle;
  email: string;
  firstName: string;
  lastName: string;
  orderId: string;
  transactionValue: string;
  zip: string;
};

const ComponentName = 'FluentAdFlowView';

export const FluentAdFlowView =
  UIManager.getViewManagerConfig(ComponentName) != null
    ? requireNativeComponent<FluentAdFlowProps>(ComponentName)
    : () => {
        throw new Error(LINKING_ERROR);
      };
const FluentAdFlowWidget = NativeModules.FluentAdFlowWidget
  ? NativeModules.FluentAdFlowWidget
  : new Proxy(
      {},
      {
        get() {},
      }
    );

export function initAdsSdk(
  email: string,
  fName: string,
  lName: string,
  orderId: string,
  txnAmt: string,
  zip: string
): Promise<number> {
  return FluentAdFlowWidget.initSdk(email, fName, lName, orderId, txnAmt, zip);
}
