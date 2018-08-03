package com.example.utkar.ecommerce;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private String[] OrderNos={"1","2","3","4","5"};
    private String[] Status={"confirmed","billed","confirmed","billed","confirmed"};
    private String[] PaymentMode={"cod","cod","DebitCard","CreditCard","cod" };

    public String[] TotalAmount={"1000","200","600","7890","876"};
    public String[] Approved={"Yes","No","Yes","Yes","No"};
    Context context;

    public RecyclerAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v=inflater.inflate(R.layout.card_layout,viewGroup,false);
        ViewHolder viewHolder= new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.OrderNo.setText(OrderNos[i]);
        viewHolder.PaymentMode.setText(PaymentMode[i]);
        viewHolder.Status.setText(Status[i]);
        viewHolder.TotalAmount.setText(TotalAmount[i]);
        viewHolder.Approved.setText(Approved[i]);
    }

    @Override
    public int getItemCount() {
        return Status.length ;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView Info;
        public ImageView Downloads;
        public TextView OrderNo;
        public TextView PaymentMode;
        public TextView Approved;
        public TextView TotalAmount;
        public TextView Status;


        public ViewHolder(View itemView) {
            super(itemView);
            Info = itemView.findViewById(R.id.info_img);
            Downloads=itemView.findViewById(R.id.downloads_img);
            OrderNo=itemView.findViewById(R.id.order_no_result);
            PaymentMode=itemView.findViewById(R.id.payment_mode_result);
            Approved=itemView.findViewById(R.id.approved_result);
            TotalAmount=itemView.findViewById(R.id.total_amount_result);
            Status=itemView.findViewById(R.id.status_result);

        }
    }
}
