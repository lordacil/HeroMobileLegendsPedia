package dicoding.rizkynugrahaherliyanto.com.heromobilelegendspedia;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class AdapterHeroes extends RecyclerView.Adapter<AdapterHeroes.ListViewHolder> {
    ArrayList<Heroes> listhero;

    public AdapterHeroes(ArrayList<Heroes> list) {
        this.listhero = list;

    }
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_hero, viewGroup, false);
        return new ListViewHolder(view);
    }

    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback nItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, final int position) {
        final Heroes hero = listhero.get(position);
        Glide.with(holder.itemView.getContext())
                .load(hero.getPhoto())
                .apply(new RequestOptions().override(350,550))
                .into(holder.imgPhoto);

        holder.tvNama.setText(hero.getNama());
        holder.tvRole.setText(hero.getRole()); =
        holder.tvSpecial.setText(hero.getSpecial());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),DetailHero.class);
                i.putExtra("name", hero.getNama());
                i.putExtra("role",hero.getRole());
                i.putExtra("img",hero.getPhoto());
                i.putExtra("special",hero.getSpecial());
                i.putExtra("gold",hero.getGold());
                i.putExtra("diamond",hero.getDiamond());
                i.putExtra("nama1",hero.getNmskill1());
                i.putExtra("nama2",hero.getNmskill2());
                i.putExtra("nama3",hero.getNmskill3());
                i.putExtra("nama4",hero.getNmskill4());
                i.putExtra("gambar1",hero.getImgskill1());
                i.putExtra("gambar2",hero.getImgskill2());
                i.putExtra("gambar3",hero.getImgskill3());
                i.putExtra("gambar4",hero.getImgskill4());
                i.putExtra("desc1",hero.getDecskill1());
                i.putExtra("desc2",hero.getDecskill2());
                i.putExtra("desc3",hero.getDecskill3());
                i.putExtra("desc4",hero.getDecskill4());

                v.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listhero.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvNama,tvRole,tvSpecial;

        ListViewHolder(@NonNull View itemView){
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.picture);
            tvNama = itemView.findViewById(R.id.name);
            tvRole = itemView.findViewById(R.id.role);
            tvSpecial = itemView.findViewById(R.id.special);
        }
    }

    public interface OnItemClickCallback{
        void onItemClicked(Heroes data);
    }

}
