package com.example.arraylistsharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.arraylistsharedpreferences.model.Item;

public class OrderActivity extends AppCompatActivity {

    public static final String TAG = "OrderDetails";
    private ImageView itemImageView, incrementPlusHigh, incrementPlusMedium, incrementAverage,
            incrementPlusLow;
    private int high = 0, medium = 0, average = 0, low = 0;
    private double minPrice, lowTotal, averageTotal, mediumTotal, highTotal, mainTotal;
    private int lowQuantity, averageQuantity, mediumQuantity, highQuantity;
    private TextView itemName, quantityTVHigh, quantityTVMedium, quantityTVAverage, quantityTVLow,
            lowPrice, averagePrice, mediumPrice, highPrice, totalAmount;
    private Item item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        initView();

        /*Intent intent = getIntent();

        item = (Item) intent.getSerializableExtra("ITEM");*/

        Item item = new Item("Shirt", R.drawable.ic_launcher_background, 10);


        minPrice = item.getItemMinPrice();
        itemImageView.setImageResource(item.getItemImage());
        itemName.setText(item.getItemName() + " :");
        lowPrice.setText(("৳" + minPrice));
        averagePrice.setText(("৳" + (minPrice + 2)));
        mediumPrice.setText(("৳" + (minPrice + 5)));
        highPrice.setText(("৳" + (minPrice + 10)));


