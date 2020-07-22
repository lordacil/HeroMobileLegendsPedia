package dicoding.rizkynugrahaherliyanto.com.heromobilelegendspedia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailHero extends AppCompatActivity {
    //ImageView imageView
    TextView name,role,special,gold,diamond,nmskill1,nmskill2,nmskill3,nmskill4,descskill1,descskill2,descskill3,descskill4;
    ImageView imgPhoto,imgskill1,imgskill2,imgskill3,imgskill4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hero);
        name = findViewById(R.id.name);
        role = findViewById(R.id.role);
        imgPhoto = findViewById(R.id.picture);
        special = findViewById(R.id.special);
        gold = findViewById(R.id.gold);
        diamond = findViewById(R.id.diamond);
        nmskill1 = findViewById(R.id.namaskill1);
        nmskill2 = findViewById(R.id.namaskill2);
        nmskill3 = findViewById(R.id.namaskill3);
        nmskill4 = findViewById(R.id.namaskill4);
        imgskill1 = findViewById(R.id.gambarskill1);
        imgskill2 = findViewById(R.id.gambarskill2);
        imgskill3 = findViewById(R.id.gambarskill3);
        imgskill4 = findViewById(R.id.gambarskill4);
        descskill1 = findViewById(R.id.descskill1);
        descskill2 = findViewById(R.id.descskill2);
        descskill3 = findViewById(R.id.descskill3);
        descskill4 = findViewById(R.id.descskill4);


        Intent i = getIntent();
        String names = i.getStringExtra("name");
        String roles = i.getStringExtra("role");
        String imageurl = i.getStringExtra("img");
        String specials = i.getStringExtra("special");
        String golds = i.getStringExtra("gold");
        String diamonds = i.getStringExtra("diamond");
        String nmskills1 = i.getStringExtra("nama1");
        String nmskills2 = i.getStringExtra("nama2");
        String nmskills3 = i.getStringExtra("nama3");
        String nmskills4 = i.getStringExtra("nama4");
        String imgskills1 = i.getStringExtra("gambar1");
        String imgskills2 = i.getStringExtra("gambar2");
        String imgskills3 = i.getStringExtra("gambar3");
        String imgskills4 = i.getStringExtra("gambar4");
        String descskills1 = i.getStringExtra("desc1");
        String descskills2 = i.getStringExtra("desc2");
        String descskills3 = i.getStringExtra("desc3");
        String descskills4 = i.getStringExtra("desc4");

        name.setText(names);
        role.setText(roles);
        Glide.with(this)
                .load(imageurl)
                .apply(new RequestOptions().override(100,100))
                .into(imgPhoto);
        special.setText(specials);
        gold.setText(golds);
        diamond.setText(diamonds);
        nmskill1.setText(nmskills1);
        nmskill2.setText(nmskills2);
        nmskill3.setText(nmskills3);
        nmskill4.setText(nmskills4);
        Glide.with(this)
                .load(imgskills1)
                .apply(new RequestOptions().override(400,400))
                .into(imgskill1);
        Glide.with(this)
                .load(imgskills2)
                .apply(new RequestOptions().override(400,400))
                .into(imgskill2);
        Glide.with(this)
                .load(imgskills3)
                .apply(new RequestOptions().override(400,400))
                .into(imgskill3);
        Glide.with(this)
                .load(imgskills4)
                .apply(new RequestOptions().override(400,400))
                .into(imgskill4);
        descskill1.setText(descskills1);
        descskill2.setText(descskills2);
        descskill3.setText(descskills3);
        descskill4.setText(descskills4);


    }
}
