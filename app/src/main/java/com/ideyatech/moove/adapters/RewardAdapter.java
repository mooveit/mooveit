package com.ideyatech.moove.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ideyatech.moove.R;
import com.ideyatech.moove.beans.Reward;
import com.ideyatech.moove.rewards.GU;

import java.util.List;

/**
 * Created by kendeng on 4/22/2016.
 */
public class RewardAdapter extends BaseAdapter  {

    Context context;
    List<Reward> rewardItems;

    public RewardAdapter(Context context, List<Reward> items) {
        this.context = context;
        this.rewardItems = items;
    }

    private class ViewHolder {
        ImageView imageView;
        TextView txtName;
        TextView txtMerchant;
        TextView txtDesc;
        TextView txtExp;
        ImageView border;
        Button arrow;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        LayoutInflater mInflater = (LayoutInflater)
                context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.reward_list, null);
            holder = new ViewHolder();
            holder.txtName = (TextView) convertView.findViewById(R.id.name);
            holder.txtMerchant = (TextView) convertView.findViewById(R.id.merchant);
            holder.txtDesc = (TextView) convertView.findViewById(R.id.desc);
            holder.txtExp = (TextView) convertView.findViewById(R.id.exp);
            holder.imageView = (ImageView) convertView.findViewById(R.id.icon);
            holder.border = (ImageView) convertView.findViewById(R.id.border);
            holder.arrow = (Button) convertView.findViewById(R.id.arrow);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        Reward rewardItems = (Reward) getItem(position);

        holder.txtName.setText(rewardItems.getName());
        holder.txtMerchant.setText(rewardItems.getMerchant());
        holder.txtDesc.setText(rewardItems.getDescription());
        holder.txtExp.setText(rewardItems.getExpiration());
        holder.txtExp.setTypeface(null, Typeface.ITALIC);
        holder.imageView.setImageResource(rewardItems.getImageId());
        holder.border.setImageResource(R.drawable.fading_line);
//        holder.arrow.setImageResource(R.drawable.arrow);

        return convertView;
    }

    @Override
    public int getCount() {
        return rewardItems.size();
    }

    @Override
    public Object getItem(int position) {
        return rewardItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return rewardItems.indexOf(getItem(position));
    }
}
