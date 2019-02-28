package com.example.ramachandrans.iraiarul;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class activity extends Activity {
    ListView l1;
    List<String> sa;
    ArrayAdapter a;
    String text = "";
    int letter,letter2='a';
    public static final String key = "display";
    InputStream is;
    InputStreamReader isr;
    BufferedReader br;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        l1 = findViewById(R.id.l1);

        String[] kaviyams={"ஸ்ரீ கவி விநாயகர்","ஒற்றியூர் ஓடக்கோல்","காலடிப்பேட்டை","திருக்கருகாவூர்","திருமலை","திருமுருகாற்பதம்","திருவல்லிக்கேணி","மருந்தீஸ்வரம்","முன்நிற்கும் முருகனருள்","ராமஜென்ம சரவியம்"};
        sa = new ArrayList<String>(Arrays.asList(kaviyams));
        a = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,sa);
        l1.setAdapter(a);
        l1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(sa.get(position).equals("ஸ்ரீ கவி விநாயகர்"))
                    is = getResources().openRawResource(R.raw.shrikavivinayagar);
                else if(sa.get(position).equals("ஒற்றியூர் ஓடக்கோல்"))
                    is = getResources().openRawResource(R.raw.ottriyur);
                else if(sa.get(position).equals("காலடிப்பேட்டை"))
                    is = getResources().openRawResource(R.raw.kaladipettai);
                else if(sa.get(position).equals("திருக்கருகாவூர்"))
                    is = getResources().openRawResource(R.raw.thirukkarugavur);
                else if(sa.get(position).equals("திருமலை"))
                    is = getResources().openRawResource(R.raw.thirumalai);
                else if(sa.get(position).equals("திருமுருகாற்பதம்"))
                    is = getResources().openRawResource(R.raw.thirumurugarpadham);
                else if(sa.get(position).equals("திருவல்லிக்கேணி"))
                    is = getResources().openRawResource(R.raw.thiruvallikeni);
                else if(sa.get(position).equals("மருந்தீஸ்வரம்"))
                    is = getResources().openRawResource(R.raw.maruntheeswaram);
                else if(sa.get(position).equals("முன்நிற்கும் முருகனருள்"))
                    is = getResources().openRawResource(R.raw.munnirkkummuruganarul);
                else if(sa.get(position).equals("ராமஜென்ம சரவியம்"))
                    is = getResources().openRawResource(R.raw.ramajanmasaraviyam);
                isr = new InputStreamReader(is);
                br = new BufferedReader(isr);
                try{
                    while ((letter=br.read())!=-1){
                        if ((char) letter == '\n')
                            text += '\n';
                        else
                            text += (char) letter;
                        letter2 = letter;
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                Intent intent = new Intent(getApplicationContext(),ActivityDisplay.class);
                intent.putExtra(key,text);
                startActivity(intent);
            }
        });
    }
}
