package uinbdg.developer.journaluinapps.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by MUL17 on 4/9/2018.
 */

// {
//         "source": {
    //         "id": null,
    //         "name": "Forbes.com"
//         },
//         "author": null,
//         "title": "How 401(k) Trading Will Slam Your Retirement Kitty",
//         "description": null,
//         "url": "https://www.forbes.com/sites/johnwasik/2018/04/09/how-401k-trading-will-slam-your-retirement-kitty/",
//         "urlToImage": null,
//         "publishedAt": "2018-04-09T13:09:42Z"
//    }
//aditya
public class News {

    @SerializedName("source")
    @Expose
    private Source source;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("description")
    @Expose
    private String description;

    public News(String title, String url, String description) {

        this.title = title;
        this.url = url;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
//adityatutup