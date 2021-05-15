package com.example.h10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView tv1,tv2;
    WebView wV;

    int a, b, c;
    int des;
    double ans1,ans2 = -999.0;
    String an = "X1 =";
    String an2 = "X2 =";
    String strUrl ="";
    Intent wi;
    boolean pos = true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent gi = getIntent();
        a = gi.getIntExtra("num",1);
        b = gi.getIntExtra("num2",1);
        c = gi.getIntExtra("num3",1);
        tv1 = (TextView) findViewById(R.id.x1);
        tv2 = (TextView) findViewById(R.id.x2);
        wV = (WebView) findViewById(R.id.wbv);
        wV.getSettings().setJavaScriptEnabled(true);
        Quadratic_equation();


    }
    public void Quadratic_equation(){
        des = b*b -4*a*c;
        if (des > 0){
            ans1 = (-1*b + Math.pow(des,0.5))/(2*a);
            ans2 = (-1*b - Math.pow(des,0.5))/(2*a);
            ans1 = Math.round(ans1*1000)/1000.0;
            ans2 = Math.round(ans2*1000)/1000.0;
            an += String.valueOf(ans1);
            an2 += String.valueOf(ans2);
        }
        else if (des == 0){
            ans1 = -b / (2 * a);
            ans1 = Math.round(ans1*1000)/100.0;
            an += String.valueOf(ans1);
            an2 += "-----";
            ans2 = ans1;
        }
        else{
            pos = false;
            an += "-----";
            an2 += "-----";
        }
        tv1.setText(an);
        tv2.setText(an2);
        show_web();
    }
    public void show_web(){
        if (pos == true){
            strUrl+="https://www.google.com/search?q=";
            strUrl+=String.valueOf(a);
            strUrl+="x%5E2+";
            strUrl+=String.valueOf(b);
            strUrl+="x+%2B";
            strUrl+=String.valueOf(c);
            strUrl+="&oq=";
            strUrl+=String.valueOf(a);
            strUrl+="x%5E2+";
            strUrl+=String.valueOf(b);
            strUrl+="x+%2B";
            strUrl+=String.valueOf(c);
            strUrl+="&aqs=chrome..69i57.31306j0j15&sourceid=chrome&ie=UTF-8";
            System.out.println(strUrl);
            wV.loadUrl(strUrl);
            wV.setWebViewClient(new MyWebViewClient());
        }

    }

    public void ret(View view) {
        wi = new Intent(this,MainActivity.class);

        wi.putExtra("x1",ans1);
        wi.putExtra("x2",ans2);

        setResult(RESULT_OK,wi);
        finish();

    }


    public class MyWebViewClient extends WebViewClient {
        public boolean shouldOverideUrlLoading(WebView view, String url) {
            view.loadUrl(strUrl);
            return true;
        }
    }
}