package com.example.foodex;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class Menu extends AppCompatActivity implements ItemListAdapter.ItemClicked {
    Button btnHome,btnOrder,btnConfirm,btnBack;
    TextView tvItem,tvPrice;
    TextView tvPlus,tvMinus,tvQuantity;



    ImageView ivMake;
    FragmentManager fragmentManager;
    Fragment buttonFrag,listFrag,OrderDetailFrag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btnHome=findViewById(R.id.btnHome);
        btnOrder=findViewById(R.id.btnOrder);
        tvItem=findViewById(R.id.tvItem);
        tvPrice=findViewById(R.id.tvPrice);
        ivMake=findViewById(R.id.ivMake);
        tvPlus=findViewById(R.id.tvPlus);
        tvMinus=findViewById(R.id.tvMinus);
        tvQuantity=findViewById(R.id.tvQuantity);
        btnBack=findViewById(R.id.btnBack);

        tvPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number=tvQuantity.getText().toString().trim();
                String price=tvPrice.getText().toString().trim();
                int quntity=Integer.parseInt(number);
                int Amount=Integer.parseInt(price);
                int perAmount=Amount/quntity;
                quntity=quntity+1;
                Amount=perAmount*quntity;
                tvQuantity.setText(String.valueOf(quntity));
                tvPrice.setText(String.valueOf(Amount));}


        });
        tvMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number=tvQuantity.getText().toString().trim();
                String price=tvPrice.getText().toString().trim();
                int quntity=Integer.parseInt(number);
                int Amount=Integer.parseInt(price);
                int perAmount=Amount/quntity;
                if(quntity<2)
                {
                    Toast.makeText(Menu.this,"Wrong Attempt",Toast.LENGTH_SHORT).show();}
                else
                {
                    quntity=quntity-1;
                    Amount=Amount-perAmount;
                    tvPrice.setText(String.valueOf(Amount));
                    tvQuantity.setText(String.valueOf(quntity));





                }

            }
        });
        ActionBar actionBar=getSupportActionBar();
        // actionBar.setSubtitle("Welcome to our App");
        actionBar.setTitle("Fab Care    ");
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        btnConfirm=findViewById(R.id.btnConfirm);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Menu.this, Payment.class);
                startActivity(intent);
            }
        });
        fragmentManager=getSupportFragmentManager();
        listFrag=fragmentManager.findFragmentById(R.id.listFrag);
        buttonFrag=fragmentManager.findFragmentById(R.id.buttonFrag);
        OrderDetailFrag=fragmentManager.findFragmentById(R.id.OrderDetailFrag);
        fragmentManager.beginTransaction()
                .show(listFrag)
                .hide(OrderDetailFrag)
                .show(buttonFrag)
                .commit();
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Menu.this,Home.class);
                startActivity(intent);


            }
        });


        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction()
                        .hide(listFrag)
                        .show(OrderDetailFrag)
                        .hide(buttonFrag)
                        .commit();



            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction()
                        .show(listFrag)
                        .hide(OrderDetailFrag)
                        .show(buttonFrag)
                        .commit();

            }
        });
        onItemClicked(0);
    }


    @Override
    public void onItemClicked(int index) {
        tvPrice.setText(ApplicationClass.item.get(index).getItemPrice());
        tvItem.setText(ApplicationClass.item.get(index).getItemName());

        if(ApplicationClass.item.get(index).getMake().equals("dress"))
        {
            ivMake.setImageResource(R.drawable.dress);
        }
        else if(ApplicationClass.item.get(index).getMake().equals("hoodie"))
        {
            ivMake.setImageResource(R.drawable.hoodie);
        }
        else if(ApplicationClass.item.get(index).getMake().equals("skirt"))
        {
            ivMake.setImageResource(R.drawable.skirt);
        }
        else if(ApplicationClass.item.get(index).getMake().equals("traditional"))
        {
            ivMake.setImageResource(R.drawable.traditional);
        }
        else if(ApplicationClass.item.get(index).getMake().equals("westernwear"))
        {
            ivMake.setImageResource(R.drawable.westernwear);
        }


        else if(ApplicationClass.item.get(index).getMake().equals("sportwear"))
        {
            ivMake.setImageResource(R.drawable.sportwear);
        }
        else if(ApplicationClass.item.get(index).getMake().equals("jumpsuit"))
        {
            ivMake.setImageResource(R.drawable.jumpsuit);
        }
        else if(ApplicationClass.item.get(index).getMake().equals("jeans"))
        {
            ivMake.setImageResource(R.drawable.jeans);
        }
        else if(ApplicationClass.item.get(index).getMake().equals("formal"))
        {
            ivMake.setImageResource(R.drawable.formal);
        }


        else
        {
            ivMake.setImageResource(R.drawable.tshirt);
        }


    }
}

