package comfirebasestudentapp.example.a15056158.outletfypcrud;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 15056158 on 26/7/2017.
 */

public class outletAdatper extends ArrayAdapter<outlet> {

    Context context;
    int layoutResourceId;
    ArrayList<outlet> outletList = null;


    public outletAdatper(Context context, int resource, ArrayList<outlet> objects) {
        super(context, resource, objects);
        this.context = context;
        this.layoutResourceId = resource;
        this.outletList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        outletHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new outletHolder();
            holder.OutletName = (TextView)row.findViewById(R.id.txtOutletName);
            holder.OutletLocation = (TextView)row.findViewById(R.id.txtOutletLocation);

            row.setTag(holder);
        }
        else
        {
            holder = (outletHolder)row.getTag();
        }

        outlet outlet = outletList.get(position);
        holder.OutletName.setText(outlet.getoutletName());
        holder.OutletLocation.setText(outlet.getoutletLocation());
        return row;
    }

    static class outletHolder
    {
        TextView OutletName;
        TextView OutletLocation;
    }



}

