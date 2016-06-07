package jp.ac.dendai.c.jtp.xmlpaersetest;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Xml;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParser;
import android.util.Log;
import android.app.Activity;

import java.io.IOException;
import java.util.HashMap;

import jp.ac.dendai.c.jtp.xmlpaersetest.XmlParser.ParseScene;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Game game = new Game(this);
    }
}