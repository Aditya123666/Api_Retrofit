package uinbdg.developer.journaluinapps.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import uinbdg.developer.journaluinapps.R;
import uinbdg.developer.journaluinapps.model.JournalDummy;

/**
 * Created by Nikko Eka Saputra on 10/02/2018.
 */

public class JournalAdapter extends RecyclerView.Adapter<JournalAdapter.ViewHolder> {

    private Context context;
    private List<JournalDummy> listJournal;

    public JournalAdapter(Context context, List<JournalDummy> listJournal){
        this.context = context;
        this.listJournal = listJournal;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_journal, null, false);

        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        v.setLayoutParams(layoutParams);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final JournalDummy journals = listJournal.get(position);
        holder.lblJournal.setText("journal");
        holder.tvNamaJournal.setText(journals.getJudul());
        holder.tvLastIssues.setText(journals.getLastIssue());
        holder.lblNumberIssn.setText("ISSN Number : ");
        holder.tvNumberIssn.setText(journals.getIssn());
        holder.imgCover.setImageResource(R.drawable.ic_list_black_24px); //harusnya get id cover

//        holder.cvJournal.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(context, EditSurveyActivity.class);
//                i.putExtra("idSurvey", journals.getIdSurvey().toString());
//                context.startActivity(i);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return listJournal.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cvJournal;
        private ImageView imgCover;
        private TextView lblJournal, lblNumberIssn;
        private TextView tvNamaJournal, tvLastIssues, tvNumberIssn;

        public ViewHolder(View itemView) {
            super(itemView);

            cvJournal = (CardView) itemView.findViewById(R.id.cv_survey);
            lblJournal = (TextView) itemView.findViewById(R.id.tv_label_journal);
            lblNumberIssn = (TextView) itemView.findViewById(R.id.tv_label_issn_number);
            tvNamaJournal = (TextView) itemView.findViewById(R.id.tv_judul_journal);
            tvLastIssues = (TextView) itemView.findViewById(R.id.tv_last_issues);
            tvNumberIssn = (TextView) itemView.findViewById(R.id.tv_issn_number);
            imgCover = (ImageView) itemView.findViewById(R.id.img_cover);
        }
    }
}
