package com.example.harshraj.ilovezappos;

import android.nfc.tech.NfcBarcode;
import android.os.Bundle;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import com.androidquery.AQuery;
import com.example.harshraj.ilovezappos.Model.ItemDescription;
import com.example.harshraj.ilovezappos.databinding.*;
import com.example.harshraj.ilovezappos.databinding.ItemDescriptionLayoutBinding;

/**
 * Created by Harshraj on 09-02-2017.
 */
public class SecondActivity extends AppCompatActivity {
    ItemDescription itemDescriptionSecond;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ItemDescriptionLayoutBinding secondBinding = DataBindingUtil.setContentView(this,R.layout.item_description_layout);
        Bundle data = getIntent().getExtras();
        itemDescriptionSecond = data.getParcelable("ItemData");
        Log.d("kasdasssssssssssssssss", itemDescriptionSecond.getOriginalPrice());
        secondBinding.setItem(itemDescriptionSecond);
        AQuery aq = new AQuery(this);
        aq.id(R.id.item_image).image(itemDescriptionSecond.getThumbnailImageUrl(),false,false,200,0);
    }
}