        mainTotal = highTotal + mediumTotal + averageTotal + lowTotal;
        totalAmount.setText("Total ৳" + mainTotal);
        Log.d(TAG, "Main total: " + mainTotal);

    }

    private void initView() {
        itemImageView = findViewById(R.id.imItemClassification);
        itemName = findViewById(R.id.demoItemName);
        incrementPlusHigh = findViewById(R.id.imDryCleanAndIronPlus);
        incrementPlusMedium = findViewById(R.id.imWashAndIronPlus);
        incrementAverage = findViewById(R.id.imStemIronPlus);
        incrementPlusLow = findViewById(R.id.imNormalIronPlus);
        quantityTVHigh = findViewById(R.id.tvDryCleanAndIronQuantity);
        quantityTVMedium = findViewById(R.id.tvWashAndIronQuantity);
        quantityTVAverage = findViewById(R.id.tvStemIronQuantity);
        quantityTVLow = findViewById(R.id.tvNormalIronQuantity);
        highPrice = findViewById(R.id.tvDryCleanAndIronPrice);
        mediumPrice = findViewById(R.id.tvWashAndIronPrice);
        averagePrice = findViewById(R.id.tvStemIronPrice);
        lowPrice = findViewById(R.id.tvNormalIronPrice);
        totalAmount = findViewById(R.id.tvTotalAmount);

    }

    public void incrementDryCleanAndIronQuantity(View view) {
        quantityTVHigh.setVisibility(View.VISIBLE);
        incrementPlusHigh.setVisibility(View.GONE);
        high++;
        String highQ = String.valueOf(high);
        quantityTVHigh.setText(highQ + "X");
        highQuantity = Integer.parseInt(highQ);
        highTotal = (minPrice + 10) * highQuantity;

        mainTotal = highTotal + mediumTotal + averageTotal + lowTotal;
        totalAmount.setText("Total ৳" + mainTotal);

    }

    public void incrementWashAndIronQuantity(View view) {
        quantityTVMedium.setVisibility(View.VISIBLE);
        incrementPlusMedium.setVisibility(View.GONE);
        medium++;
        String mediumQ = String.valueOf(medium);
        quantityTVMedium.setText(mediumQ + "X");
        mediumQuantity = Integer.parseInt(mediumQ);
        mediumTotal = (minPrice + 5) * mediumQuantity;

        mainTotal = highTotal + mediumTotal + averageTotal + lowTotal;
        totalAmount.setText("Total ৳" + mainTotal);

    }

    public void incrementStemIronQuantity(View view) {
        quantityTVAverage.setVisibility(View.VISIBLE);
        incrementAverage.setVisibility(View.GONE);
        average++;
        String averageQ = String.valueOf(average);
        quantityTVAverage.setText(averageQ + "X");
        averageQuantity = Integer.parseInt(averageQ);
        averageTotal = (minPrice + 2) * averageQuantity;

        mainTotal = highTotal + mediumTotal + averageTotal + lowTotal;
        totalAmount.setText("Total ৳" + mainTotal);

    }

    public void incrementNormalIronQuantity(View view) {
        quantityTVLow.setVisibility(View.VISIBLE);
        incrementPlusLow.setVisibility(View.GONE);
        low++;
        String lowQ = String.valueOf(low);
        quantityTVLow.setText(lowQ + "X");
        lowQuantity = Integer.parseInt(lowQ);
        lowTotal = minPrice * lowQuantity;

        mainTotal = highTotal + mediumTotal + averageTotal + lowTotal;
        totalAmount.setText("Total ৳" + mainTotal);

    }

    public void decrementDryCleanAndIron(View view) {
        if (high > 0) {
            high--;
            String highQ = String.valueOf(high);
            quantityTVHigh.setText(highQ + "X");
            highQuantity = Integer.parseInt(highQ);
            highTotal = (minPrice + 10) * highQuantity;
            Log.d(TAG, "high total: " + highTotal);
            mainTotal = highTotal + mediumTotal + averageTotal + lowTotal;
            totalAmount.setText("Total ৳" + mainTotal);
            Log.d(TAG, "Main total: " + mainTotal);

        }
        if (high == 0) {
            incrementPlusHigh.setVisibility(View.VISIBLE);
            quantityTVHigh.setVisibility(View.GONE);
        }
    }

    public void decrementWashAndIron(View view) {
        if (medium > 0) {
            medium--;
            String mediumQ = String.valueOf(medium);
            quantityTVMedium.setText(mediumQ + "X");
            mediumQuantity = Integer.parseInt(mediumQ);
            mediumTotal = (minPrice + 5) * mediumQuantity;
            Log.d(TAG, "medium total: " + mediumTotal);
            mainTotal = highTotal + mediumTotal + averageTotal + lowTotal;
            totalAmount.setText("Total ৳" + mainTotal);
            Log.d(TAG, "Main total: " + mainTotal);
        }
        if (medium == 0) {
            incrementPlusMedium.setVisibility(View.VISIBLE);
            quantityTVMedium.setVisibility(View.GONE);
        }
    }

    public void decrementStemIron(View view) {
        if (average > 0) {
            average--;
            String averageQ = String.valueOf(average);
            quantityTVAverage.setText(averageQ + "X");
            averageQuantity = Integer.parseInt(averageQ);
            averageTotal = (minPrice + 2) * averageQuantity;
            Log.d(TAG, "avg total: " + averageTotal);
            mainTotal = highTotal + mediumTotal + averageTotal + lowTotal;
            totalAmount.setText("Total ৳" + mainTotal);
            Log.d(TAG, "Main total: " + mainTotal);
        }
        if (average == 0) {
            incrementAverage.setVisibility(View.VISIBLE);
            quantityTVAverage.setVisibility(View.GONE);
        }
    }

    public void decrementNormalIron(View view) {
        if (low > 0) {
            low--;
            String lowQ = String.valueOf(low);
            quantityTVLow.setText(lowQ + "X");
            lowQuantity = Integer.parseInt(lowQ);
            lowTotal = minPrice * lowQuantity;
            Log.d(TAG, "low total: " + lowTotal);
            mainTotal = highTotal + mediumTotal + averageTotal + lowTotal;
            totalAmount.setText("Total ৳" + mainTotal);
            Log.d(TAG, "Main total: " + mainTotal);
        }
        if (low == 0) {
            incrementPlusLow.setVisibility(View.VISIBLE);
            quantityTVLow.setVisibility(View.GONE);
        }
    }
}
