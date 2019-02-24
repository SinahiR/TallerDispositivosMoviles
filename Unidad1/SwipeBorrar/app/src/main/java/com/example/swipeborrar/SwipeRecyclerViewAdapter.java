package com.example.swipeborrar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.swipe.SwipeLayout;
import com.daimajia.swipe.adapters.RecyclerSwipeAdapter;

import java.util.ArrayList;

public class SwipeRecyclerViewAdapter extends RecyclerSwipeAdapter<SwipeRecyclerViewAdapter.SimpleViewHolder> {

    private Context mContext;
    private ArrayList<YoutuberModel> studentList;

    public SwipeRecyclerViewAdapter(Context context, ArrayList<YoutuberModel> objects) {
        this.mContext = context;
        this.studentList = objects;
    }

    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.swipe_layout, parent, false);
        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final SimpleViewHolder viewHolder, final int position) {
        final YoutuberModel item = studentList.get(position);

        viewHolder.nombre.setText(item.getNombre());
        viewHolder.control.setText(item.getControl());
        viewHolder.carrera.setText(item.getCarrera());
        viewHolder.basura.setImageResource(item.getBasura());
        viewHolder.swipeLayout.setShowMode(SwipeLayout.ShowMode.PullOut);

        //dari kiri
        viewHolder.swipeLayout.addDrag(SwipeLayout.DragEdge.Left, viewHolder.swipeLayout.findViewById(R.id.bottom_wrapper1));

        //dari kanan
        viewHolder.swipeLayout.addDrag(SwipeLayout.DragEdge.Right, viewHolder.swipeLayout.findViewById(R.id.bottom_wraper));
        viewHolder.swipeLayout.addSwipeListener(new SwipeLayout.SwipeListener() {
            @Override
            public void onStartOpen(SwipeLayout layout) {

            }

            @Override
            public void onOpen(SwipeLayout layout) {

            }

            @Override
            public void onStartClose(SwipeLayout layout) {

            }

            @Override
            public void onClose(SwipeLayout layout) {

            }

            @Override
            public void onUpdate(SwipeLayout layout, int leftOffset, int topOffset) {

            }

            @Override
            public void onHandRelease(SwipeLayout layout, float xvel, float yvel) {

            }
        });

        viewHolder.swipeLayout.getSurfaceView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, " Click : " + item.getNombre() + " \n" + item.getControl()+ "\n"+ item.getCarrera(), Toast.LENGTH_SHORT).show();
            }
        });

        viewHolder.btnLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Clicked on Information " + viewHolder.nombre.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        viewHolder.Share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Clicked on Share " + viewHolder.nombre.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        viewHolder.Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Clicked on Edit  " + viewHolder.nombre.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        viewHolder.Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mItemManger.removeShownLayouts(viewHolder.swipeLayout);
                studentList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, studentList.size());
                mItemManger.closeAllItems();
                Toast.makeText(v.getContext(), "Deleted " + viewHolder.nombre.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        mItemManger.bindView(viewHolder.itemView, position);
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    @Override
    public int getSwipeLayoutResourceId(int position) {
        return R.id.swipe;
    }

    public static class SimpleViewHolder extends RecyclerView.ViewHolder{
        public SwipeLayout swipeLayout;
        public TextView nombre;
        public TextView control;
        public TextView carrera;
        public TextView Delete;
        public TextView Edit;
        public TextView Share;
        public ImageButton btnLocation;
        public ImageView basura;
        public SimpleViewHolder(View itemView) {
            super(itemView);
            swipeLayout = (SwipeLayout) itemView.findViewById(R.id.swipe);
            nombre = (TextView) itemView.findViewById(R.id.nombre);
            control = (TextView) itemView.findViewById(R.id.control);
            carrera = (TextView) itemView.findViewById(R.id.carrera);
            basura = itemView.findViewById(R.id.basura);
            Delete = (TextView) itemView.findViewById(R.id.Delete);
            Edit = (TextView) itemView.findViewById(R.id.Edit);
            Share = (TextView) itemView.findViewById(R.id.Share);
            btnLocation = (ImageButton) itemView.findViewById(R.id.btnLocation);
        }
    }
}
