package com.ajscanlan.myapplication;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {
    private final char DASH = '_';
    private final char DOT = '.';
    private final char BLANK = ' ';
    private final int WAIT = 75;
    private Camera cam;
    HashMap<Character, Object> charMap = new HashMap<>();
    private char[] charMessage = null;
    private char[] charDecode = null;
    private MediaPlayer mediaPlayer = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initMap();
    }

    private void initMap() {
        charMap.put('A', new char[]{DOT, DASH});
        charMap.put('B', new char[]{DASH, DOT, DOT, DOT});
        charMap.put('C', new char[]{DASH, DOT, DASH, DOT});
        charMap.put('D', new char[]{DASH, DOT, DOT});
        charMap.put('E', new char[]{DOT});
        charMap.put('F', new char[]{DOT, DOT, DASH, DOT});
        charMap.put('G', new char[]{DASH, DASH, DOT});
        charMap.put('H', new char[]{DOT, DOT, DOT, DOT});
        charMap.put('I', new char[]{DOT, DOT});
        charMap.put('J', new char[]{DOT, DASH, DASH, DASH});
        charMap.put('K', new char[]{DASH, DOT, DASH});
        charMap.put('L', new char[]{DOT, DASH, DOT, DOT});
        charMap.put('M', new char[]{DASH, DASH});
        charMap.put('N', new char[]{DASH, DOT});
        charMap.put('O', new char[]{DASH, DASH, DASH});
        charMap.put('P', new char[]{DOT, DASH, DASH, DOT});
        charMap.put('Q', new char[]{DASH, DASH, DOT, DASH});
        charMap.put('R', new char[]{DOT, DASH, DOT});
        charMap.put('S', new char[]{DOT, DOT, DOT});
        charMap.put('T', new char[]{DASH});
        charMap.put('U', new char[]{DOT, DOT, DASH});
        charMap.put('V', new char[]{DOT, DOT, DOT, DASH});
        charMap.put('W', new char[]{DOT, DASH, DASH});
        charMap.put('X', new char[]{DASH, DOT, DOT, DASH});
        charMap.put('Y', new char[]{DASH, DOT, DASH, DASH});
        charMap.put('Z', new char[]{DASH, DASH, DOT, DOT});
        //charMap.put(' ', new char[]{BLANK, BLANK, BLANK});
        charMap.put('_', new char[]{BLANK});

        //INIT NUMBERS
        charMap.put('1', new char[]{DOT, DASH, DASH, DASH, DASH});
        charMap.put('2', new char[]{DOT, DOT, DASH, DASH, DASH});
        charMap.put('3', new char[]{DOT, DOT, DOT, DASH, DASH});
        charMap.put('4', new char[]{DOT, DOT, DOT, DOT, DASH});
        charMap.put('5', new char[]{DOT, DOT, DOT, DOT, DOT});
        charMap.put('6', new char[]{DASH, DOT, DOT, DOT, DOT});
        charMap.put('7', new char[]{DASH, DASH, DOT, DOT, DOT});
        charMap.put('8', new char[]{DASH, DASH, DASH, DOT, DOT});
        charMap.put('9', new char[]{DASH, DASH, DASH, DASH, DOT});
        charMap.put('0', new char[]{DASH, DASH, DASH, DASH, DASH});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void ledOn(View view) {
        EditText etMessage = (EditText) findViewById(R.id.editText);
        charMessage = etMessage.getText().toString().toLowerCase().toCharArray();

        encodeText();

        new AsyncCallerEncode().execute();
    }

    private void encodeText() {
        String message = "";

        for (int i = 0; i < charMessage.length; ++i) {
            switch (charMessage[i]) {
                case 'a':
                    message += new String((char[]) charMap.get('A')) + " ";
                    break;
                case 'b':
                    message += new String((char[]) charMap.get('B')) + " ";
                    break;
                case 'c':
                    message += new String((char[]) charMap.get('C')) + " ";
                    break;
                case 'd':
                    message += new String((char[]) charMap.get('D')) + " ";
                    break;
                case 'e':
                    message += new String((char[]) charMap.get('E')) + " ";
                    break;
                case 'f':
                    message += new String((char[]) charMap.get('F')) + " ";
                    break;
                case 'g':
                    message += new String((char[]) charMap.get('G')) + " ";
                    break;
                case 'h':
                    message += new String((char[]) charMap.get('H')) + " ";
                    break;
                case 'i':
                    message += new String((char[]) charMap.get('I')) + " ";
                    break;
                case 'j':
                    message += new String((char[]) charMap.get('J')) + " ";
                    break;
                case 'k':
                    message += new String((char[]) charMap.get('K')) + " ";
                    break;
                case 'l':
                    message += new String((char[]) charMap.get('L')) + " ";
                    break;
                case 'm':
                    message += new String((char[]) charMap.get('M')) + " ";
                    break;
                case 'n':
                    message += new String((char[]) charMap.get('N')) + " ";
                    break;
                case 'o':
                    message += new String((char[]) charMap.get('O')) + " ";
                    break;
                case 'p':
                    message += new String((char[]) charMap.get('P')) + " ";
                    break;
                case 'q':
                    message += new String((char[]) charMap.get('Q')) + " ";
                    break;
                case 'r':
                    message += new String((char[]) charMap.get('R')) + " ";
                    break;
                case 's':
                    message += new String((char[]) charMap.get('S')) + " ";
                    break;
                case 't':
                    message += new String((char[]) charMap.get('T')) + " ";
                    break;
                case 'u':
                    message += new String((char[]) charMap.get('U')) + " ";
                    break;
                case 'v':
                    message += new String((char[]) charMap.get('V')) + " ";
                    break;
                case 'w':
                    message += new String((char[]) charMap.get('W')) + " ";
                    break;
                case 'x':
                    message += new String((char[]) charMap.get('X')) + " ";
                    break;
                case 'y':
                    message += new String((char[]) charMap.get('Y')) + " ";
                    break;
                case 'z':
                    message += new String((char[]) charMap.get('Z')) + " ";
                    break;
                case ' ':
                    message += "    ";
                    break;
            }
        }

        EditText et_encode = (EditText) findViewById(R.id.editText2);
        et_encode.setText(message);
    }

    public void encode(Object o) {
        char[] chArr = (char[]) o;

        for (int i = 0; i < chArr.length; ++i) {
            showCode(chArr[i]);

            try {
                Thread.sleep(WAIT);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void showCode(char c) {
        if (c == DOT) {
            cam = Camera.open();
            Camera.Parameters params = cam.getParameters();
            params.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
            cam.setParameters(params);
            cam.startPreview();

            try {
                Thread.sleep(WAIT);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            cam.stopPreview();
            cam.release();
        } else if (c == DASH) {
            cam = Camera.open();
            Camera.Parameters params = cam.getParameters();
            params.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
            cam.setParameters(params);
            cam.startPreview();

            try {
                Thread.sleep(WAIT * 7);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            cam.stopPreview();
            cam.release();
        } else if (c == BLANK) {
//            cam = Camera.open();
//            Camera.Parameters params = cam.getParameters();
//            params.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
//            cam.setParameters(params);
//            cam.startPreview();

            try {
                Thread.sleep(WAIT * 25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

//            cam.stopPreview();
//            cam.release();
        }

    }

    private class AsyncCallerEncode extends AsyncTask<Void, Void, Void> {
        ProgressDialog pdLoading = new ProgressDialog(MainActivity.this);

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            //this method will be running on UI thread
//            pdLoading.setMessage("\tLoading...");
//            pdLoading.show();
        }

        @Override
        protected Void doInBackground(Void... params) {

            for (int i = 0; i < charMessage.length; ++i) {
                switch (charMessage[i]) {
                    case 'a':
                        encode(charMap.get('A'));
                        break;
                    case 'b':
                        encode(charMap.get('B'));
                        break;
                    case 'c':
                        encode(charMap.get('C'));
                        break;
                    case 'd':
                        encode(charMap.get('D'));
                        break;
                    case 'e':
                        encode(charMap.get('E'));
                        break;
                    case 'f':
                        encode(charMap.get('F'));
                        break;
                    case 'g':
                        encode(charMap.get('G'));
                        break;
                    case 'h':
                        encode(charMap.get('H'));
                        break;
                    case 'i':
                        encode(charMap.get('I'));
                        break;
                    case 'j':
                        encode(charMap.get('J'));
                        break;
                    case 'k':
                        encode(charMap.get('K'));
                        break;
                    case 'l':
                        encode(charMap.get('L'));
                        break;
                    case 'm':
                        encode(charMap.get('M'));
                        break;
                    case 'n':
                        encode(charMap.get('N'));
                        break;
                    case 'o':
                        encode(charMap.get('O'));
                        break;
                    case 'p':
                        encode(charMap.get('P'));
                        break;
                    case 'q':
                        encode(charMap.get('Q'));
                        break;
                    case 'r':
                        encode(charMap.get('R'));
                        break;
                    case 's':
                        encode(charMap.get('S'));
                        break;
                    case 't':
                        encode(charMap.get('T'));
                        break;
                    case 'u':
                        encode(charMap.get('U'));
                        break;
                    case 'v':
                        encode(charMap.get('V'));
                        break;
                    case 'w':
                        encode(charMap.get('W'));
                        break;
                    case 'x':
                        encode(charMap.get('X'));
                        break;
                    case 'y':
                        encode(charMap.get('Y'));
                        break;
                    case 'z':
                        encode(charMap.get('Z'));
                        break;
                    case ' ':
                        encode(charMap.get('_'));
                        break;
                }

                try {
                    Thread.sleep(WAIT * 3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            //this method will be running on UI thread

            pdLoading.dismiss();
        }

    }

}


