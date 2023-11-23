package com.inandout.real_rider.util;

import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.media.MediaPlayer;

import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;


// BluetoothThread.java
public class BluetoothThread extends Thread {
    private static final UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    private static final String TAG = "BluetoothThread";
    private String address = "98:DA:50:01:CE:BF"; // 아두이노 블루투스 모듈의 맥어드레스
    public static Context context;
    private BluetoothAdapter bluetoothAdapter;
    private InputStream inputStream;
    private BluetoothSocket bluetoothSocket;
    private OutputStream outputStream;
    private static BluetoothThread instance;

    private MediaPlayer mediaPlayer;
    private String water;
    private int currentIndex = 2; // 현재 이미지 인덱스

    private OnNextCallBack onNextCallBack;

    private Dialog dialog;

    boolean isWinnerReceive = false;
    private BluetoothThread(Context context) {
        this.context = context;
        BluetoothManager bluetoothManager = (BluetoothManager) this.context.getSystemService(Context.BLUETOOTH_SERVICE);
        bluetoothAdapter = bluetoothManager.getAdapter();
        if (bluetoothAdapter == null) {
            // Bluetooth를 지원하지 않는 기기에 대한 처리
        }
    }

    public static synchronized BluetoothThread getInstance(Context context) {
        if (instance == null) {
            instance = new BluetoothThread(context);
        } else {
            changeContext(context);
        }
        return instance;
    }

    @Override
    public void run() {
        if (bluetoothAdapter == null) {
            return;
        }

        if (!bluetoothAdapter.isEnabled()) {
            return;
        }

        BluetoothDevice device = bluetoothAdapter.getRemoteDevice(address);

        try {
            bluetoothSocket = device.createRfcommSocketToServiceRecord(MY_UUID);
            bluetoothAdapter.cancelDiscovery();

            try {
                bluetoothSocket.connect();
                outputStream = bluetoothSocket.getOutputStream();
                inputStream = bluetoothSocket.getInputStream();

                // inputStream 초기화 추가PermissionUtil
            } catch (IOException e) {
                try {
                    bluetoothSocket.close();
                } catch (IOException e2) {
                    Log.e(TAG, "Error closing Bluetooth socket: " + e2.getMessage());
                    Toast.makeText(context, "블루투스 연결실패 재시동해주세요", Toast.LENGTH_SHORT).show();
                }
                return;
            }
            // outputStream = bluetoothSocket.getOutputStream(); 이 코드는 inputStream 초기화 이후로 이동해야 합니다.
        } catch (IOException e) {
            Log.e(TAG, "Error creating Bluetooth socket: " + e.getMessage());
            return;
        } catch (SecurityException e) {
            Log.e(TAG, "Error creating Bluetooth socket: " + e.getMessage());
            return;
        }
        receiveData();
    }

    public static void changeContext(Context context) {
        BluetoothThread.context = context;
    }

    public void sendData(String message1, String message2, String message3) {
        if (outputStream != null) {
            try {
                String message = message1 + "," + message2 + "," + message3;
                byte[] messageBytes = message.getBytes();
                System.out.print(messageBytes);
                outputStream.write(messageBytes);
                Log.d(TAG, "Sent data: " + message);
            } catch (IOException e) {
                Log.e(TAG, "Error sending data: " + e.getMessage());
            }
        }
    }
    public void sendData(String message1) {
        if (outputStream != null) {
            try {
                String message = message1;
                byte[] messageBytes = message.getBytes();
                outputStream.write(messageBytes);
                Log.d(TAG, "Sent data: " + message);
            } catch (IOException e) {
                Log.e(TAG, "Error sending data: " + e.getMessage());
            }
        }
    }
    public void sendData3(String message1, String message2, String message3, String message4) {
        if (outputStream != null) {
            try {
                String message = message1 + "," + message2 + "," + message3+ "," + message4;
                byte[] messageBytes = message.getBytes();
                outputStream.write(messageBytes);
                Log.d(TAG, "Sent data: " + message);
            } catch (IOException e) {
                Log.e(TAG, "Error sending data: " + e.getMessage());
            }
        }
    }
    public void receiveData() {

        byte[] buffer = new byte[1024];
        int bytes;

        while (true) {
            try {
                bytes = inputStream.read(buffer);
                String receivedMessage = new String(buffer, 0, bytes);
                Log.d(TAG, "Received data: " + receivedMessage);
                // Process received data as needed
                if (receivedMessage.trim().equals("Winner!!")) { // TODO ::
                }
            } catch (IOException e) {
                Log.e(TAG, "Error receiving data: " + e.getMessage());
                break;
            }
        }
    }

    public void disconnect() {
        if (outputStream != null) {
            try {
                outputStream.flush();
            } catch (IOException e) {
                Log.e(TAG, "Error flushing output stream: " + e.getMessage());
            }
        }

        try {
            bluetoothSocket.close();
        } catch (IOException e) {
            Log.e(TAG, "Error closing Bluetooth socket: " + e.getMessage());
        }
    }

    public interface OnNextCallBack {
        public void onNextButton();
    }
}
