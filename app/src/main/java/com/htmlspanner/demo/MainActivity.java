package com.htmlspanner.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import net.nightwhistler.htmlspanner.HtmlSpanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.text_view);
        textView.setText((new HtmlSpanner()).fromHtml
                ("<p><strong>CDR Contents</strong> - A call detail record contains metadata – that is.</p>\n" +
                        "    <p>data about data – containing ... <span style=\"font-size:57px; color:green;\">but " +
                        "does not</span> include the content of that transaction.</p>"));
    }
}
