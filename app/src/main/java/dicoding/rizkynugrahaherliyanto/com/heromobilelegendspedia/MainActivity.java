package dicoding.rizkynugrahaherliyanto.com.heromobilelegendspedia;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvHeroes;
    private SearchView searchView;
    ArrayList<Heroes> list = new ArrayList<>();
    private  String title = "Daftar Hero";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setActionBarTitle(title);
        rvHeroes = findViewById(R.id.rv_hero);
        rvHeroes.setHasFixedSize(true);
        searchView = findViewById(R.id.cari);
//        CharSequence query = searchView.getQuery();
//        searchView.setQuery(query,true);

        list.addAll(ArrayDataHero.getListData());
        showRecyclerList();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    private void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.about:
                title = "About";
                final AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.dialog_about,null);
                Button btn_back = (Button)mView.findViewById(R.id.kembali);

                alert.setView(mView);

                final AlertDialog alertDialog = alert.create();
                alertDialog.setCanceledOnTouchOutside(false);

                btn_back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });
                alertDialog.show();
                break;
        }
    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    private void showAbout() {
    }


    private void showRecyclerList() {
        rvHeroes.setLayoutManager(new LinearLayoutManager(this));
        AdapterHeroes adapterHeroes = new AdapterHeroes(list);
        rvHeroes.setAdapter(adapterHeroes);

        adapterHeroes.setOnItemClickCallback(new AdapterHeroes.OnItemClickCallback() {
            @Override
            public void onItemClicked(Heroes data) {
                showSelectedHero(data);
            }
        });
    }

    private void showSelectedHero(Heroes heroes) {
        Toast.makeText(this, "Kamu memilih" + heroes.getNama(), Toast.LENGTH_SHORT).show();
    }

}
