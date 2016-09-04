package wmp.uksw.pl.pracalicencjacka_prototyp2.models;

/**
 * Created by MSI on 2016-01-14.
 */
public class EventRow {

    public String userImage;
    public String name;
    public String description;

    public EventRow (String imageView, String name, String description) {
        this.userImage = imageView;
        this.name = name;
        this.description = description;
    }

}
