package com.example.harshraj.ilovezappos.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Harshraj on 08-02-2017.
 */
public class ItemDescription implements Parcelable {
    String brandName;
    int productId;
    String originalPrice;
    int styleId;
    int colorId;
    String price;
    String percentOff;
    String productUrl;
    String productName;
    String thumbnailImageUrl;


    //Getter Methods
    public int getColorId() {
        return colorId;
    }

    public int getProductId() {
        return productId;
    }

    public int getStyleId() {
        return styleId;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public String getPercentOff() {
        return percentOff;
    }

    public String getPrice() {
        return price;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public String getThumbnailImageUrl() {
        return thumbnailImageUrl;
    }

    //Setter Methods
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setPercentOff(String percentOff) {
        this.percentOff = percentOff;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public void setStyleId(int styleId) {
        this.styleId = styleId;
    }

    public void setThumbnailImageUrl(String thumbnailImageUrl) {
        this.thumbnailImageUrl = thumbnailImageUrl;
    }

    public ItemDescription(){}

    public ItemDescription(Parcel in){
        String[] data = new String[10];

        in.readStringArray(data);
        this.brandName = data[0];
        this.thumbnailImageUrl = data[1];
        this.productId = Integer.parseInt(data[2]);
        this.originalPrice = data[3];
        this.styleId = Integer.parseInt(data[4]);
        this.colorId = Integer.parseInt(data[5]);
        this.price = data[6];
        this.percentOff = data[7];
        this.productUrl = data[8];
        this.productName = data[9];
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[]{
                this.brandName,
                this.thumbnailImageUrl,
                String.valueOf(this.productId),
                this.originalPrice,
                String.valueOf(this.styleId),
                String.valueOf(this.colorId),
                this.price,
                this.percentOff,
                this.productUrl,
                this.productName,
        });
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator(){

        @Override
        public ItemDescription createFromParcel(Parcel source) {
            return new ItemDescription(source);
        }

        @Override
        public ItemDescription[] newArray(int size) {
            return new ItemDescription[size];
        }
    };
}
