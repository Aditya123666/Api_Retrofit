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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uinbdg.developer.journaluinapps.R;
import uinbdg.developer.journaluinapps.adapter.JournalAdapter;
import uinbdg.developer.journaluinapps.api.BaseApiService;
import uinbdg.developer.journaluinapps.api.UtilsApi;
import uinbdg.developer.journaluinapps.model.JournalDummy;
import uinbdg.developer.journaluinapps.model.News;
import uinbdg.developer.journaluinapps.model.Source;

/**
 * A simple {@link Fragment} subclass.
 */
public class JournalFragment extends Fragment {

    //data dummy
//    String[] judul = {"Jurnal Nomor 1", "Jurnal Nomor 2", "Jurnal Nomor 3"};
//    int [] coverId = {R.drawable.ic_list_black_24px, R.drawable.ic_list_black_24px, R.drawable.ic_list_black_24px};
//    String[] lastIssue = {"Issues 1", "Issues 2", "Issues 3"};
//    String[] issn = {"00010001", "00020002", "00030003"};

    private RecyclerView rvJournal;
    private JournalAdapter adapter;
    List<Source> listJournal = new ArrayList<>();
   // private final LinkedList<RiwayatCuti> listRiwayatCuti = new LinkedList<>();

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

       // refresh();
        getNew();


        return view;
    }

    private void getNew() {
        String token ="59e46ff28c8a4e51bc4f317f1c59c705";
        Call<Source> call = UtilsApi.getAPIService().getSource(token);

        call.enqueue(new Callback<Source>() {
            @Override
            public void onResponse(Call<Source> call, Response<Source> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(getContext(), "", Toast.LENGTH_LONG).show();
                    Source news = response.body();
                    String deskripsi = news.getDescription();
                    String title = news.getTitle();
                    String url = news.getUrl();
                    listJournal.add(new News(title, url,deskripsi));

                } else {
                    Toast.makeText(getContext(), "check your Email or Password", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Source> call, Throwable t) {
                Toast.makeText(getContext(), "Koneksi internet bermasalah", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void refresh(){

//        for(int i=0;i<3;i++){
//            listJournal.add(new JournalDummy(judul[i], coverId[i], lastIssue[i], issn[i]));
//        }
//        for(int i=0;i<3;i++){
//           listJournal.add(new List<News> );
//        }
    }

}
