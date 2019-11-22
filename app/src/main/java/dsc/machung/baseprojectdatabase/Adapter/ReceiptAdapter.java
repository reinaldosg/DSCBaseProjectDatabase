package dsc.machung.baseprojectdatabase.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import dsc.machung.database.Model.ReceiptModel;
import dsc.machung.database.R;

public class ReceiptAdapter extends RecyclerView.Adapter<ReceiptAdapter.ReceiptViewHolder> {

    ArrayList<ReceiptModel> receiptItem;
    DatabaseReference database;

    public ReceiptAdapter(ArrayList<ReceiptModel> receiptItem, DatabaseReference database){
        this.receiptItem = receiptItem;
        this.database = database;
    }

    @NonNull
    @Override
    public ReceiptViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.receipt_item, parent, false);
        return new ReceiptViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReceiptViewHolder holder, final int position) {
        holder.receiptId.setText(receiptItem.get(position).getId());
        holder.receiptDate.setText(receiptItem.get(position).getDate());
        holder.receiptName.setText(receiptItem.get(position).getName());
        holder.receiptAddress.setText(receiptItem.get(position).getAddress());
        holder.receiptStatus.setText(receiptItem.get(position).getStatus());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ReceiptModel receiptModel = receiptItem.get(position);
                receiptModel.setStatus("Delivered");
                database.child(receiptModel.getMilis()+"").setValue(receiptModel);
            }
        });
    }

    @Override
    public int getItemCount() {
        return receiptItem.size();
    }

    public class ReceiptViewHolder extends RecyclerView.ViewHolder {
        TextView receiptId;
        TextView receiptDate;
        TextView receiptName;
        TextView receiptAddress;
        TextView receiptStatus;
        public ReceiptViewHolder(@NonNull View itemView) {
            super(itemView);
            receiptId = itemView.findViewById(R.id.receipt_id);
            receiptAddress = itemView.findViewById(R.id.receipt_address);
            receiptDate = itemView.findViewById(R.id.receipt_date);
            receiptName = itemView.findViewById(R.id.receipt_name);
            receiptStatus = itemView.findViewById(R.id.receipt_status);
        }
    }
    public ArrayList<ReceiptModel> getReceiptItem() {
        return receiptItem;
    }

    public void setReceiptItem(ArrayList<ReceiptModel> receiptItem) {
        this.receiptItem = receiptItem;
    }
}
