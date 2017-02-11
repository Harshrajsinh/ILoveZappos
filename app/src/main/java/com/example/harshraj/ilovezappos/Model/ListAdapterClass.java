package com.example.harshraj.ilovezappos.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.example.harshraj.ilovezappos.R;

import java.util.List;

/**
 * Created by Harshraj on 09-02-2017.
 */
public class ListAdapterClass extends ArrayAdapter<ItemDescription> {

    public Context context;
    public List<ItemDescription> list;

    TextView title,subTitle,price;
    ImageView imageView;

    public ListAdapterClass(Context context, int resource, List<ItemDescription> objects) {
        super(context, resource, objects);
        this.context =context;
        this.list =objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ItemDescription itemDescription = list.get(position);
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.list_layout,null);

        title = (TextView)view.findViewById(R.id.mainTitle);
        subTitle = (TextView)view.findViewById(R.id.subTitle);
        imageView = (ImageView)view.findViewById(R.id.imageTitle);
        price = (TextView)view.findViewById(R.id.price);


        title.setText(itemDescription.getProductName());
        subTitle.setText(itemDescription.getBrandName());
        price.setText(itemDescription.getPrice());

        AQuery aq = new AQuery(view);
        aq.id(R.id.imageTitle).image(itemDescription.getThumbnailImageUrl(),false,false,200,0);
        return view;
    }
}
