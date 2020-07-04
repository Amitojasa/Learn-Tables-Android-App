package com.asapphub.learntables;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {

    //6.2
    private ArrayList<TableItem> mExampleList;
//    private onTodoListener todoListener;


    ///1

    public class ExampleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        //4

        public TextView eqnText,ansText;

        //2
        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);

            //4
            eqnText = itemView.findViewById(R.id.eqn);
            ansText = itemView.findViewById(R.id.ans);



//            textView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    int position =getAdapterPosition();
//                    todoListener.onTodoDisp(mExampleList.get(position),position);
//                }
//            });

        }

        @Override
        public void onClick(View view) {

        }
    }
    //6.1
    public ExampleAdapter(ArrayList<TableItem> exampleList){
        mExampleList=exampleList;


    }



    //3
    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //5
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_table_item,parent,false);
        ExampleViewHolder exampleViewHolder=new ExampleViewHolder(view);
        return exampleViewHolder;

    }



    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder exampleViewHolder, int position) {

        //7

        TableItem currentItem =mExampleList.get(position);
        exampleViewHolder.eqnText.setText(currentItem.getmTexteqn());
        exampleViewHolder.ansText.setText(currentItem.getmTextans());




    }


    @Override
    public int getItemCount() {
        //9
        Log.i("item count", String.valueOf(mExampleList.size()));
        return mExampleList.size();
    }


//    public interface onTodoListener{
//        void onTodoClicked(TableItem item,int pos);
//        void onTodoDel(TableItem item,int pos);
//        void onTodoDisp(TableItem item,int pos);
//    }

}
