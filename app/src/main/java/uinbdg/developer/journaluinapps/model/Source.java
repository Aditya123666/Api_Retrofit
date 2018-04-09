package uinbdg.developer.journaluinapps.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by MUL17 on 4/9/2018.
 */

public class Source {
    @SerializedName("status")
    @Expose
    private String id;

    @SerializedName("totalResults")
    @Expose
    private int name;

    private List<News> listArtikel;

}
