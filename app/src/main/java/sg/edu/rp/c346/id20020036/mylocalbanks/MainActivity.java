package sg.edu.rp.c346.id20020036.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;

    String clicked = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.tvDBS);
        tvOCBC = findViewById(R.id.tvOCBC);
        tvUOB = findViewById(R.id.tvUOB);

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.EnglishSelection)
        {
            tvDBS.setText("DBS");
            tvOCBC.setText("OCBC");
            tvUOB.setText("UOB");
            return true;
        }
        else if (id == R.id.ChineseSelection)
        {
            tvDBS.setText("星展银行");
            tvOCBC.setText("华侨银行");
            tvUOB.setText("大华银行");
            return true;
        }
        else
        {
            tvDBS.setText("Error Translation!");
            tvOCBC.setText("Error Translation!");
            tvUOB.setText("Error Translation!");
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(v == tvDBS)
        {
            clicked = "dbs";
        }
        else if(v == tvOCBC)
        {
            clicked = "ocbc";
        }
        else if(v == tvUOB)
        {
            clicked = "uob";
        }

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the Bank");
        menu.add(0,2,2,"Toggle Favourite");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(clicked.equalsIgnoreCase("dbs"))
        {
            if(item.getItemId() == 0)
            {
                Toast.makeText(MainActivity.this, "'Website' chosen", Toast.LENGTH_SHORT).show();
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intentWeb);
                return true;
            }
            else if(item.getItemId() == 1)
            {
                Toast.makeText(MainActivity.this, "'Contact the Bank' chosen", Toast.LENGTH_SHORT).show();
                Intent intentDial = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+"18001111111"));
                startActivity(intentDial);
                return true;
            }
            else if(item.getItemId() == 2)
            {
                Toast.makeText(MainActivity.this, "'Toggle Favourite' chosen", Toast.LENGTH_SHORT).show();
                tvDBS.setTextColor(Color.parseColor("#FFFF0000"));
                tvOCBC.setTextColor(Color.parseColor("#FF000000"));
                tvUOB.setTextColor(Color.parseColor("#FF000000"));
            }
        }
        else if(clicked.equalsIgnoreCase("ocbc"))
        {
            if(item.getItemId() == 0)
            {
                Toast.makeText(MainActivity.this, "'Website' chosen", Toast.LENGTH_SHORT).show();
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intentWeb);
                return true;
            }
            else if(item.getItemId() == 1)
            {
                Toast.makeText(MainActivity.this, "'Contact the Bank' chosen", Toast.LENGTH_SHORT).show();
                Intent intentDial = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+"18003633333"));
                startActivity(intentDial);
                return true;
            }
            else if(item.getItemId() == 2)
            {
                Toast.makeText(MainActivity.this, "'Toggle Favourite' chosen", Toast.LENGTH_SHORT).show();
                tvOCBC.setTextColor(Color.parseColor("#FFFF0000"));
                tvDBS.setTextColor(Color.parseColor("#FF000000"));
                tvUOB.setTextColor(Color.parseColor("#FF000000"));
            }
        }
        else if(clicked.equalsIgnoreCase("uob"))
        {
            if(item.getItemId() == 0)
            {
                Toast.makeText(MainActivity.this, "'Website' chosen", Toast.LENGTH_SHORT).show();
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intentWeb);
                return true;
            }
            else if(item.getItemId() == 1)
            {
                Toast.makeText(MainActivity.this, "'Contact the Bank' chosen", Toast.LENGTH_SHORT).show();
                Intent intentDial = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+"18002222121"));
                startActivity(intentDial);
                return true;
            }
            else if(item.getItemId() == 2)
            {
                Toast.makeText(MainActivity.this, "'Toggle Favourite' chosen", Toast.LENGTH_SHORT).show();
                tvUOB.setTextColor(Color.parseColor("#FFFF0000"));
                tvOCBC.setTextColor(Color.parseColor("#FF000000"));
                tvDBS.setTextColor(Color.parseColor("#FF000000"));
            }
        }
        return super.onContextItemSelected(item);
    }
}