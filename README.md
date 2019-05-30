
# react-native-phone-caller

## Getting started

`$ npm install react-native-phone-caller --save`

### Mostly automatic installation

`$ react-native link react-native-phone-caller`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-phone-caller` and add `RNPhoneCaller.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNPhoneCaller.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNPhoneCallerPackage;` to the imports at the top of the file
  - Add `new RNPhoneCallerPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-phone-caller'
  	project(':react-native-phone-caller').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-phone-caller/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-phone-caller')
  	```

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNPhoneCaller.sln` in `node_modules/react-native-phone-caller/windows/RNPhoneCaller.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Phone.Caller.RNPhoneCaller;` to the usings at the top of the file
  - Add `new RNPhoneCallerPackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNPhoneCaller from 'react-native-phone-caller';

// TODO: What to do with the module?
RNPhoneCaller;
```
  