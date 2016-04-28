package com.ideyatech.moove.ui.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ideyatech.moove.R;
import com.ideyatech.moove.ui.beans.Merchant;

import java.util.List;

/**
 * Created by kendeng on 4/22/2016.
 */
public class MerchantAdapter extends BaseAdapter {

    Context context;
    List<Merchant> merchantItems;

    public MerchantAdapter(Context context, List<Merchant> items) {
        this.context = context;
        this.merchantItems = items;
    }

    private class ViewHolder {
        ImageView imageView;
        TextView txtName;
        TextView txtWebsite;
        ImageView border;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        LayoutInflater mInflater = (LayoutInflater)
                context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.merchant_list, null);
            holder = new ViewHolder();
            holder.txtName = (TextView) convertView.findViewById(R.id.name);
            holder.txtWebsite = (TextView) convertView.findViewById(R.id.website);
            holder.imageView = (ImageView) convertView.findViewById(R.id.icon);
            holder.border = (ImageView) convertView.findViewById(R.id.border);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        Merchant merchantItems = (Merchant) getItem(position);

        holder.txtName.setText(merchantItems.getName());
        holder.txtWebsite.setText(merchantItems.getWebsite());
        holder.imageView.setImageResource(merchantItems.getLogoId());
        holder.border.setImageResource(R.drawable.fading_line);

        return convertView;
    }

    @Override
    public int getCount() {
        return merchantItems.size();
    }

    @Override
    public Object getItem(int position) {
        return merchantItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return merchantItems.indexOf(getItem(position));
    }
}
