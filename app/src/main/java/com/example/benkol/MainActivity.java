package com.example.benkol;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    int images[] = {R.drawable.oli1, R.drawable.oli2, R.drawable.oli3, R.drawable.aki1, R.drawable.aki2, R.drawable.aki3, R.drawable.ban1, R.drawable.ban2, R.drawable.ban3};
    String names[] = {"Shell HX5 15W30","X-TEN 20W50 0,8l ", "X-TEN DOUBLE ESTER","RCA BATT GM5Z-3B","RCA BATT GTZ-5S","RCA BATT GTZ-7S","Aspira Premio R14","IRC Reborn NR87","PIRELLI ANGEL CITY R17"};
    String price [] = {"Rp.60.000","Rp.50.000","Rp.45.000","Rp.120.000","Rp.200.000","Rp.340.000","Rp.250.000","Rp.300.000","Rp.500.000"};

    int i = 0;
    TextView counts;
    ImageView add,remove;
    Button checkout;
    List<ItemsModel> itemsList =new ArrayList<>();
    AlphaAnimation animation = new AlphaAnimation(1F,0F);

    GridView gridView;

    CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);

        for(int i=0; i < names.length; i++){
            ItemsModel itemsModel = new ItemsModel(names[i],price[i],images[i]);
            itemsList.add(itemsModel);
        }

        customAdapter = new CustomAdapter(itemsList, this);

        gridView.setAdapter(customAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);

        MenuItem menuItem = menu.findItem(R.id.search_view);

        SearchView searchView = (SearchView) menuItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                customAdapter.getFilter().filter(newText);

                return true;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.search_view){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void kembali(View view)
    {
        Intent intent = new Intent(this,MapsActivity.class);
        startActivity(intent);
    }

    public class CustomAdapter extends BaseAdapter implements Filterable {

        private List<ItemsModel> itemsModelList;
        private  List<ItemsModel> itemsModelListFiltered;
        private Context context;

        public CustomAdapter(List<ItemsModel> itemsModelList, Context context) {
            this.itemsModelList = itemsModelList;
            this.itemsModelListFiltered = itemsModelList;
            this.context = context;
        }

        @Override
        public int getCount() {
            return itemsModelListFiltered.size();
        }

        @Override
        public Object getItem(int posotion) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertview, ViewGroup parent) {

            View view = getLayoutInflater().inflate(R.layout.row_items, null);

            ImageView imageView = view.findViewById(R.id.imageView);
            TextView tvName = view.findViewById(R.id.tvName);
            TextView tvPrice = view.findViewById(R.id.tvPrice);
            add = view.findViewById(R.id.tambah);
            remove = view.findViewById(R.id.kurang);
            counts = findViewById(R.id.counts);
            checkout = findViewById(R.id.checkout);
            imageView.setImageResource(itemsModelListFiltered.get(position).getImage());
            tvName.setText(itemsModelListFiltered.get(position).getName());
            tvPrice.setText(itemsModelListFiltered.get(position).getPrice());

            checkout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    animation.setDuration(1000);
                    view.startAnimation(animation);
                    BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                            MainActivity.this,R.style.BottomSheetDialogTheme
                    );
                    View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(
                            R.layout.checkout, (LinearLayout) findViewById(R.id.check)
                    );

                    bottomSheetDialog.setContentView(bottomSheetView);
                    bottomSheetDialog.show();

                    Button pesan = bottomSheetView.findViewById(R.id.pesan);

                    pesan.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(MainActivity.this, PembayaranActivity.class);
                            startActivity(intent);
                        }
                    });
                }
            });

            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    animation.setDuration(1000);
                    view.startAnimation(animation);
                    String tambah;
                    i++;
                    checkout.setVisibility(View.VISIBLE);
//                    while(i<= counts.getLineCount())
//                    {
//                        i++;
//                         tambah = Integer.toString(i);
//                        Log.e("tambah",tambah);
//                        counts.setText(tambah);
//
//                    }
                    Toast.makeText(MainActivity.this, "Item berhasil ditambah", Toast.LENGTH_SHORT).show();
                    tambah = Integer.toString(i);
                    Log.e("tambah",tambah);
                    counts.setText(tambah);

                }
            });

            remove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    animation.setDuration(1000);
                    view.startAnimation(animation);
                    String kurang;
                    i--;
                    Toast.makeText(MainActivity.this,"Item berhasil dikurangi", Toast.LENGTH_SHORT).show();
                    kurang = Integer.toString(i);
                    Log.e("kurang",kurang);
                    counts.setText(kurang);
                }
            });


//            view.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    startActivity(new Intent(MainActivity.this,ItemViewActivity.class).putExtra("item",itemsModelListFiltered.get(position)));
//
//                }
//            });

            return view;
        }




        @Override
        public Filter getFilter() {
            Filter filter = new Filter() {
                @Override
                protected FilterResults performFiltering(CharSequence constraint) {

                    FilterResults filterResults = new FilterResults();

                    if (constraint == null || constraint.length() == 0 ){
                        filterResults.count = itemsModelList.size();
                        filterResults.values = itemsModelList;
                    }else {
                        String searchStr = constraint.toString().toLowerCase();
                        List<ItemsModel> resultData = new ArrayList<>();

                        for (ItemsModel itemsModel:itemsModelList){
                            if (itemsModel.getName().contains(searchStr) || itemsModel.getPrice().contains(searchStr)){
                                resultData.add(itemsModel);
                            }
                            filterResults.count = resultData.size();
                            filterResults.values = resultData;
                        }
                    }
                    return filterResults;
                }

                @Override
                protected void publishResults(CharSequence constraint, FilterResults results) {

                    itemsModelListFiltered = (List<ItemsModel>) results.values;
                    notifyDataSetChanged();

                }
            };

            return filter;
        }
    }

}
