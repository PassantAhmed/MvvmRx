package com.iti.intake39.jad.mvvm_rx_example.screens.listscreen;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.iti.intake39.jad.mvvm_rx_example.R;
import com.iti.intake39.jad.mvvm_rx_example.data.model.AnimatedCharacter;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;

public class ListRecyclerviewAdapter extends RecyclerView.Adapter<ListRecyclerviewAdapter.MainViewHolder> {

    private List<AnimatedCharacter> dataSource;
    private Context context;
    private Disposable disposable;

    public ListRecyclerviewAdapter(BehaviorSubject<List<AnimatedCharacter>> dataSource, Context context){
        this.context = context;
        disposable = dataSource.share()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(list->notifyDataSetChanged());
        this.dataSource = dataSource.getValue();
    }

    @NonNull
    @Override
    public ListRecyclerviewAdapter.MainViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recyclerview_listactivity,viewGroup,false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder viewHolder, int i) {
        viewHolder.characterName.setText(dataSource.get(i).getName());
        RequestOptions defaultOption = new RequestOptions()
                .error(R.drawable.ic_broken_image_24dp)
                .placeholder(R.drawable.ic_launcher_foreground);
        Glide.with(context).setDefaultRequestOptions(defaultOption)
                .load(dataSource.get(i).getImageUrl())
                .into(viewHolder.characterImage);
    }

    @Override
    public int getItemCount() {
        return dataSource==null? 0 : dataSource.size();
    }

    static class MainViewHolder extends RecyclerView.ViewHolder{
        TextView characterName;
        ImageView characterImage;
        public MainViewHolder(View view){
            super(view);
            characterName = view.findViewById(R.id.characterName);
            characterImage = view.findViewById(R.id.characterImage);
        }
    }

    public Disposable getDisposable() {
        return disposable;
    }
}
