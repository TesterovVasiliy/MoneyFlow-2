package com.rash1k.moneyflow.adapters;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rash1k.moneyflow.R;
import com.rash1k.moneyflow.util.Prefs;


public class IncomesAdapter extends RecyclerView.Adapter<IncomesAdapter.InnerViewHolder> {

    Context mContext;
    Cursor mCursor;

    public IncomesAdapter(Context context, Cursor cursor) {
        this.mContext = context;
        this.mCursor = cursor;
    }


    @Override
    public InnerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_incomes_adapter, parent, false);


        return new InnerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(InnerViewHolder holder, int position) {
           mCursor.moveToPosition(position);

        holder.tvName.setText(mCursor.getString(mCursor.getColumnIndex(Prefs.INCOME_NAMES_FIELD_NAME)));
        holder.tvVolume.setText(mCursor.getString(mCursor.getColumnIndex(Prefs.INCOMES_FIELD_VOLUME)));
        holder.tvDate.setText(mCursor.getString(mCursor.getColumnIndex(Prefs.INCOMES_FIELD_DATE)));
    }

    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }

    public class InnerViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        TextView tvVolume;
        TextView tvDate;

        public InnerViewHolder(View itemView) {
            super(itemView);

            tvName = (TextView) itemView.findViewById(R.id.tvNameItemIncomes);
            tvVolume = (TextView) itemView.findViewById(R.id.tvVolumeItemIncomes);
            tvDate = (TextView) itemView.findViewById(R.id.tvDateItemIncomes);
        }
    }
}
