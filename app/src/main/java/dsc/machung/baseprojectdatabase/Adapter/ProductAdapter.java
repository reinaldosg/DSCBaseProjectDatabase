package dsc.machung.baseprojectdatabase.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import dsc.machung.database.Model.ProductModel;
import dsc.machung.database.R;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    List<ProductModel> products;

    public ProductAdapter(List<ProductModel> products){
        this.products = products;
    }

    @NonNull
    @Override
    public ProductAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item,parent,false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductViewHolder holder, int position) {
        holder.productPrice.setText(products.get(position).getPrice());
        holder.productDescription.setText(products.get(position).getDescription());
        holder.productName.setText(products.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView productName;
        TextView productDescription;
        TextView productPrice;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.product_name);
            productDescription = itemView.findViewById(R.id.product_description);
            productPrice = itemView.findViewById(R.id.product_price);
        }
    }

    public List<ProductModel> getProducts() {
        return products;
    }

    public void setProducts(List<ProductModel> products) {
        this.products = products;
    }
}
