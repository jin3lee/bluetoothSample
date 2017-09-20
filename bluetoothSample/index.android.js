/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  View
} from 'react-native';

import { NativeModules } from 'react-native';

export default class bluetoothSample extends Component {
  render() {
       {NativeModules.BluetoothModule.printTest()}

       var isBluetoothConnected = "";
        {NativeModules.BluetoothModule.connect()}
        {
            NativeModules.BluetoothModule.isConnected
            (
                (error) =>
                {
                    console.log("<Text>false</Text>");
                    isBluetoothConnected = "false";
                },
                (success) =>
                {
                    console.log("<Text>true</Text>");
                    isBluetoothConnected = "true";
                    console.log("bluetoooooth: " + isBluetoothConnected);
                },
            )
        }
    return (
      <View style={styles.container}>
        <Text style={styles.welcome}>
          Bluetooth Connection Available: {isBluetoothConnected}

        </Text>
        <Text style={styles.instructions}>
          To get started, edit index.android.js
        </Text>
        <Text style={styles.instructions}>
          Double tap R on your keyboard to reload,{'\n'}
          Shake or press menu button for dev menu
        </Text>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
});

AppRegistry.registerComponent('bluetoothSample', () => bluetoothSample);
