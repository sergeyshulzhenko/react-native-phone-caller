
# react-native-phone-caller
[![npm version](https://badge.fury.io/js/react-native-phone-caller.svg)](https://badge.fury.io/js/react-native-phone-caller)

React Native phone calls for iOS and Android

### Getting started

`$ npm install --save react-native-phone-caller`
or
`$ yarn add react-native-phone-caller`

### Mostly automatic installation

`$ react-native link react-native-phone-caller`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-phone-caller` and add `RNPhoneCaller.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNPhoneCaller.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainApplication.java`
  - Add `import com.PhoneCaller.RNPhoneCallerPackage;` to the imports at the top of the file ``
  - Add `new RNPhoneCallerPackage()` to the list returned by the `getPackages()` method
  ```java
  import com.PhoneCaller.RNPhoneCallerPackage; // <--- 1

  public class MainApplication extends Application implements ReactApplication {

  private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
      @Override
      protected boolean getUseDeveloperSupport() {
        return BuildConfig.DEBUG;
      }

      @Override
      protected List<ReactPackage> getPackages() {

      return Arrays.<ReactPackage>asList(
          new MainReactPackage(),
          new RNPhoneCallerPackage() // <--- 2
      );
    }
  };

  ....
  ```
2. Append the following lines to `android/settings.gradle`:
  ```
  include ':react-native-phone-caller'
  project(':react-native-phone-caller').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-phone-caller/android')
  ```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  ```
implementation project(':react-native-phone-caller')
  ```

### Usage
```javascript
PhoneCaller.call(tel)
```
Arguments:
 - tel: String - a phone number to call

Returns: **Promise**
 - fulfilled: String - `Success`
 - rejected: Error

```javascript
import PhoneCaller from 'react-native-phone-caller';

PhoneCaller.call('+98887776655');
```

## Permissions ##
(Android only) [PermissionsAndroid](https://facebook.github.io/react-native/docs/permissionsandroid)

Request the **CALL_PHONE** permission beforehand

```javascript
try {
    const granted = await PermissionsAndroid.request(
      PermissionsAndroid.PERMISSIONS.CALL_PHONE,
      {
        ...
      },
    );
    if (granted === PermissionsAndroid.RESULTS.GRANTED) {
      await PhoneCaller.call('+98887776655');
      ...
    } else {
      Alert.alert('Error', 'Camera permission denied');
    }
  } catch (err) {
    console.warn(err);
  }
```
