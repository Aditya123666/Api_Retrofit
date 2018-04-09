package uinbdg.developer.journaluinapps.fragment;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import uinbdg.developer.journaluinapps.R;
import uinbdg.developer.journaluinapps.adapter.JournalAdapter;
import uinbdg.developer.journaluinapps.api.BaseApiService;
import uinbdg.developer.journaluinapps.api.UtilsApi;
import uinbdg.developer.journaluinapps.model.JournalDummy;

/**
 * A simple {@link Fragment} subclass.
 */
public class JournalFragment extends Fragment {

    //data dummy
    String[] judul = {"Jurnal Nomor 1", "Jurnal Nomor 2", "Jurnal Nomor 3"};
    int [] coverId = {R.drawable.ic_list_black_24px, R.drawable.ic_list_black_24px, R.drawable.ic_list_black_24px};
    String[] lastIssue = {"Issues 1", "Issues 2", "Issues 3"};
    String[] issn = {"00010001", "00020002", "00030003"};

    private RecyclerView rvJournal;
    private JournalAdapter adapter;
    List<JournalDummy> listJournal = new ArrayList<>();

    ProgressDialog loading;

    public JournalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jurnal, container, false);

        rvJournal = (RecyclerView) view.findViewById(R.id.rv_journal);

        adapter = new JournalAdapter(getContext(), listJournal);

        rvJournal.setHasFixedSize(true);
        rvJournal.setLayoutManager(new LinearLayoutManager(getContext()));
        rvJournal.setAdapter(adapter);

        refresh();

        return view;
    }

    public void refresh(){

        for(int i=0;i<3;i++){
            listJournal.add(new JournalDummy(judul[i], coverId[i], lastIssue[i], issn[i]));
        }
    }

}
